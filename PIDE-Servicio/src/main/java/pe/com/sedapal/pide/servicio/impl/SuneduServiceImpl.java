package pe.com.sedapal.pide.servicio.impl;

import static java.text.MessageFormat.format;


import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import pe.com.gmd.util.exception.GmdException;
import pe.com.gmd.util.exception.MensajeExceptionUtil;
import pe.com.sedapal.pide.dao.AuditoriaDao;
import pe.com.sedapal.pide.model.Auditoria;
import pe.com.sedapal.pide.servicio.ISuneduService;
import pe.com.sedapal.pide.servicio.base.BaseServiceImpl;
import pe.com.sedapal.pide.util.Constantes;
import pe.com.sedapal.pide.util.ParametrosUtil;
import pe.com.sedapal.pide.util.RespuestaBean;
import pe.com.sedapal.seguridad.core.bean.TrabajadorBean;
import pe.com.sedapal.seguridad.ws.SeguridadClienteWs;
import pe.com.sedapal.sunarp.bean.ResponseBean;
import pe.com.sedapal.sunarp.util.ConstantesCliente;

@Service
public class SuneduServiceImpl extends BaseServiceImpl<Object, Long> implements ISuneduService {

	private static final Logger LOGGER = Logger.getLogger(SuneduServiceImpl.class);

	RespuestaBean respuesta = new RespuestaBean();
	
	@Autowired
	private SeguridadClienteWs stub;
	
	@Autowired
	AuditoriaDao auditoriaDao;
	
	@Override
	public RespuestaBean consultarRNGT(Map<String, String> requestParm) throws GmdException {
		try {
			/*insert audit consulta - rramirez*/
			String username = null;
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
			}
			TrabajadorBean trabajador = stub.obtenerTrabajadorWs(username);
			Auditoria auditoria = ParametrosUtil.generateAuditoria(username, Constantes.ID_SERVICIO_SUNEDU, 
					Constantes.DES_SERVICIO_SUNEDU, Constantes.DES_CONSULTA_RNGT, trabajador);
			auditoriaDao.insertar(auditoria);
			/**/
			
			String usuario = requestParm.get("usuario");
			String clave = requestParm.get("clave");
			String idEntidad = requestParm.get("idEntidad");
			String fecha = requestParm.get("fecha");
			String hora = requestParm.get("hora");
			String mac_wsServer = requestParm.get("mac_wsServer");
			String ip_wsServer = requestParm.get("ip_wsServer");
			String ip_wsUser = requestParm.get("ip_wsUser");
			String tipDocIdentidad = requestParm.get("tipDocIdentidad");
			String nroDocIdentidad = requestParm.get("nroDocIdentidad");
			
			//A LA ESPERA DE LA IMPLEMENTACI??N DEL SERVICIO REST 
			ResponseBean retorno = null;
			//ResponseBean retorno = sunarpWs.buscarTitularidadWs(usuario, clave, idEntidad, fecha, hora, mac_wsServer, ip_wsServer,
			//ip_wsUser, tipDocIdentidad, nroDocIdentidad);
			if(retorno.getEstadoRespuesta().equals(ConstantesCliente.RESULTADO_OK)) {
				
					respuesta.setEstadoRespuesta(ConstantesCliente.RESULTADO_OK);
				respuesta.setParametros(retorno.getParametros());
			}else if(retorno.getEstadoRespuesta().equals(ConstantesCliente.RESULTADO_ERROR)) {
				respuesta.setEstadoRespuesta(ConstantesCliente.RESULTADO_ERROR);
				respuesta.setMensajeRespuesta(retorno.getMensajeRespuesta());
				throw new GmdException(retorno.getMensajeRespuesta());
			}
		} catch (Exception exception) {
			String[] error = MensajeExceptionUtil.obtenerMensajeError(exception);
			
			respuesta.setEstadoRespuesta(Constantes.RESULTADO_ERROR);
			respuesta.setMensajeRespuesta(format(Constantes.MENSAJE_ERROR_LOG, error[0]) + ".Traza inicial del error : " +exception.getMessage());
			LOGGER.error(error[1], exception);
		}
		return respuesta;
	}

}

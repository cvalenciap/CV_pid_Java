package pe.com.sedapal.pide.servicio.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.gmd.util.exception.GmdException;
import pe.com.gmd.util.exception.MensajeExceptionUtil;
import pe.com.sedapal.pide.dao.AuditoriaDao;
import pe.com.sedapal.pide.model.Auditoria;
import pe.com.sedapal.pide.servicio.ISunarpService;
import pe.com.sedapal.pide.servicio.base.BaseServiceImpl;
import pe.com.sedapal.pide.util.Constantes;
import pe.com.sedapal.pide.util.ParametrosUtil;
import pe.com.sedapal.pide.util.RespuestaBean;
import pe.com.sedapal.seguridad.core.bean.TrabajadorBean;
import pe.com.sedapal.seguridad.ws.SeguridadClienteWs;
import pe.com.sedapal.sunarp.bean.ResponseBean;
import pe.com.sedapal.sunarp.util.ConstantesCliente;
import pe.com.sedapal.sunarp.ws.SunarpClienteWs;
import static java.text.MessageFormat.format;


@Service
public class SunarpServiceImpl extends BaseServiceImpl<Auditoria, Long> implements ISunarpService{
	
	private static final Logger LOGGER = Logger.getLogger(SunarpServiceImpl.class);
		
	@Autowired
	private SunarpClienteWs sunarpWs;
	
	@Autowired
	private SeguridadClienteWs stub;
	
	@Autowired
	AuditoriaDao auditoriaDao;
		
	RespuestaBean respuesta = new RespuestaBean();
		
	@Override
	@Transactional(rollbackFor = GmdException.class)
	public RespuestaBean consultaTitularidad(Map<String, String> requestParm) throws GmdException{
		try {
			/*insert audit consulta*/
			String username = null;
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
			}
			TrabajadorBean trabajador = stub.obtenerTrabajadorWs(username);
			Auditoria auditoria = ParametrosUtil.generateAuditoria(username, Constantes.ID_SERVICIO_SUNARP, 
					Constantes.DES_SERVICIO_SUNARP, Constantes.DES_CONSULTA_TITULARIDAD, trabajador);
			auditoriaDao.insertar(auditoria);
			
			
			/**/
			String tipoParticipante = requestParm.get("tipoParticipante");
			String apellidoPaterno = requestParm.get("apellidoPaterno");
			String apellidoMaterno = requestParm.get("apellidoMaterno");
			String nombres = requestParm.get("nombres");
			String razonSocial = requestParm.get("razonSocial");
			
			ResponseBean retorno = sunarpWs.buscarTitularidadWs(tipoParticipante, apellidoPaterno, apellidoMaterno, nombres, razonSocial);
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
			respuesta.setMensajeRespuesta(format(Constantes.MENSAJE_ERROR_LOG, error[0]) + ". Traza inicial del error : " + exception.getMessage());
			LOGGER.error(error[1], exception);
		}
		return respuesta;
	}
	
	@Override
	public RespuestaBean consultaPersonaJuridica(Map<String, String> requestParm) throws GmdException{
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
			Auditoria auditoria = ParametrosUtil.generateAuditoria(username, Constantes.ID_SERVICIO_SUNARP, 
					Constantes.DES_SERVICIO_SUNARP, Constantes.DES_CONSULTA_PERSONA_JURIDICA, trabajador);
			auditoriaDao.insertar(auditoria);
			/**/
			
			String razonSocial = requestParm.get("razonSocial");
			
			ResponseBean retorno = sunarpWs.buscarPJRazonSocialWs(razonSocial);
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

	@Override
	public RespuestaBean consultaAeronave(Map<String, String> requestParm) throws GmdException{
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
			Auditoria auditoria = ParametrosUtil.generateAuditoria(username, Constantes.ID_SERVICIO_SUNARP,
					Constantes.DES_SERVICIO_SUNARP, Constantes.DES_CONSULTA_AERONAVE, trabajador);
			auditoriaDao.insertar(auditoria);
			/**/

			String nroMatricula = requestParm.get("nroMatricula");
						
			ResponseBean retorno = sunarpWs.buscarAeronaveWs(nroMatricula);
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
	
	@Override
	public RespuestaBean consultaOficinas(Map<String, String> requestParm) throws GmdException{
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
			Auditoria auditoria = ParametrosUtil.generateAuditoria(username, Constantes.ID_SERVICIO_SUNARP, 
					Constantes.DES_SERVICIO_SUNARP, Constantes.DES_CONSULTA_OFICINAS, trabajador);
			auditoriaDao.insertar(auditoria);
			/**/
						
			ResponseBean retorno = sunarpWs.buscarOficinasWs();
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
	
	@Override
	public RespuestaBean consultaAsientos(Map<String, String> requestParm) throws GmdException{
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
			Auditoria auditoria = ParametrosUtil.generateAuditoria(username, Constantes.ID_SERVICIO_SUNARP,
					Constantes.DES_SERVICIO_SUNARP, Constantes.DES_CONSULTA_ASIENTOS, trabajador);
			auditoriaDao.insertar(auditoria);
			/**/
			
			String zona = requestParm.get("zona");
			String oficina = requestParm.get("oficina");
			String partida = requestParm.get("partida");
			String registro = requestParm.get("registro");
			
			ResponseBean retorno = sunarpWs.buscarAsientosWs(zona, oficina, partida, registro);
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
	@Override
	public RespuestaBean consultaDetalleRPV(Map<String, String> requestParm) throws GmdException{
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
			Auditoria auditoria = ParametrosUtil.generateAuditoria(username, Constantes.ID_SERVICIO_SUNARP,
					Constantes.DES_SERVICIO_SUNARP, Constantes.DES_CONSULTA_DETALLE_RPV, trabajador);
			auditoriaDao.insertar(auditoria);
			/**/
			
			String zona = requestParm.get("zona");
			String oficina = requestParm.get("oficina");
			String placa = requestParm.get("placa");
			
			ResponseBean retorno = sunarpWs.buscarDetalleRPVWs(zona, oficina, placa);
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
	
	@Override
	public RespuestaBean consultaImgAsiento(Map<String, String> requestParm) throws GmdException{
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
			Auditoria auditoria = ParametrosUtil.generateAuditoria(username, Constantes.ID_SERVICIO_SUNARP,
					Constantes.DES_SERVICIO_SUNARP, Constantes.DES_CONSULTA_IMG_ASIENTO, trabajador);
			auditoriaDao.insertar(auditoria);
			/**/

			String transaccion = requestParm.get("transaccion");
			String idImg = requestParm.get("idImg");
			String tipo = requestParm.get("tipo");
			String nroTotalPag = requestParm.get("nroTotalPag");
			String nroPagRef = requestParm.get("nroPagRef");
			String pagina = requestParm.get("pagina");
			
			ResponseBean retorno = sunarpWs.buscarImgAsientoWs(transaccion, idImg, tipo, nroTotalPag, nroPagRef, pagina);
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

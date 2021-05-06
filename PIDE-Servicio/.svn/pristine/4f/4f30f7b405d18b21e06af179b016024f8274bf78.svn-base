package pe.com.sedapal.pide.servicio.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.dao.AuditoriaDao;
import pe.com.sedapal.pide.model.Auditoria;
import pe.com.sedapal.pide.servicio.IAuditoriaService;
import pe.com.sedapal.pide.servicio.base.BaseServiceImpl;

@Repository
public class AuditoriaServiceImpl extends BaseServiceImpl<Auditoria, Long> implements IAuditoriaService{
		
	private static final Logger LOGGER = Logger.getLogger(AuditoriaServiceImpl.class);
	
	@Autowired
	AuditoriaDao auditoriaDao;
	
	@Override
	@Transactional(rollbackFor=GmdException.class)
	public void insertar(Auditoria auditoria) throws GmdException {
		try {
			auditoriaDao.insertar(auditoria);
        } catch (Exception excepcion) {
            throw new GmdException(excepcion);
        }
	}

	@Override
	@Transactional(rollbackFor=GmdException.class)
	public void actualizar(Auditoria auditoria) throws GmdException {
		try {
			auditoriaDao.actualizar(auditoria);
        } catch (Exception excepcion) {
            throw new GmdException(excepcion);
        }
	}
	
	@Override
	@Transactional(rollbackFor=GmdException.class)
	public void eliminar(Auditoria auditoria) throws GmdException {
		try {
			auditoriaDao.eliminar(auditoria);
        } catch (Exception excepcion) {
            throw new GmdException(excepcion);
        }		
	}
	
	@Override
	public List<Auditoria> buscarAuditoria(Integer idConsulta, Integer idServicio) throws GmdException {
		List<Auditoria> listaAuditoria = new ArrayList<Auditoria>();
		try{			
			Map<String, Object> mapBusqueda = new HashMap<String, Object>();
			mapBusqueda.put("PAR_N_ID_CAB_CONSULTA", idConsulta);
			mapBusqueda.put("PAR_N_ID_SERVICIO", idServicio);
			auditoriaDao.buscarAuditoria(mapBusqueda);
			listaAuditoria = (List<Auditoria>) mapBusqueda.get("PAR_OUT_CURSOR");
		}catch(Exception excepcion){
			throw new GmdException(excepcion);
		}
		return listaAuditoria;
	}
}

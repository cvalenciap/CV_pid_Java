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
import pe.com.sedapal.pide.dao.MantenimientoDao;
import pe.com.sedapal.pide.model.Mantenimiento;
import pe.com.sedapal.pide.servicio.IMantenimientoService;
import pe.com.sedapal.pide.servicio.base.BaseServiceImpl;

@Repository
public class MantenimientoServiceImpl extends BaseServiceImpl<Mantenimiento, Long> implements IMantenimientoService{
	
	private static final Logger LOGGER = Logger.getLogger(AuditoriaServiceImpl.class);
	
	@Autowired
	MantenimientoDao mantenimientoDao;
	
	@Override
	@Transactional(rollbackFor=GmdException.class)
	public void insertar(Mantenimiento mantenimiento) throws GmdException {
		try {
			mantenimientoDao.insertar(mantenimiento);
        } catch (Exception excepcion) {
            throw new GmdException(excepcion);
        }
	}

	@Override
	@Transactional(rollbackFor=GmdException.class)
	public void actualizar(Mantenimiento mantenimiento) throws GmdException {
		try {
			mantenimientoDao.actualizar(mantenimiento);
        } catch (Exception excepcion) {
            throw new GmdException(excepcion);
        }
	}
	
	@Override
	@Transactional(rollbackFor=GmdException.class)
	public void eliminar(Mantenimiento mantenimiento) throws GmdException {
		try {
			mantenimientoDao.eliminar(mantenimiento);
        } catch (Exception excepcion) {
            throw new GmdException(excepcion);
        }		
	}

	@Override
	public List<Mantenimiento> buscarMantenimiento(Integer idServicio) throws GmdException {
		List<Mantenimiento> listaMantenimiento = new ArrayList<Mantenimiento>();
		try{			
			Map<String, Object> mapBusqueda = new HashMap<String, Object>();
			mapBusqueda.put("PAR_N_ID_SERVICIO", idServicio);
			mantenimientoDao.buscarMantenimiento(mapBusqueda);
			listaMantenimiento = (List<Mantenimiento>) mapBusqueda.get("PAR_OUT_CURSOR");
		}catch(Exception excepcion){
			throw new GmdException(excepcion);
		}
		return listaMantenimiento;
	}

}

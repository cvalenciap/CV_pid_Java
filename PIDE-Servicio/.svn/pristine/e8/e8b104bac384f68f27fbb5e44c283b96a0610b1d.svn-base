package pe.com.sedapal.pide.servicio.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.dao.PideGeneralDao;
import pe.com.sedapal.pide.model.PideGeneral;
import pe.com.sedapal.pide.servicio.IPideGeneralService;
import pe.com.sedapal.pide.servicio.base.BaseServiceImpl;

@Repository
public class PideGeneralServiceImpl extends BaseServiceImpl<PideGeneral, Long> implements IPideGeneralService {
	
	@Autowired
	PideGeneralDao pideGeneralDao;
	
	@Override
	@Transactional(rollbackFor=GmdException.class)
	public void insertar(PideGeneral pideGeneral) throws GmdException {
		try {
			pideGeneralDao.insertar(pideGeneral);
        } catch (Exception excepcion) {
            throw new GmdException(excepcion);
        }
	}

	@Override
	@Transactional(rollbackFor=GmdException.class)
	public void actualizar(PideGeneral pideGeneral) throws GmdException {
		try {
			pideGeneralDao.actualizar(pideGeneral);
        } catch (Exception excepcion) {
            throw new GmdException(excepcion);
        }
	}
	
	@Override
	@Transactional(rollbackFor=GmdException.class)
	public void eliminar(PideGeneral pideGeneral) throws GmdException {
		try {
			pideGeneralDao.eliminar(pideGeneral);
        } catch (Exception excepcion) {
            throw new GmdException(excepcion);
        }		
	}

	@Override
	public List<PideGeneral> buscarPideGeneral(Integer idGeneral, Integer idTipoParametro) throws GmdException {
		List<PideGeneral> listaPideGeneral = new ArrayList<PideGeneral>();
		try{			
			Map<String, Object> mapBusqueda = new HashMap<String, Object>();
			mapBusqueda.put("PAR_N_ID_CAB_CONSULTA", idGeneral);
			mapBusqueda.put("PAR_N_ID_SERVICIO", idTipoParametro);
			pideGeneralDao.buscarPideGeneral(mapBusqueda);
			listaPideGeneral = (List<PideGeneral>) mapBusqueda.get("PAR_OUT_CURSOR");
		}catch(Exception excepcion){
			throw new GmdException(excepcion);
		}
		return listaPideGeneral;
	}

	@Override
	public List<PideGeneral> listarPideGeneral() throws GmdException {
		List<PideGeneral> listaPideGeneral = new ArrayList<PideGeneral>();
		try{			
			Map<String, Object> mapBusqueda = new HashMap<String, Object>();
			pideGeneralDao.listarPideGeneral(mapBusqueda);
			listaPideGeneral = (List<PideGeneral>) mapBusqueda.get("PAR_OUT_CURSOR");
		}catch(Exception excepcion){
			throw new GmdException(excepcion);
		}
		return listaPideGeneral;
	}

}

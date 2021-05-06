package pe.com.sedapal.pide.dao;

import java.util.List;
import java.util.Map;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.dao.base.BaseDao;
import pe.com.sedapal.pide.model.PideGeneral;

public interface PideGeneralDao extends BaseDao<PideGeneral, Long>{
	
	void eliminar(PideGeneral pideGeneral)throws GmdException;

	List<PideGeneral> buscarPideGeneral(Map<String, Object> mapBusqueda) throws GmdException;
	List<PideGeneral> listarPideGeneral(Map<String, Object> mapBusqueda) throws GmdException;
}

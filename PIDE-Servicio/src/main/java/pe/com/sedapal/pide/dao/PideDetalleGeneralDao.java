package pe.com.sedapal.pide.dao;

import java.util.List;
import java.util.Map;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.dao.base.BaseDao;
import pe.com.sedapal.pide.model.PideDetalleGeneral;

public interface PideDetalleGeneralDao extends BaseDao<PideDetalleGeneral, Long> {
	
	void eliminar(PideDetalleGeneral pideDetalleGeneral)throws GmdException;

	List<PideDetalleGeneral> buscarPideDetalleGeneral1(Map<String, Object> mapBusqueda) throws GmdException;
	List<PideDetalleGeneral> buscarPideDetalleGeneral2(Map<String, Object> mapBusqueda) throws GmdException;
	List<PideDetalleGeneral> listDetallesGenerales(Map<String, Object> mapBusqueda) throws GmdException;
	List<PideDetalleGeneral> listDetallesGenerales_i(Map<String, Object> mapBusqueda) throws GmdException;
	List<PideDetalleGeneral> listDetallesGenerales_m(Map<String, Object> mapBusqueda) throws GmdException;
	List<PideDetalleGeneral> listDetallesGeneralesPara(Map<String, Object> mapBusqueda) throws GmdException;
}

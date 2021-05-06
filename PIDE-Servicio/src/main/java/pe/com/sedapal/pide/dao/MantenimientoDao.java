package pe.com.sedapal.pide.dao;

import java.util.List;
import java.util.Map;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.dao.base.BaseDao;
import pe.com.sedapal.pide.model.Mantenimiento;

public interface MantenimientoDao extends BaseDao<Mantenimiento, Long>{

	void eliminar(Mantenimiento mantenimiento)throws GmdException;
	
	List<Mantenimiento> buscarMantenimiento(Map<String, Object> mapBusqueda) throws GmdException;
}

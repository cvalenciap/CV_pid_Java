package pe.com.sedapal.pide.dao;

import java.util.List;
import java.util.Map;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.dao.base.BaseDao;
import pe.com.sedapal.pide.model.Auditoria;

public interface AuditoriaDao extends BaseDao<Auditoria, Long>{
	
	void eliminar(Auditoria auditoria)throws GmdException;
	
	List<Auditoria> buscarAuditoria(Map<String, Object> mapBusqueda) throws GmdException;
	
}
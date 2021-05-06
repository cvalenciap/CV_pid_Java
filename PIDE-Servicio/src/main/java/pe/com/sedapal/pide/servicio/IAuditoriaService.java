package pe.com.sedapal.pide.servicio;

import java.util.List;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.model.Auditoria;
import pe.com.sedapal.pide.servicio.base.BaseService;

public interface IAuditoriaService extends BaseService <Auditoria, Long>{
	
//	void insertar(Auditoria auditoria) throws GmdException;
//	
//	void actualizar(Auditoria auditoria)throws GmdException;
//	
	void eliminar(Auditoria auditoria)throws GmdException;
	
	List<Auditoria> buscarAuditoria(Integer idConsulta, Integer idServicio) throws GmdException;
}

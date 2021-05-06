package pe.com.sedapal.pide.servicio;

import java.util.List;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.model.Mantenimiento;
import pe.com.sedapal.pide.servicio.base.BaseService;

public interface IMantenimientoService  extends BaseService <Mantenimiento, Long>{
	
	void eliminar(Mantenimiento mantenimiento)throws GmdException;
	
	List<Mantenimiento> buscarMantenimiento(Integer idServicio) throws GmdException;
}

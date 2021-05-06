package pe.com.sedapal.pide.servicio;

import java.util.Map;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.util.RespuestaBean;

public interface IReniecService {

	public RespuestaBean actualizarCredencial(Map<String, String> requestParm) throws GmdException;
	public RespuestaBean consultarDni(Map<String, String> requestParm) throws GmdException;
}

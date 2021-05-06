package pe.com.sedapal.pide.servicio;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.model.Trabajador;
import pe.com.sedapal.pide.model.Usuario;
import pe.com.sedapal.pide.model.response.Error;
import pe.com.sedapal.pide.servicio.base.BaseService;
import pe.com.sedapal.pide.util.RespuestaBean;
import pe.com.sedapal.pide.model.request.UsuarioRequest;
import pe.com.sedapal.pide.model.request.ActualizarClaveRequest;

public interface IUsuarioServicio {
	
	RespuestaBean autentificarCredenciales(Map<String, String> requestParm, HttpServletRequest req) throws GmdException;
	
	RespuestaBean logoutToken(Map<String, String> requestParm, HttpServletRequest req) throws GmdException;
	
	Usuario obtenerPerfilesModulos(UsuarioRequest usuarioRequest);
	
	Trabajador obtenerTrabajador(String usuario) throws GmdException;

	String recuperarCredenciales(String usuario);
	
	String logoutToken(String token);
	
	Error getError();
	
	Trabajador obtenerPersonal(String usuario);
	
	Error getErrorUsuario();
	
	String actualizarCredenciales(ActualizarClaveRequest actualizarClaveRequest);

}

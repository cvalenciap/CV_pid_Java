package pe.com.sedapal.pide.security.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.com.sedapal.pide.security.config.UserAuth;
import pe.com.sedapal.pide.util.Constantes;
import pe.com.sedapal.seguridad.core.bean.PerfilSistemaBean;
import pe.com.sedapal.seguridad.core.bean.Retorno;
import pe.com.sedapal.seguridad.ws.SeguridadClienteWs;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private SeguridadClienteWs stub;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private Environment env;
	
	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private static final Logger LOGGER = Logger.getLogger(CustomUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username){
		// TODO Auto-generated method stub 
		Integer codigo_sistema = Integer.parseInt(env.getProperty("soap.code.system"));
		Retorno retorno = null;
		List<String> permisos = null;
		List<GrantedAuthority> authorities = null;
//		List<String> perfiles = new ArrayList<String>();
		List<Integer> perfiles = new ArrayList<Integer>();
		try {
			String password = (String) request.getAttribute("password");
			retorno = stub.autenticacionUsuarioActWs(username.toUpperCase(), codigo_sistema, password);
			if (Constantes.FAILURE.equals(retorno.getCodigo())) {
				throw new BadCredentialsException(retorno.getMensaje());
			}
			
			//permisos orientado a rutas de menu
			if(Integer.parseInt(retorno.getFlagCambiarClave()) != Constantes.ESTADO_INACTIVO){
				permisos = new ArrayList<>();
				permisos.add("restablecerClave");
			}else{
				permisos = stub.obtenerPermisosWs(username);
				permisos.add("cambioClave");
			}
			authorities = buildUserAuthority(permisos);
			///encode y delete pass
			retorno.setClave(passwordEncoder.encode(password));
			request.removeAttribute("password");
			//adecuacion de obtencion de perfiles
			for(PerfilSistemaBean perfil : retorno.getPerfilesAct()) {
				perfiles.add(perfil.getCodPerfil());
//				perfiles.add(perfil.getDescripcion());
			}
		} catch (UsernameNotFoundException e) {
			LOGGER.error("Usuario no encontrado: " + username);
			throw new UsernameNotFoundException(e.getMessage());
		} catch (Exception e) {
			LOGGER.error("No se pudo acceder al webservice de seguridad", e);
			if(e.getMessage()!=null && (e.getMessage().contains("error al realizar la operacion = I/O error")||e.getMessage().contains("error al realizar la operacion = No Encontrado"))){
				throw new AccessDeniedException("Error: No se puede acceder al webservice de seguridad");
			}
			throw new AccessDeniedException(e.getMessage());
		}
		// TODO Auto-generated method stub
		return buildUserForAuthentication(retorno.getUsuario(), retorno.getClave(), retorno.getToken(), perfiles, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(List<String> permisos) {
		Set<GrantedAuthority> setAuths = new HashSet<>();
		for (String permiso : permisos) {
			setAuths.add(new SimpleGrantedAuthority(permiso));
		}
		return new ArrayList<>(setAuths);
	}
	
	private UserAuth buildUserForAuthentication(String usuario, String password, String token, List<Integer> perfiles, List<GrantedAuthority> authorities) {
		return new UserAuth(usuario, password, true, true, true, true, authorities, token, perfiles);
	}

}
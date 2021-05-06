package pe.com.sedapal.pide.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import pe.com.sedapal.pide.util.JwtUtil;
import pe.com.sedapal.seguridad.ws.SeguridadClienteWs;

@Component
public class UserAjaxLogoutSuccessHandler  extends
AbstractAuthenticationTargetUrlRequestHandler
implements
LogoutSuccessHandler {
	
	@Autowired
	private SeguridadClienteWs stub;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String token = JwtUtil.getRedisKey(JwtUtil.getToken(request));
		stub.logoutWs(token);
		SecurityContextHolder.getContext().setAuthentication(null);
		//servicio logout
		
		response.setStatus(HttpServletResponse.SC_OK);
		
	}
}

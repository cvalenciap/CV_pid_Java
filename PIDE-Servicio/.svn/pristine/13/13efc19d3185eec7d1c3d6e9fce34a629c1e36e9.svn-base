package pe.com.sedapal.pide.security.filter;

import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import pe.com.sedapal.pide.servicio.impl.SunarpServiceImpl;
import pe.com.sedapal.pide.util.Constantes;
import pe.com.sedapal.pide.util.JwtUtil;
import pe.com.sedapal.seguridad.core.bean.Retorno;
import pe.com.sedapal.seguridad.ws.SeguridadClienteWs;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;

@Order(Ordered.LOWEST_PRECEDENCE)
public class FilterToken extends GenericFilterBean {
	
	private static final Logger LOGGER = Logger.getLogger(FilterToken.class);
	
	private SeguridadClienteWs seguridadClienteWs;
	
	public FilterToken(SeguridadClienteWs stub) {
		this.seguridadClienteWs = stub;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			if (!req.getRequestURI().equals(Constantes.URL_LOGIN) && !req.getRequestURI().equals(Constantes.URL_LOGOUT)
					&& !req.getRequestURI().equals(Constantes.URL_APP_INFO)) {
				Authentication authentication = JwtUtil.getAuthentication(req, seguridadClienteWs);
				if (authentication != null) {
					SecurityContextHolder.getContext().setAuthentication(authentication);
				} else {
					SecurityContextHolder.getContext().setAuthentication(null);
				}
			}
		} catch (Exception e) {
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			e.printStackTrace();
			LOGGER.error("FilterJWT Exception: " + e.getMessage(), e);
		}
		filterchain.doFilter(request, response);
	}
}

package pe.com.sedapal.pide.util;

import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.reflect.TypeToken;


public class WebUtil {

	public static void setSessionAttribute(HttpServletRequest request, String nombreAtributo, Object objeto) {
		request.getSession().setAttribute(nombreAtributo, objeto);
	}

	public static Object getSessionAttribute(HttpServletRequest request, String nombreAtributo) {
		return request.getSession().getAttribute(nombreAtributo);
	}

	public static String obtenerTerminal(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

//	public static String obtenerLoginUsuario() {
//		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
//				.currentRequestAttributes();
//		Usuario usuarioEntidad = (Usuario) getSessionAttribute(servletRequestAttributes.getRequest(), "usuarioBean");
//		return usuarioEntidad.getLogin();
//	}
//
//	public static Long obtenerIdUsuario() {
//		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
//				.currentRequestAttributes();
//		Usuario usuarioEntidad = (Usuario) getSessionAttribute(servletRequestAttributes.getRequest(), "usuarioBean");
//		return usuarioEntidad.getIdUsuario();
//	}
//
//	public static Integer obtenerIdLogAcceso() {
//		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
//				.currentRequestAttributes();
//		Usuario usuarioEntidad = null;
//		Integer idSesion = null;
//		if (getSessionAttribute(servletRequestAttributes.getRequest(), "usuarioBean") != null) {
//			usuarioEntidad = (Usuario) getSessionAttribute(servletRequestAttributes.getRequest(), "usuarioBean");
//			idSesion = usuarioEntidad.getIdSesionActual();
//		}
//		return idSesion;
//	}
	
	public static Object obtenerObjetoServletContext(HttpServletRequest request, String nombreObjeto){
        ServletContext servletContext = request.getSession().getServletContext();
        return servletContext.getAttribute(nombreObjeto);
    }
	
//	public static Usuario obtenerUsuarioLogin(){
//		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//		Usuario usuarioEntidad = (Usuario) getSessionAttribute(servletRequestAttributes.getRequest(), "usuarioBean");
//		return usuarioEntidad;
//	}
//	
//	public static Perfil obtenerPerfilUsuario(){
//		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//		Perfil perfilEntidad = (Perfil) getSessionAttribute(servletRequestAttributes.getRequest(), "perfilBean");
//		return perfilEntidad;
//	}
	
	public static boolean existePermisoParaOpcion(HttpServletRequest request,String opcion ){
		String cadenaJSON = (String)getSessionAttribute(request, "listaOpciones");
		Type listType = new TypeToken<ArrayList<Map<String,Object>>>(){}.getType();			
		List<Map<String,Object>> listaOpciones = JsonUtil.convertirCadenaJsonALista(cadenaJSON,listType);
		for(Map<String,Object> opcionMap : listaOpciones){
			String op= opcionMap.get("nombre").toString();
			if(op.equals(opcion)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static void setFiltroContext(HttpServletRequest request){
		
		Map<String,Object> mapFiltro =request.getParameter("filtro")!=null
				                      ? JsonUtil.convertirCadenaJsonAObjeto(request.getParameter("filtro"), Map.class)
				                      : null;
		request.getSession().setAttribute("filtro", mapFiltro);
	}
	
	@SuppressWarnings("unchecked")
	public static String obtenerFiltroContext(HttpServletRequest request){
		
		
		String regresar=  request.getParameter("regresar");
		if(regresar!=null && regresar.equals(Constantes.REGRESAR)){
			Map<String,Object> mapFiltro =request.getSession().getAttribute("filtro")!=null 
					                      ? (Map<String,Object>)request.getSession().getAttribute("filtro")
					                      : null;
		 
			if(mapFiltro!=null){
			    mapFiltro.put("mensaje", request.getParameter("mensaje"));
				return JsonUtil.convertirObjetoACadenaJson(mapFiltro);
			}				
			else{
				if(request.getParameter("mensaje")!=null && !request.getParameter("mensaje").toString().isEmpty()){	
					mapFiltro =  new HashMap<String,Object>();
					mapFiltro.put("mensaje", request.getParameter("mensaje"));
					return JsonUtil.convertirObjetoACadenaJson(mapFiltro);
				}
			} 
				
		}
		
		request.getSession().setAttribute("filtro", null);	
		return JsonUtil.convertirObjetoACadenaJson(new HashMap<String,Object>());		
    }
	
	@SuppressWarnings("deprecation")
	public static Date aumentarNDias (Date fecha, int nDias){        
        int anio = fecha.getYear() + 1900 ;
        int mes = fecha.getMonth() + 1;
        int dia = fecha.getDate();
        
        Calendar fechaActual = Calendar.getInstance();
        fechaActual.set(anio, (mes-1), dia);
        fechaActual.add(Calendar.DATE, nDias);
        
        int anioM = fechaActual.get(Calendar.YEAR) - 1900;
        int mesM =  ( fechaActual.get(Calendar.MONTH) + 1 ) -1;
        int diaM = fechaActual.get(Calendar.DAY_OF_MONTH);
               
        Date fechaModificada = new Date(anioM, mesM, diaM);
        return fechaModificada;        
    }	
	
    /**
    * Método para transformar campo clob de BD a un String java
    */
   public static String convertirClobAString(Object obj){
   	String clobAsString = null;
       try {
       	if(obj != null){
       		InputStream in = ((Clob) obj).getAsciiStream();
               StringWriter w = new StringWriter();
               IOUtils.copy(in, w);
               clobAsString = w.toString();
       	}
           
       } catch (Exception exception) {
       	exception.printStackTrace();
		}
   	return clobAsString;
   }
   
   
   
   
}

package pe.com.sedapal.sunarp.ws;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pe.com.gmd.util.exception.GmdException;
import pe.com.gmd.util.exception.MensajeExceptionUtil;
import pe.com.sedapal.sunarp.bean.ResponseBean;
import pe.com.sedapal.sunarp.util.ConstantesCliente;



@PropertySource("classpath:pe/com/sedapal/sunarp/ws/config/configSunarp.properties")
public class SunarpClienteWs {
	
	private static final Logger LOGGER = Logger.getLogger(SunarpClienteWs.class);
	
	@Value("#{config['urlSunarpWs']}")
	private String urlWs = "http://localhost:8099/sunarpWS/services/PIDEWSServicePortS?wsdl";
	
	private WebServiceTemplate webServiceSunarpTemplate;
	
	private ResponseBean respuestaBean = new ResponseBean();
	
	public WebServiceTemplate getWebServiceSunarpTemplate() {
		return webServiceSunarpTemplate;
	}
	
	public void setWebServiceSunarpTemplate(WebServiceTemplate webServiceSunarpTemplate) {
		this.webServiceSunarpTemplate = webServiceSunarpTemplate;
	}
	
//	definition methods request
	public ResponseBean buscarPJRazonSocialWs(String razonSocial) throws GmdException{
		String xmlRequest = this.getPeticionBuscarPJRazonSocialWs(razonSocial);
		StreamSource peticion = new StreamSource(new StringReader(xmlRequest));
		DOMResult respuesta = new DOMResult();
		try {
			boolean hayRespuesta = webServiceSunarpTemplate.sendSourceAndReceiveToResult(urlWs, peticion, respuesta);
			if (hayRespuesta) {
				respuestaBean = resultToRetornoPJRazonSocial((Document) respuesta.getNode());
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_OK);
				System.out.println("************ENCUENTRA RESPUESTA PJRAZONSOCIAL");
			}else {
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_ERROR);
				respuestaBean.setMensajeRespuesta(ConstantesCliente.MENSAJE_NO_DATA);
			}
		} catch (Exception exception) {
			String[] error = MensajeExceptionUtil.obtenerMensajeError(exception);
			LOGGER.error(error[1], exception);
			throw new GmdException(exception);
		}
		return respuestaBean;
	}
	
	public ResponseBean buscarTitularidadWs(String tipoParticipante, String apellidoPaterno, String apellidoMaterno, String nombres, String razonSocial) throws GmdException{
		String xmlRequest = this.getPeticionBuscarTitularidadWs(tipoParticipante, apellidoPaterno, apellidoMaterno, nombres, razonSocial);
		StreamSource peticion = new StreamSource(new StringReader(xmlRequest));
		DOMResult respuesta = new DOMResult();
		try {
			boolean hayRespuesta = webServiceSunarpTemplate.sendSourceAndReceiveToResult(urlWs, peticion, respuesta);
			if (hayRespuesta) {
				respuestaBean = resultToRetornoTitularidad((Document) respuesta.getNode());
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_OK);
				System.out.println("************ENCUENTRA RESPUESTA TITULARIDAD");
			}else {
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_ERROR);
				respuestaBean.setMensajeRespuesta(ConstantesCliente.MENSAJE_NO_DATA);
			}
		} catch (Exception exception) {
			String[] error = MensajeExceptionUtil.obtenerMensajeError(exception);
			LOGGER.error(error[1], exception);
			throw new GmdException(exception);
		}
		return respuestaBean;
	}
	
	public ResponseBean buscarAeronaveWs(String nroMatricula) throws GmdException{
		String xmlRequest = this.getPeticionBuscarAeronaveWs(nroMatricula);
		StreamSource peticion = new StreamSource(new StringReader(xmlRequest));
		DOMResult respuesta = new DOMResult();
		try {
			boolean hayRespuesta = webServiceSunarpTemplate.sendSourceAndReceiveToResult(urlWs, peticion, respuesta);
			if (hayRespuesta) {
				respuestaBean = resultToRetornoAeronave((Document) respuesta.getNode());
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_OK);
				System.out.println("************ENCUENTRA RESPUESTA TITULARIDAD");
			}else {
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_ERROR);
				respuestaBean.setMensajeRespuesta(ConstantesCliente.MENSAJE_NO_DATA);
			}
		} catch (Exception exception) {
			String[] error = MensajeExceptionUtil.obtenerMensajeError(exception);
			LOGGER.error(error[1], exception);
			throw new GmdException(exception);
		}
		return respuestaBean;
	}
	
	public ResponseBean buscarOficinasWs() throws GmdException{
		String xmlRequest = this.getPeticionBuscarOficinasWs();
		StreamSource peticion = new StreamSource(new StringReader(xmlRequest));
		DOMResult respuesta = new DOMResult();
		try {
			boolean hayRespuesta = webServiceSunarpTemplate.sendSourceAndReceiveToResult(urlWs, peticion, respuesta);
			if (hayRespuesta) {
				respuestaBean = resultToRetornoOficinas((Document) respuesta.getNode());
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_OK);
				System.out.println("************ENCUENTRA RESPUESTA TITULARIDAD");
			}else {
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_ERROR);
				respuestaBean.setMensajeRespuesta(ConstantesCliente.MENSAJE_NO_DATA);
			}
		} catch (Exception exception) {
			String[] error = MensajeExceptionUtil.obtenerMensajeError(exception);
			LOGGER.error(error[1], exception);
			throw new GmdException(exception);
		}
		return respuestaBean;
	}
	
	public ResponseBean buscarAsientosWs(String zona, String oficna, String partida, String registro) throws GmdException{
		String xmlRequest = this.getPeticionBuscarAsientosWs(zona, oficna, partida, registro);
		StreamSource peticion = new StreamSource(new StringReader(xmlRequest));
		DOMResult respuesta = new DOMResult();
		try {
			boolean hayRespuesta = webServiceSunarpTemplate.sendSourceAndReceiveToResult(urlWs, peticion, respuesta);
			if (hayRespuesta) {
				respuestaBean = resultToRetornoAsientos((Document) respuesta.getNode());
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_OK);
				System.out.println("************ENCUENTRA RESPUESTA TITULARIDAD");
			}else {
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_ERROR);
				respuestaBean.setMensajeRespuesta(ConstantesCliente.MENSAJE_NO_DATA);
			}
		} catch (Exception exception) {
			String[] error = MensajeExceptionUtil.obtenerMensajeError(exception);
			LOGGER.error(error[1], exception);
			throw new GmdException(exception);
		}
		return respuestaBean;
	}
	
	public ResponseBean buscarDetalleRPVWs(String zona, String oficna, String placa) throws GmdException{
		String xmlRequest = this.getPeticionBuscarDetalleRPVWs(zona, oficna, placa);
		StreamSource peticion = new StreamSource(new StringReader(xmlRequest));
		DOMResult respuesta = new DOMResult();
		try {
			boolean hayRespuesta = webServiceSunarpTemplate.sendSourceAndReceiveToResult(urlWs, peticion, respuesta);
			if (hayRespuesta) {
				respuestaBean = resultToRetornoDetalleRPV((Document) respuesta.getNode());
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_OK);
				System.out.println("************ENCUENTRA RESPUESTA TITULARIDAD");
			}else {
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_ERROR);
				respuestaBean.setMensajeRespuesta(ConstantesCliente.MENSAJE_NO_DATA);
			}
		} catch (Exception exception) {
			String[] error = MensajeExceptionUtil.obtenerMensajeError(exception);
			LOGGER.error(error[1], exception);
			throw new GmdException(exception);
		}
		return respuestaBean;
	}
	
	public ResponseBean buscarImgAsientoWs(String transaccion, String idImg, String tipo, String nroTotalPag, String nroPagRef, String pagina) throws GmdException{
		String xmlRequest = this.getPeticionBuscarImgAsientoWs(transaccion, idImg, tipo, nroTotalPag, nroPagRef, pagina);
		StreamSource peticion = new StreamSource(new StringReader(xmlRequest));
		DOMResult respuesta = new DOMResult();
		try {
			boolean hayRespuesta = webServiceSunarpTemplate.sendSourceAndReceiveToResult(urlWs, peticion, respuesta);
			if (hayRespuesta) {
				respuestaBean = resultToRetornoImgAsiento((Document) respuesta.getNode());
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_OK);
				System.out.println("************ENCUENTRA RESPUESTA TITULARIDAD");
			}else {
				respuestaBean.setEstadoRespuesta(ConstantesCliente.RESULTADO_ERROR);
				respuestaBean.setMensajeRespuesta(ConstantesCliente.MENSAJE_NO_DATA);
			}
		} catch (Exception exception) {
			String[] error = MensajeExceptionUtil.obtenerMensajeError(exception);
			LOGGER.error(error[1], exception);
			throw new GmdException(exception);
		}
		return respuestaBean;
	}
	
	//	definition xml request
	private String getPeticionBuscarPJRazonSocialWs(String razonSocial) throws GmdException{
		StringBuffer buffer = new StringBuffer(2048);
		try {
			buffer.append("<con:buscarPJRazonSocial xmlns:con=\"http://controller.pide.sunarp.gob.pe/\">");
			buffer.append("<razonSocial>" + razonSocial + "</razonSocial>");
			buffer.append("</con:buscarPJRazonSocial>");
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return buffer.toString();
	}
	
	private ResponseBean resultToRetornoPJRazonSocial(Document doc) throws GmdException{
		NodeList nodos = doc.getFirstChild().getChildNodes();
		Node current = null;
		ResponseBean retorno = null;
		retorno = new ResponseBean();
		try {
			Map<String, Object> listaResultado = new HashMap<String, Object>();
			for(int i = 0; i < nodos.getLength(); i++) {
				Map<String, String> valor = new HashMap<String, String>();
				current = nodos.item(i);
				if(this.getProperty(current, "zona") != null) {
					valor.put("zona", this.getProperty(current, "zona"));
				}
				if(this.getProperty(current, "oficina") != null) {
					valor.put("oficina", this.getProperty(current, "oficina"));
				}
				if(this.getProperty(current, "partida") != null) {
					valor.put("partida", this.getProperty(current, "partida"));
				}
				if(this.getProperty(current, "ficha") != null) {
					valor.put("ficha", this.getProperty(current, "ficha"));
				}
				if(this.getProperty(current, "tomo") != null) {
					valor.put("tomo", this.getProperty(current, "tomo"));
				}
				if(this.getProperty(current, "folio") != null) {
					valor.put("folio", this.getProperty(current, "folio"));
				}
				if(this.getProperty(current, "tipo") != null) {
					valor.put("tipo", this.getProperty(current, "tipo"));
				}
				if(this.getProperty(current, "denominacion") != null) {
					valor.put("denominacion", this.getProperty(current, "denominacion"));
				}
				listaResultado.put("resultado", valor);
			}
			retorno.setParametros(listaResultado);
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return retorno;
	}
	
	private String getPeticionBuscarTitularidadWs(String tipoParticipante, String apellidoPaterno, String apellidoMaterno, String nombres, String razonSocial) throws GmdException{
		StringBuffer buffer = new StringBuffer(2048);
		try {
			buffer.append("<con:buscarTitularidad xmlns:con=\"http://controller.pide.sunarp.gob.pe/\">");
			buffer.append("<tipoParticipante>" + tipoParticipante + "</tipoParticipante>");
			buffer.append("<apellidoPaterno>" + apellidoPaterno + "</apellidoPaterno>");
			buffer.append("<apellidoMaterno>" + apellidoMaterno + "</apellidoMaterno>");
			buffer.append("<nombres>" + nombres + "</nombres>");
			buffer.append("<razonSocial>" + tipoParticipante + "</razonSocial>");
			buffer.append("</con:buscarTitularidad>");
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return buffer.toString();
	}
	
	private ResponseBean resultToRetornoTitularidad(Document doc) throws GmdException{
		NodeList nodos = doc.getFirstChild().getChildNodes();
		Node current = null;
		ResponseBean retorno = null;
		retorno = new ResponseBean();
		try {
			Map<String, Object> listaResultado = new HashMap<String, Object>();
			for(int i = 0; i < nodos.getLength(); i++) {
				Map<String, Object> valor = new HashMap<String, Object>();
				current = nodos.item(i);				
				Node nodoTitularidad = null;
				NodeList nodosAlter = current.getChildNodes();
				Map<String, Object> listaTitularidad = new HashMap<String, Object>();
				for(int k = 0; k < nodosAlter.getLength(); k++) {
					if(nodosAlter.item(k).getNodeName().equals("respuestaTitularidad")) {
						nodoTitularidad = nodosAlter.item(k);
						Map<String, String> titularidad = new HashMap<String, String>();
						if(this.getProperty(nodoTitularidad, "registro") != null) {
							titularidad.put("registro", this.getProperty(nodoTitularidad, "registro"));
						}
						if(this.getProperty(nodoTitularidad, "libro") != null) {
							titularidad.put("libro", this.getProperty(nodoTitularidad, "libro"));
						}
						if(this.getProperty(nodoTitularidad, "apPaterno") != null) {
							titularidad.put("apPaterno", this.getProperty(nodoTitularidad, "apPaterno"));
						}
						if(this.getProperty(nodoTitularidad, "apMaterno") != null) {
							titularidad.put("apMaterno", this.getProperty(nodoTitularidad, "apMaterno"));
						}
						if(this.getProperty(nodoTitularidad, "nombre") != null) {
							titularidad.put("nombre", this.getProperty(nodoTitularidad, "nombre"));
						}
						if(this.getProperty(nodoTitularidad, "tipoDocumento") != null) {
							titularidad.put("tipoDocumento", this.getProperty(nodoTitularidad, "tipoDocumento"));
						}
						if(this.getProperty(nodoTitularidad, "numeroPartida") != null) {
							titularidad.put("numeroPartida", this.getProperty(nodoTitularidad, "numeroPartida"));
						}
						if(this.getProperty(nodoTitularidad, "numeroPlaca") != null) {
							titularidad.put("numeroPlaca", this.getProperty(nodoTitularidad, "numeroPlaca"));
						}
						if(this.getProperty(nodoTitularidad, "estado") != null) {
							titularidad.put("estado", this.getProperty(nodoTitularidad, "estado"));
						}
						if(this.getProperty(nodoTitularidad, "zona") != null) {
							titularidad.put("zona", this.getProperty(nodoTitularidad, "zona"));
						}
						if(this.getProperty(nodoTitularidad, "oficina") != null) {
							titularidad.put("oficina", this.getProperty(nodoTitularidad, "oficina"));
						}
						if(this.getProperty(nodoTitularidad, "direccion") != null) {
							titularidad.put("direccion", this.getProperty(nodoTitularidad, "direccion"));
						}
						listaTitularidad.put("titularidad", titularidad);
					}
					valor.put("listaTitularidad", listaTitularidad);
				}
				listaResultado.put("resultado", valor);
			}
			retorno.setParametros(listaResultado);
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return retorno;
	}
	
	private String getPeticionBuscarAeronaveWs(String nroMatricula) throws GmdException {
		StringBuffer buffer = new StringBuffer(2048);
		try {
			buffer.append("<con:buscarNaveAeronave xmlns:con=\"http://controller.pide.sunarp.gob.pe/\">");
			buffer.append("<numeroMatricula>" + nroMatricula + "</numeroMatricula>");
			buffer.append("</con:buscarNaveAeronave>");
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return buffer.toString();
	}
	
	private ResponseBean resultToRetornoAeronave(Document doc) throws GmdException{
		NodeList nodos = doc.getFirstChild().getChildNodes();
		Node current = null;
		ResponseBean retorno = null;
		retorno = new ResponseBean();
		try {
			Map<String, Object> listaResultado = new HashMap<String, Object>();
			for(int i = 0; i < nodos.getLength(); i++) {
				Map<String, Object> valor = new HashMap<String, Object>();
				current = nodos.item(i);				
				Node nodoAeronave = null;
				NodeList nodosAlter = current.getChildNodes();
				Map<String, Object> listaAeronave = new HashMap<String, Object>();
				for(int k = 0; k < nodosAlter.getLength(); k++) {
					if(nodosAlter.item(k).getNodeName().equals("respuestaNaveAeronave")) {
						nodoAeronave = nodosAlter.item(k);
						Map<String, Object> aeronave = new HashMap<String, Object>();
						if(this.getProperty(nodoAeronave, "matricula") != null) {
							aeronave.put("matricula", this.getProperty(nodoAeronave, "matricula"));
						}
						if(this.getProperty(nodoAeronave, "oficina") != null) {
							aeronave.put("oficina", this.getProperty(nodoAeronave, "oficina"));
						}
						if(this.getProperty(nodoAeronave, "numeroPartida") != null) {
							aeronave.put("numeroPartida", this.getProperty(nodoAeronave, "numeroPartida"));
						}
						if(this.getProperty(nodoAeronave, "registro") != null) {
							aeronave.put("registro", this.getProperty(nodoAeronave, "registro"));
						}
						if(this.getProperty(nodoAeronave, "libro") != null) {
							aeronave.put("libro", this.getProperty(nodoAeronave, "libro"));
						}
						if(this.getProperty(nodoAeronave, "numeroSerie") != null) {
							aeronave.put("numeroSerie", this.getProperty(nodoAeronave, "numeroSerie"));
						}
						if(this.getProperty(nodoAeronave, "modelo") != null) {
							aeronave.put("modelo", this.getProperty(nodoAeronave, "modelo"));
						}
						if(this.getProperty(nodoAeronave, "tomoFolio") != null) {
							NodeList nodosAlter2 = nodoAeronave.getChildNodes();
							List<String> listTomoFolios = new ArrayList<>();
							Node tomoFolio = null;
							for (int j = 0; j < nodosAlter2.getLength(); j++) {
								tomoFolio = nodosAlter2.item(j);
								listTomoFolios.add(this.getProperty(tomoFolio, "tomoFolio"));
							}							
							aeronave.put("tomoFolios", listTomoFolios);
						}												
						listaAeronave.put("aeronave", aeronave);
					}
					valor.put("listaAeronave", listaAeronave);
				}
				listaResultado.put("resultado", valor);
			}
			retorno.setParametros(listaResultado);
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return retorno;
	}
	
	private String getPeticionBuscarOficinasWs() throws GmdException {
		StringBuffer buffer = new StringBuffer(2048);
		try {
			buffer.append("<xmlns:con=\"http://controller.pide.sunarp.gob.pe/\">");
			buffer.append("</con:getOficinas>");
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return buffer.toString();
	}
	
	private ResponseBean resultToRetornoOficinas(Document doc) throws GmdException{
		NodeList nodos = doc.getFirstChild().getChildNodes();
		Node current = null;
		ResponseBean retorno = null;
		retorno = new ResponseBean();
		try {
			Map<String, Object> listaResultado = new HashMap<String, Object>();
			for(int i = 0; i < nodos.getLength(); i++) {
				Map<String, Object> valor = new HashMap<String, Object>();
				current = nodos.item(i);				
				Node nodoOficina = null;
				NodeList nodosAlter = current.getChildNodes();
				Map<String, Object> listaOficina = new HashMap<String, Object>();
				for(int k = 0; k < nodosAlter.getLength(); k++) {
					if(nodosAlter.item(k).getNodeName().equals("oficina")) {
						nodoOficina = nodosAlter.item(k);
						Map<String, String> oficina = new HashMap<String, String>();
						if(this.getProperty(nodoOficina, "codZona") != null) {
							oficina.put("codZona", this.getProperty(nodoOficina, "codZona"));
						}
						if(this.getProperty(nodoOficina, "codOficina") != null) {
							oficina.put("codOficina", this.getProperty(nodoOficina, "codOficina"));
						}
						if(this.getProperty(nodoOficina, "descripcion") != null) {
							oficina.put("descripcion", this.getProperty(nodoOficina, "descripcion"));
						}
												
						listaOficina.put("oficina", oficina);
					}
					valor.put("listaOficina", listaOficina);
				}
				listaResultado.put("resultado", valor);
			}
			retorno.setParametros(listaResultado);
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return retorno;
	}
	
	private String getPeticionBuscarAsientosWs(String zona, String oficina, String partida, String registro) throws GmdException{
		StringBuffer buffer = new StringBuffer(2048);
		try {
			buffer.append("<con:listarAsientos xmlns:con=\"http://controller.pide.sunarp.gob.pe/\">");
			buffer.append("<zona>" + zona + "</zona>");
			buffer.append("<oficina>" + oficina + "</oficina>");
			buffer.append("<partida>" + partida + "</partida>");
			buffer.append("<registro>" + registro + "</registro>");
			buffer.append("</con:listarAsientos>");
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return buffer.toString();
	}
	
	private ResponseBean resultToRetornoAsientos(Document doc) throws GmdException{
		NodeList nodos = doc.getFirstChild().getChildNodes();
		Node current = null;
		ResponseBean retorno = null;
		retorno = new ResponseBean();
		try {
			Map<String, Object> listaResultado = new HashMap<String, Object>();
			for(int i = 0; i < nodos.getLength(); i++) {
				Map<String, Object> valor = new HashMap<String, Object>();
				current = nodos.item(i);				
				Node nodoAsientos = null;
				NodeList nodosAlter = current.getChildNodes();
				Map<String, Object> listaAsientos = new HashMap<String, Object>();
				for(int k = 0; k < nodosAlter.getLength(); k++) {
					if(nodosAlter.item(k).getNodeName().equals("listAsientos")) {
						nodoAsientos = nodosAlter.item(k);
						Map<String, Object> asientos = new HashMap<String, Object>();
						if(this.getProperty(nodoAsientos, "transaccion") != null) {
							asientos.put("transaccion", this.getProperty(nodoAsientos, "transaccion"));
						}
						if(this.getProperty(nodoAsientos, "nroTotalPag") != null) {
							asientos.put("nroTotalPag", this.getProperty(nodoAsientos, "nroTotalPag"));
						}
						if(this.getProperty(nodoAsientos, "listAsientos") != null) {
														
							NodeList nodosAlter2 = nodoAsientos.getChildNodes();
							Map<String, Object> mapAsiento = new HashMap<String, Object>();
							Node asiento = null;
							for (int j = 0; j < nodosAlter2.getLength(); j++) {
								asiento = nodosAlter2.item(j);
								if(this.getProperty(asiento, "idImgAsiento") != null) {
									mapAsiento.put("idImgAsiento", this.getProperty(nodoAsientos, "idImgAsiento"));
								}
								if(this.getProperty(asiento, "numPag") != null) {
									mapAsiento.put("numPag", this.getProperty(nodoAsientos, "numPag"));
								}
								if(this.getProperty(asiento, "tipo") != null) {
									mapAsiento.put("tipo", this.getProperty(nodoAsientos, "tipo"));
								}
								if(this.getProperty(asiento, "listPag") != null) {
									//4to for
									NodeList nodosAlter3 = asiento.getChildNodes();
									Map<String, Object> mapPag = new HashMap<String, Object>();
									Node pagina = null;
									for (int l = 0; l < nodosAlter3.getLength(); l++) {
										pagina = nodosAlter3.item(l);
										if(this.getProperty(pagina, "nroPagRef") != null) {
											mapAsiento.put("nroPagRef", this.getProperty(nodoAsientos, "nroPagRef"));
										}
										if(this.getProperty(pagina, "pagina") != null) {
											mapAsiento.put("pagina", this.getProperty(nodoAsientos, "pagina"));
										}
									}
									mapAsiento.put("mapPag", mapPag);
								}
							}
							asientos.put("mapAsiento", mapAsiento);
						}						
						
						if(this.getProperty(nodoAsientos, "pagina") != null) {
							asientos.put("pagina", this.getProperty(nodoAsientos, "pagina"));
						}
						
						listaAsientos.put("asientos", asientos);
					}
					valor.put("listaAsientos", listaAsientos);
				}
				listaResultado.put("resultado", valor);
			}
			retorno.setParametros(listaResultado);
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return retorno;
	}
	
	private String getPeticionBuscarDetalleRPVWs(String zona, String oficina, String placa) throws GmdException{
		StringBuffer buffer = new StringBuffer(2048);
		try {
			buffer.append("<con:verDetalleRPV xmlns:con=\"http://controller.pide.sunarp.gob.pe/\">");
			buffer.append("<zona>" + zona + "</zona>");
			buffer.append("<oficina>" + oficina + "</oficina>");
			buffer.append("<placa>" + placa + "</placa>");
			buffer.append("</con:verDetalleRPV>");
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return buffer.toString();
	}
	
	private ResponseBean resultToRetornoDetalleRPV(Document doc) throws GmdException{
		NodeList nodos = doc.getFirstChild().getChildNodes();
		Node current = null;
		ResponseBean retorno = null;
		retorno = new ResponseBean();
		try {
			Map<String, Object> listaResultado = new HashMap<String, Object>();
			for(int i = 0; i < nodos.getLength(); i++) {
				Map<String, Object> valor = new HashMap<String, Object>();
				current = nodos.item(i);				
				Node nodoRPV = null;
				NodeList nodosAlter = current.getChildNodes();
				Map<String, Object> listaRPV = new HashMap<String, Object>();
				for(int k = 0; k < nodosAlter.getLength(); k++) {
					if(nodosAlter.item(k).getNodeName().equals("vehiculo")) {
						nodoRPV = nodosAlter.item(k);
						Map<String, Object> mapRPV = new HashMap<String, Object>();
						if(this.getProperty(nodoRPV, "placa") != null) {
							mapRPV.put("placa", this.getProperty(nodoRPV, "placa"));
						}
						if(this.getProperty(nodoRPV, "serie") != null) {
							mapRPV.put("serie", this.getProperty(nodoRPV, "serie"));
						}
						if(this.getProperty(nodoRPV, "vin") != null) {
							mapRPV.put("vin", this.getProperty(nodoRPV, "vin"));
						}
						if(this.getProperty(nodoRPV, "nro_motor") != null) {
							mapRPV.put("nro_motor", this.getProperty(nodoRPV, "nro_motor"));
						}
						if(this.getProperty(nodoRPV, "color") != null) {
							mapRPV.put("color", this.getProperty(nodoRPV, "color"));
						}
						if(this.getProperty(nodoRPV, "marca") != null) {
							mapRPV.put("marca", this.getProperty(nodoRPV, "marca"));
						}
						if(this.getProperty(nodoRPV, "modelo") != null) {
							mapRPV.put("modelo", this.getProperty(nodoRPV, "modelo"));
						}
						if(this.getProperty(nodoRPV, "estado") != null) {
							mapRPV.put("estado", this.getProperty(nodoRPV, "estado"));
						}
						if(this.getProperty(nodoRPV, "sede") != null) {
							mapRPV.put("sede", this.getProperty(nodoRPV, "sede"));
						}
						if(this.getProperty(nodoRPV, "propietarios") != null) {
							
							NodeList nodosAlter2 = nodoRPV.getChildNodes();
							List<String> listPropietarios = new ArrayList<>();
							for (int j = 0; j < nodosAlter2.getLength(); j++) {
								if(this.getProperty(nodoRPV, "nombre") != null) {
									listPropietarios.add(this.getProperty(nodoRPV, "nombre"));
								}
							}							
							
							mapRPV.put("propietarios", listPropietarios);
						}
												
						listaRPV.put("mapRPV", mapRPV);
					}
					valor.put("listaRPV", listaRPV);
				}
				listaResultado.put("resultado", valor);
			}
			retorno.setParametros(listaResultado);
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return retorno;
	}
	
	private String getPeticionBuscarImgAsientoWs(String transaccion, String idImg, String tipo, String nroTotalPag, String nroPagRef, String pagina) throws GmdException{
		StringBuffer buffer = new StringBuffer(2048);
		try {
			buffer.append("<con:verAsiento xmlns:con=\"http://controller.pide.sunarp.gob.pe/\">");
			buffer.append("<transaccion>" + transaccion + "</transaccion>");
			buffer.append("<idImg>" + idImg + "</idImg>");
			buffer.append("<tipo>" + tipo + "</tipo>");
			buffer.append("<nroTotalPag>" + nroTotalPag + "</nroTotalPag>");
			buffer.append("<nroPagRef>" + nroPagRef + "</nroPagRef>");
			buffer.append("<pagina>" + pagina + "</pagina>");
			buffer.append("</con:verAsiento>");
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return buffer.toString();
	}
	
	private ResponseBean resultToRetornoImgAsiento(Document doc) throws GmdException{
		NodeList nodos = doc.getFirstChild().getChildNodes();
		Node current = null;
		ResponseBean retorno = null;
		retorno = new ResponseBean();
		try {
			Map<String, Object> listaResultado = new HashMap<String, Object>();
			for(int i = 0; i < nodos.getLength(); i++) {
				Map<String, Object> valor = new HashMap<String, Object>();
				current = nodos.item(i);				
				Node nodoAsiento = null;
				NodeList nodosAlter = current.getChildNodes();
				Map<String, Object> listaAsiento = new HashMap<String, Object>();
				for(int k = 0; k < nodosAlter.getLength(); k++) {
					if(nodosAlter.item(k).getNodeName().equals("img")) {
						nodoAsiento = nodosAlter.item(k);
						Map<String, String> asiento = new HashMap<String, String>();
						if(this.getProperty(nodoAsiento, "img") != null) {
							asiento.put("img", this.getProperty(nodoAsiento, "img"));
						}
												
						listaAsiento.put("asiento", asiento);
					}
					valor.put("listaAsiento", listaAsiento);
				}
				listaResultado.put("resultado", valor);
			}
			retorno.setParametros(listaResultado);
		}catch(Exception exception) {
			throw new GmdException(exception);
		}
		return retorno;
	}
	
	/**
	 * 
	 * @param node
	 *            Nodo padre en el cual se busca la propiedad
	 * @param tag
	 *            Nombre del elemento buscado
	 * @return Devuelve el valor de un elemento <padre><tag1>xxx<tag1><tagN>xxx
	 *         <tagN></padre>
	 */
	private String getProperty(Node nodo, String tag) {
		NodeList props = nodo.getChildNodes();
		Node prop = null;
		String value = null;

		for (int j = 0, num = props.getLength(); j < num; j++) {
			prop = props.item(j);
			if (prop.getFirstChild()!= null && tag.equals(prop.getNodeName())) {
				value = prop.getFirstChild().getNodeValue();
				break;
			}
		}
		return value;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

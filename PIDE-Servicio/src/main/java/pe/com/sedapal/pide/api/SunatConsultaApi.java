package pe.com.sedapal.pide.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.servicio.ISunatService;
import pe.com.sedapal.pide.util.RespuestaBean;

@RestController
@RequestMapping(value = { "/api/consultaSunat" }, method = { RequestMethod.POST }, produces = { "application/JSON" })
public class SunatConsultaApi {
	
	@Autowired
	private ISunatService sunatService;

	private SunatConsultaApi(){		
	}

	@PostMapping(path = "/consulta-datosprincipales", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultagetDatosPrincipales(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunatService.consultagetDatosPrincipales(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-datossecundarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultagetDatosSecundarios(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunatService.consultagetDatosSecundarios(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-datost1144", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultagetDatosT1144(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunatService.consultagetDatosT1144(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-datost362", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultagetDatosT362(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunatService.consultagetDatosT362(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-domiciliolegal", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultagetDomicilioLegal(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunatService.consultagetDomicilioLegal(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-establecimientosanexos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaEstablecimientosAnexos(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunatService.consultaEstablecimientosAnexos(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-anexost1150", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaEstAnexosT1150(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunatService.consultaEstAnexosT1150(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-replegales", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaRepLegales(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunatService.consultaRepLegales(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-sunatrazonsocial", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaRazonSocial(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunatService.consultaRazonSocial(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}
}

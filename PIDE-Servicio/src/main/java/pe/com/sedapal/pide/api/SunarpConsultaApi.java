package pe.com.sedapal.pide.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.servicio.ISunarpService;
import pe.com.sedapal.pide.util.RespuestaBean;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = { "/api/consultaSunarp" }, method = { RequestMethod.POST }, produces = {MediaType.APPLICATION_JSON_VALUE})
public class SunarpConsultaApi {		
	
	@Autowired
	private ISunarpService sunarpService;
		
	@PostMapping(path = {"/consulta-titularidad"}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<RespuestaBean> consultaTitularidad(@RequestBody Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunarpService.consultaTitularidad(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-razonsocial", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaPersonaJuridica(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunarpService.consultaPersonaJuridica(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-aeronave", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaAeronave(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunarpService.consultaAeronave(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-oficinas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaOficinas(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunarpService.consultaOficinas(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-asientos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaAsientos(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunarpService.consultaAsientos(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-detallerpv", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaDetalleRPV(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunarpService.consultaDetalleRPV(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}

	@PostMapping(path = "/consulta-imgasiento", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaImgAsiento(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = sunarpService.consultaImgAsiento(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}
	
}

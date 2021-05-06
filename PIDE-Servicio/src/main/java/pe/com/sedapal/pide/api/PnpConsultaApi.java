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
import pe.com.sedapal.pide.servicio.IPnpService;
import pe.com.sedapal.pide.util.RespuestaBean;

@RestController
@RequestMapping(value = { "/api/consultaPnp" }, method = { RequestMethod.POST }, produces = { "application/JSON" })
public class PnpConsultaApi {

	@Autowired
	private IPnpService pnpService;
	
	private PnpConsultaApi(){		
	}

	@PostMapping(path = "/consulta-dnigeneral", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaDniGeneral(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = pnpService.consultaDniGeneral(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}
	
	@PostMapping(path = "/consulta-nombregeneral", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultaNombreGeneral(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = pnpService.consultaNombreGeneral(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}
}

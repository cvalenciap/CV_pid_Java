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
import pe.com.sedapal.pide.servicio.ISuneduService;
import pe.com.sedapal.pide.util.RespuestaBean;

@RestController
@RequestMapping(value = { "/api/consultaSunedu" }, method = { RequestMethod.POST }, produces = { "application/JSON" })
public class SuneduConsultaApi {
	
	@Autowired
	private ISuneduService suneduService;

	private SuneduConsultaApi(){		
	}

	@PostMapping(path = "/consulta-rngt", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaBean> consultarRNGT(@RequestParam Map<String, String> requestParm) throws GmdException {
		RespuestaBean resultadoCons = suneduService.consultarRNGT(requestParm);
		return new ResponseEntity<RespuestaBean>(resultadoCons, HttpStatus.OK);
	}
}

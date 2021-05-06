package pe.com.sedapal.pide.servicio;

import java.util.List;

import pe.com.gmd.util.exception.GmdException;
import pe.com.sedapal.pide.model.PideDetalleGeneral;

public interface IPideDetalleGeneralService {
//	
	void eliminar(PideDetalleGeneral pideDetalleGeneral)throws GmdException;
	
	List<PideDetalleGeneral> buscarPideDetalleGeneral1(Integer idGeneral, String stRegi) throws GmdException;
	List<PideDetalleGeneral> buscarPideDetalleGeneral2(Integer idGeneral, String stRegi) throws GmdException;
	List<PideDetalleGeneral> listDetallesGenerales(Integer idGeneral) throws GmdException;
	List<PideDetalleGeneral> listDetallesGenerales_i(Integer idGeneral) throws GmdException;
	List<PideDetalleGeneral> listDetallesGenerales_m(Integer idGeneral) throws GmdException;
	List<PideDetalleGeneral> listDetallesGeneralesPara(Integer idGeneral, String valor1) throws GmdException;

}

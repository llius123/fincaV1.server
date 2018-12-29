package fincaV1.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fincaV1.server.entity.TipofacturaBean;
import fincaV1.server.entity.ResponseBean;
import fincaV1.server.servicegeneric.GenericServiceImp;

@RestController
public class TipofacturaRestController {

	@Autowired
	private GenericServiceImp genericService;
	
	@RequestMapping(value="/tipofacturas", method=RequestMethod.GET)
	public List<TipofacturaBean> incidencias() {
		return (List<TipofacturaBean>) genericService.getAll(TipofacturaBean.class);
	}
	
	@RequestMapping(value="/tipofacturas/{id}", method=RequestMethod.GET)
	public TipofacturaBean incidencia(@PathVariable int id) {
		return (TipofacturaBean) genericService.get(TipofacturaBean.class, id);
	}
	
	@RequestMapping(value="/tipofacturas/{id}", method=RequestMethod.DELETE)
	public ResponseBean incidenciadelete(@PathVariable int id) {
		return new ResponseBean(200, genericService.delete(genericService.get(TipofacturaBean.class, id)));
	}
	
	@RequestMapping(value="/tipofacturas", method=RequestMethod.POST)
	public ResponseBean incidenciasave(@RequestBody TipofacturaBean incidencia) {
		return new ResponseBean(200, "Registro creado con id: " + genericService.save(incidencia));
	}
	
	@RequestMapping(value="/tipofacturas", method=RequestMethod.PUT)
	public ResponseBean incidenciaupdate(@RequestBody TipofacturaBean incidencia) {
		return new ResponseBean(200, genericService.saveOrUpdate(incidencia));
	}
}

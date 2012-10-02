package org.proyecto.empresaB.mvc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.proyecto.empresaB.model.Carro_B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
@RequestMapping("/carro")
public class CarroController {

	
	@Autowired
	Carro_B carro_b;

	
	
	protected static Logger logger = Logger.getLogger("*en CarroController*");
	
	@RequestMapping(value="/sumaProducto", method = RequestMethod.GET)
	public ModelAndView sumaProducto(@RequestParam(value="cantidad")String cantidad, @RequestParam(value="idProducto")String  idProducto) throws Exception{
		
		logger.info("cantidad Recibida"+ cantidad);
		logger.info("idproducto Recibido"+ idProducto);
		//HttpSession session=context.
		
		return new ModelAndView("redirect:../../productos/listado");
	}
	

	
}

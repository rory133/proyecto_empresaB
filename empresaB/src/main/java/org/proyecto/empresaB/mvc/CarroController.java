package org.proyecto.empresaB.mvc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carro")
public class CarroController {

	
	protected static Logger logger = Logger.getLogger("*en CarroController*");
	
	@RequestMapping(value="/sumaProducto", method = RequestMethod.GET)
	public ModelAndView sumaProducto(@RequestParam(value="cantidad")String cantidad, @RequestParam(value="idProducto")String  idProducto) throws Exception{
		
		logger.info("cantidad Recibida"+ cantidad);
		logger.info("idproducto Recibido"+ idProducto);
		
		
		return new ModelAndView("redirect:../../productos/listado");
	}
	

	
}

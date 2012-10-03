package org.proyecto.empresaB.mvc;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.proyecto.empresaB.model.Carro_B;
import org.proyecto.empresaB.service.impl.Carro_BServiceImpl;
import org.proyecto.empresaB.service.impl.Cliente_BServiceImpl;
import org.proyecto.empresaB.service.impl.Producto_BSeleccionadoServiceImpl;
import org.proyecto.empresaB.service.impl.Productos_BServiceImpl;
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

	
/*	@Autowired
	Carro_B carro_b;*/
	
	@Autowired
	private Productos_BServiceImpl productos_BServiceImpl;
	
	@Autowired
	private Producto_BSeleccionadoServiceImpl producto_BSeleccionadoService;
	
	@Autowired
	private Cliente_BServiceImpl cliente_BServiceImpl;
	
	@Autowired
	Carro_BServiceImpl carro_BService;
	
	
	
	
	
	protected static Logger logger = Logger.getLogger("*en CarroController*");
	
	@RequestMapping(value="/sumaProducto", method = RequestMethod.GET)
	public ModelAndView sumaProducto(@RequestParam(value="cantidad")String cantidad, @RequestParam(value="idProducto")String  idProducto, HttpSession session) throws Exception{
	//	carro_BService.save(carro_b);
		//Carro_B carro_b=new Carro_B(new Date(),)
		logger.info("session.getAttributeNames().toString()"+session.getAttributeNames().toString());
		
		logger.info("cantidad Recibida"+ cantidad);
		logger.info("idproducto Recibido"+ idProducto);
		//HttpSession session=context.
		
		return new ModelAndView("redirect:../../productos/listado");
	}
	

	
}

package org.proyecto.empresaB.mvc;


import java.util.Date;
import java.util.List;

import org.proyecto.empresaB.service.Productos_BService;
import org.proyecto.empresaB.service.impl.Productos_BServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import org.proyecto.empresaB.bo.Producto_BBo;
import org.proyecto.empresaB.bo.impl.Producto_BBoImpl;
import org.proyecto.empresaB.model.Producto_B;



@Controller
@RequestMapping("/productos")
public class Producto_BController {

	@Autowired
	private Productos_BServiceImpl productos_BServiceImpl;
	
	protected static Logger logger = Logger.getLogger("*en Producto_BController*");
		
	
	
	
	
	
	@RequestMapping(value="/listado",method=RequestMethod.GET)
	public ModelAndView listadoProductos_B(){
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		logger.info("en listadoProductos_B2*");
		
		logger.info("tamaño proddddducto: "+lista.size());
	    return new ModelAndView("listaProductos","productos", lista);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addContact() {
	 
		return new ModelAndView("crearProducto_B", "producto_b",new Producto_B());
	 
	     
	    }

}

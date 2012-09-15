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
	//protected static Logger logger = Logger.getLogger("*en productossssss*");
/*	@Autowired
	@Qualifier( "productoService" )
	private Productos_BService productoService;*/
	


	@Autowired
	private Productos_BServiceImpl productos_BServiceImpl;
	
/*	@Autowired
	private Producto_B producto_B;*/
	
	
/*	@Autowired
	public Producto_BController (Productos_BServiceImpl productos_BServiceImpl){
		this.productos_BServiceImpl = productos_BServiceImpl;
	}
	*/
/*	@Autowired
	private Producto_BBo producto_BBo;*/
	
	
	
/*	public void Producto_BController(Producto_BBoImpl producto_BBoImpl){
		logger.info("en producto_Bcontroler");
		this.producto_BBo=(Producto_BBo) producto_BBoImpl;
		
	}*/
		
	
	
	
	
	protected static Logger logger = Logger.getLogger("*en Producto_BController*");
	
	@RequestMapping(value="/listado",method=RequestMethod.GET)
	public ModelAndView listadoProductos_B(){
		logger.info("en listadoProductos_B1*");
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		logger.info("en listadoProductos_B2*");
		
		logger.info("proucto"+lista.get(545).getNombre_productoB());
	
       // String message="en listado productos";
        return new ModelAndView("listaProductos","productos", lista);
/*		logger.info("en requestMapping home**");
        String message=new Date().toString();
        return new ModelAndView("home","message", message);*/
		
	}

}

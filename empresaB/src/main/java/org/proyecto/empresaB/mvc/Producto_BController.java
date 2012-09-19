package org.proyecto.empresaB.mvc;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;


import org.proyecto.empresaB.service.Productos_BService;
import org.proyecto.empresaB.service.impl.Productos_BServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	    return new ModelAndView("producto_b/listaProductos","productos", lista);
	}
	
	/*@RequestMapping(value = "/add", method = RequestMethod.GET)*/
	@RequestMapping(method = RequestMethod.GET, params="new")
	public ModelAndView addContact() {
		logger.info("metodo get --new-- ");
		return new ModelAndView("producto_b/edit", "producto_b",new Producto_B());
	  }
	

	@RequestMapping(method = RequestMethod.POST)

	public ModelAndView addProducto_B_form(@Valid @ModelAttribute("producto_b")Producto_B producto_b,  BindingResult  result,@RequestParam(value="image",required=false)MultipartFile image){


		
		if(result.hasErrors()) {
		logger.info("addProducto_B_form ------tiene errores----"+result.toString());
			return new ModelAndView("producto_b/edit", "producto_b",new Producto_B()).addAllObjects(result.getModel());
			/*.addAllObjects(result.getModel()*/
			/*.addObject(result.getAllErrors())*/
			  }
		else{
			
			logger.info("addProducto_B_form ------NO tiene errores----");
		logger.info("nombre producto a añadir "+ producto_b.getNombre_productoB());
		productos_BServiceImpl.save(producto_b);
		logger.info("addProducto_B_form ");
		
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		return new ModelAndView("producto_b/listaProductos","productos", lista);
		}
		
}
	
/*	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addProducto_B_form(@Valid Producto_B producto_b, BindingResult result) {


		
		if(result.hasErrors()) {
		logger.info("addProducto_B_form ------tiene errores----");
			return new ModelAndView("producto_b/edit", "producto_b",new Producto_B());
			
			  }
		else{
			
			logger.info("addProducto_B_form ------NO tiene errores----");
		logger.info("nombre producto a añadir "+ producto_b.getNombre_productoB());
		productos_BServiceImpl.save(producto_b);
		logger.info("addProducto_B_form ");
		
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		return new ModelAndView("producto_b/listaProductos","productos", lista);
		}
		
	    }*/
	
/*	@RequestMapping(method = RequestMethod.POST)
	public String addProducto_B_form(@Valid Producto_B producto_b, BindingResult result) {

		
		
		if(result.hasErrors()) {
		logger.info("addProducto_B_form ------tiene errores----");
			return "producto_b/edit";
			
			  }
		else{
			
			logger.info("addProducto_B_form ------NO tiene errores----");
		logger.info("nombre producto a añadir "+ producto_b.getNombre_productoB());
		productos_BServiceImpl.save(producto_b);
		logger.info("addProducto_B_form ");
		
		
		return "redirect:/producto_b/listaProductos";
		}
		
	    }*/

}

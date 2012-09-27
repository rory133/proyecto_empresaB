package org.proyecto.empresaB.mvc;


import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.proyecto.empresaB.model.Cliente_B;
import org.proyecto.empresaB.model.Producto_B;
import org.proyecto.empresaB.service.impl.Cliente_BServiceImpl;
import org.proyecto.empresaB.service.impl.Productos_BServiceImpl;
import org.proyecto.empresaB.util.ListaProvincias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private Cliente_BServiceImpl cliente_BServiceImpl;
	
	
	@Autowired
	ServletContext context;
	
	


	
	protected static Logger logger = Logger.getLogger("*en Cliente_B_BController*");
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, params="new")
	public ModelAndView addContact() {
		logger.info("metodo get --new-- ");
		return new ModelAndView("cliente_b/edit", "cliente_b",new Cliente_B()  );

	  }
	
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addProducto_B_form(@Valid @ModelAttribute("cliente_b")Cliente_B cliente_b, BindingResult  result) {

		
		logger.info("inicio de addCliente_B_form");
		if(result.hasErrors()) {
		logger.info("addCliente_B_form ------tiene errores----"+result.toString());
		logger.info("errores: "+result.toString());
		 return new ModelAndView("cliente_b/edit", "cliente_b",new Cliente_B()).addAllObjects(result.getModel());

		}
	
		logger.info("addCliente_B_form ");
		cliente_b.setFecha_alta_b(new Date());
		cliente_b.setTipo("CLIENTE");
		cliente_BServiceImpl.save(cliente_b);

		return new ModelAndView("redirect:listado");
}
	
	
	
	
	
	
	@RequestMapping(value="/listado",method=RequestMethod.GET)
	public ModelAndView listadoProductos_B(){
		List<Cliente_B> lista =cliente_BServiceImpl.findAll();
		logger.info("en listadoProductos_B2*");
		
		logger.info("tamaño lista en listado: "+lista.size());
		

	   return new ModelAndView("cliente_b/listaClientes","clientes", lista);
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView editCliente_B_form(String id){


	
		Cliente_B cliente_b= new Cliente_B();
		cliente_b= cliente_BServiceImpl.findByCliente_BIdCliente_b(id);
					
		logger.info("producto pasado a edit-modificar: "+cliente_b.getNombre_b());
		
		
		//List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		//return new ModelAndView("producto_b/listaProductos","productos", lista);
		return new ModelAndView("cliente_b/modificar", "cliente_b",cliente_b);
	
}
	@RequestMapping(value="/modificarCliente_B", method = RequestMethod.POST)
	public ModelAndView modCliente_B_form(@Valid @ModelAttribute("cliente_b")Cliente_B cliente_b, BindingResult  result) {

		
		logger.info("inicio de modCliente_B_form");
		if(result.hasErrors()) {
		logger.info("modCliente_B_form ------tiene errores----"+result.toString());
		logger.info("errores: "+result.toString());
		 return new ModelAndView("cliente_b/edit", "cliente_b",new Cliente_B()).addAllObjects(result.getModel());

		}
	

	/*		CODIGO DE CUANDO NO MOSTRABA Ñss
		logger.info("modificarProducto_B_form ------NO tiene errores----");
		logger.info("nombre producto a añadir "+ producto_b.getNombre_productoB());
		//productos_BServiceImpl.save(producto_b);
		logger.info("modificarProducto_B_form ");
		String nombre =producto_b.getNombre_productoB();
		//String nombre =new String();
		try {
		logger.info("el nombre insertado en try antes de cambio: "+nombre);
		nombre =new String (producto_b.getNombre_productoB().getBytes("ISO-8859-1"),"UTF-8");
		//nombre =new String (producto_b.getNombre_productoB().getBytes("UTF-8"),"ISO-8859-1");
		//nombre =new String (nombre1.getBytes("ISO-8859-1"),"UTF-8");
		
		logger.info("el nombre insertado en try despue de cambio: "+nombre);
		} catch(UnsupportedEncodingException uee) {
		    uee.printStackTrace();
		}
		
		
		logger.info("el nombre modificado-update fuera try: "+nombre);
		producto_b.setNombre_productoB(nombre);
		
		*/

		logger.info("modCliente_B_form ");
		cliente_b.setFecha_alta_b(new Date());
		cliente_b.setTipo("CLIENTE");
		cliente_BServiceImpl.update(cliente_b);

		return new ModelAndView("redirect:listado");
		
	
	
	}
	@RequestMapping(value="/borrar",method=RequestMethod.GET)
	public ModelAndView delCliente_B_form(String id){

		logger.info("en borrar producto con id: "+id);
		Cliente_B cliente_b= new Cliente_B();
		cliente_b= cliente_BServiceImpl.findByCliente_BIdCliente_b(id);
		cliente_BServiceImpl.delete(cliente_b);
		
		logger.info("borrando cliente : "+cliente_b.getNombre_b());

		return new ModelAndView("redirect:listado");

}
	

}

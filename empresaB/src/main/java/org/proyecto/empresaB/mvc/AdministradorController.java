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
import org.proyecto.empresaB.model.Administrador_B;
import org.proyecto.empresaB.model.Producto_B;
import org.proyecto.empresaB.model.Usuario_B;
import org.proyecto.empresaB.service.impl.Administrador_BServiceImpl;
import org.proyecto.empresaB.service.impl.Productos_BServiceImpl;
import org.proyecto.empresaB.util.ListaProvincias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/administradores")
public class AdministradorController {
	
	@Autowired
	private Administrador_BServiceImpl administrador_BServiceImpl;
	
	
	@Autowired
	ServletContext context;
	
	


	
	protected static Logger logger = Logger.getLogger("*en Administrador_B_BController*");
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, params="new")
	public ModelAndView addContact() {
		logger.info("metodo get --new-- ");
		return new ModelAndView("administrador_b/edit", "administrador_b",new Administrador_B()  );

	  }
	
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addAdministrador_B_form(@Valid @ModelAttribute("administrador_b")Administrador_B administrador_b, BindingResult  result)throws Exception {

		
		logger.info("inicio de addAdministrador_B_form");
		if(result.hasErrors()) {
		logger.info("addAdministrador_B_form ------tiene errores----"+result.toString());
		logger.info("errores: "+result.toString());
		 return new ModelAndView("administrador_b/edit", "administrador_b",new Administrador_B()).addAllObjects(result.getModel());

		}
	
		logger.info("addAdministrador_B_form ");
	
		administrador_b.setAUTHORITY("ROLE_ADMIN");
		administrador_b.setENABLED(true);
		administrador_BServiceImpl.save(administrador_b);

		return new ModelAndView("redirect:listado");
}
	
	
	
	
	
	
	@RequestMapping(value="/listado",method=RequestMethod.GET)
	public ModelAndView listadoAdministrador_B(){
		List<Administrador_B> lista =administrador_BServiceImpl.findAll();
		logger.info("en listadoProductos_B2*");
		
		logger.info("tama�o lista en listado: "+lista.size());
		

	   return new ModelAndView("administrador_b/listaAdministradores","administradores", lista);
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView editAdministrador_B_form(String id){


	
		Administrador_B administrador_b= new Administrador_B();
		administrador_b= administrador_BServiceImpl.findByAdministrador_BIdAdministrador_b(id);
					
		logger.info("producto pasado a edit-modificar: "+administrador_b.getNombre_b());
		
		
		//List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		//return new ModelAndView("producto_b/listaProductos","productos", lista);
		return new ModelAndView("administrador_b/modificar", "administrador_b",administrador_b);
	
}
	@RequestMapping(value="/modificarAdministrador_B", method = RequestMethod.POST)
	public ModelAndView modAdministrador_B_form(@Valid @ModelAttribute("administrador_b")Administrador_B administrador_b, BindingResult  result) throws Exception{

		Usuario_B usuarioBuscado=administrador_BServiceImpl.findByAdministrador_B_login_usuario_b(administrador_b.getLogin_usuario_b());
		Integer idusuarioBuscado=null;
		if (null!=usuarioBuscado){
		idusuarioBuscado=usuarioBuscado.getIdusuarios_b();
		}
		Integer idadministrador_b=administrador_b.getIdusuarios_b();
		
	
		//if (null !=usuarioBuscado){
			
		if ((null !=usuarioBuscado)&& (idusuarioBuscado==idadministrador_b)){
			result.addError(new ObjectError("loginInvalido", "Este usuario ya existe"));
			logger.info("null !=usuarioBuscado"+(null !=usuarioBuscado));

			
		}
		
		
		logger.info("inicio de modAdministrador_B_form");
		if(result.hasErrors()) {
		logger.info("modAdministrador_B_form ------tiene errores----"+result.toString());
		logger.info("errores: "+result.toString());
		 return new ModelAndView("administrador_b/edit", "administrador_b",new Administrador_B()).addAllObjects(result.getModel());

		}
	

	/*		CODIGO DE CUANDO NO MOSTRABA �ss
		logger.info("modificarProducto_B_form ------NO tiene errores----");
		logger.info("nombre producto a a�adir "+ producto_b.getNombre_productoB());
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

		logger.info("modAdministrador_B_form ");
		
		administrador_b.setAUTHORITY("ROLE_ADMIN");
		administrador_b.setENABLED(true);
		administrador_BServiceImpl.update(administrador_b);

		return new ModelAndView("redirect:listado");
		
	
	
	}
	@RequestMapping(value="/borrar",method=RequestMethod.GET)
	public ModelAndView delAdministrador_B_form(String id){
		logger.info(" en borrrar administrador ");
		logger.info("en borrar con ide con id: "+id);
		Administrador_B administrador_b= new Administrador_B();
		administrador_b= administrador_BServiceImpl.findByAdministrador_BIdAdministrador_b(id);
		logger.info(" con administrador : "+administrador_b.getNombre_b());
		administrador_BServiceImpl.delete(administrador_b);
		
		logger.info("borrando administrador : "+administrador_b.getNombre_b());

		return new ModelAndView("redirect:listado");

}
	

}
package org.proyecto.empresaB.mvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.proyecto.empresaB.model.Carro_B;
import org.proyecto.empresaB.model.Cliente_B;
import org.proyecto.empresaB.model.Producto_B;
import org.proyecto.empresaB.model.Producto_BSeleccionado;
import org.proyecto.empresaB.model.Usuario_B;
import org.proyecto.empresaB.service.impl.Carro_BServiceImpl;
import org.proyecto.empresaB.service.impl.Cliente_BServiceImpl;
import org.proyecto.empresaB.service.impl.Producto_BSeleccionadoServiceImpl;
import org.proyecto.empresaB.service.impl.Productos_BServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
@RequestMapping("/carro")
@SessionAttributes("carro_B")
public class CarroController {

	
	@Autowired
	private Carro_B carro_b;
	
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
		logger.info("session.getAttribute('carro_b')-al entrar: " + session.getAttribute("carro_b"));
		if (session.getAttribute("carro_b")==null){
			logger.info("if (carro_b.getIdcarro_b()==null)");
			Carro_B carro_b =new Carro_B();
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			logger.info("usuario user user.getUsername() : "+user.getUsername());
			Usuario_B usuario= new Usuario_B();
			usuario= cliente_BServiceImpl.findByCliente_B_login_usuario_b(user.getUsername());
			Cliente_B cliente= new Cliente_B();
			cliente=(Cliente_B)usuario;
			carro_b.setCliente_b(cliente);
			carro_b.setFecha_b(new Date());			
			carro_BService.save(carro_b);
			session.setAttribute("carro_b", carro_b);
			logger.info("if (carro_b.getIdcarro_b()==null) despues    :  " +carro_b.getIdcarro_b() );
		}
		
		carro_b=(Carro_B)session.getAttribute("carro_b");
		logger.info("imprimo el id del carro: "+carro_b.getIdcarro_b());
		logger.info("imprimo la fecha del carro: "+carro_b.getFecha_b());
		//Carro_B carro_b=new Carro_B(new Date(),)
		logger.info("session.getAttributeNames().toString()"+session.getAttributeNames().toString());
		logger.info("session.getAttribute('carro_b'): " + session.getAttribute("carro_b"));
		logger.info("session Id:"+session.getId());
		logger.info("cantidad Recibida"+ cantidad);
		
		logger.info("idproducto Recibido"+ idProducto);
		logger.info("usuario de la sesion : "+session.getAttribute("user"));
		logger.info("carro de la sesion : "+session.getAttribute("carro"));
		
		
		logger.info("datos carro id"+carro_b.getIdcarro_b());
		
		
		
		

		
	
		
		Producto_B producto=new Producto_B();
		producto=productos_BServiceImpl.findByProducto_BIdProducto_b(idProducto);
		
		
		
		Producto_BSeleccionado producto_BSeleccionado=new Producto_BSeleccionado();
		
		producto_BSeleccionado.setProducto_b(producto);
		producto_BSeleccionado.setCarro_b(carro_b);	
		producto_BSeleccionado.setCantidad(Integer.parseInt(cantidad));
		//producto_BSeleccionado.setIdproductob(producto.getIdproductob());
		
		
		/*
		producto.getProductos_b_seleccionados().add(producto_BSeleccionado);
		productos_BServiceImpl.update(producto);
		
		*/
		
		logger.info("carro_b.getIdcarro_b():"+carro_b.getIdcarro_b());
		Producto_BSeleccionado producto_BSeleccionado_test=new Producto_BSeleccionado();
		logger.info("Producto_BSeleccionado producto_BSeleccionado_test=new Producto_BSeleccionado();");
		producto_BSeleccionado_test=producto_BSeleccionadoService.findByProducto_BSeleccionadoIdProducto_b_y_carro_b(String.valueOf(producto.getIdproductob()),String.valueOf( carro_b.getIdcarro_b()));
		
		logger.info("producto_BSeleccionado_test=producto_BSeleccionadoService.findByProducto_BSeleccionadoIdProducto_b_y_carro_b.....");
		if (null!=producto_BSeleccionado_test){
		//logger.info("producto_BSeleccionado_test idproducto="+producto_BSeleccionado_test.getIdproductob());
		logger.info("producto_BSeleccionado_test idcarro="+producto_BSeleccionado_test.getCarro_b().getIdcarro_b());
		logger.info("producto_BSeleccionado cantidad" +producto_BSeleccionado.getCantidad());
		logger.info("producto_BSeleccionado id producto" +producto_BSeleccionado.getProducto_b().getIdproductob());
		logger.info("producto_BSeleccionado id " +producto_BSeleccionado.getIdproductoSeleccionado());
		logger.info("producto_BSeleccionado id " +producto_BSeleccionado.getCarro_b().getIdcarro_b());
		logger.info("producto_BSeleccionado_test id " +producto_BSeleccionado_test.getIdproductoSeleccionado());
		producto_BSeleccionado.setIdproductoSeleccionado(producto_BSeleccionado_test.getIdproductoSeleccionado());
		producto_BSeleccionadoService.update(producto_BSeleccionado);
		
		}else{
		producto_BSeleccionadoService.save(producto_BSeleccionado);
		//producto_BSeleccionadoService.update(producto_BSeleccionado);
		
		}
		carro_b.getProducto_BSeleccionado().add(producto_BSeleccionado);
		//carro_BService.update(carro_b);
		logger.info("carro_b.getProducto_BSeleccionado().size()="+carro_b.getProducto_BSeleccionado().size());
		
	/*	
		Set<Producto_BSeleccionado> listaProductos = new HashSet<Producto_BSeleccionado>(0);
		listaProductos.addAll(carro_b.getProducto_BSeleccionado());
		logger.info("tamaño elemento de listaproductos"+listaProductos.size());
		
	*/
		ModelAndView mav= new ModelAndView("producto_b/listaProductos");
		//List<Producto_BSeleccionado> listaProductos=producto_BSeleccionadoService.findByProducto_BSeleccionadoPorIdcarro_b(String.valueOf( carro_b.getIdcarro_b()));
		
		//logger.info("tamaño elemento de listaproductos"+listaProductos.size());
	
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		mav.addObject("productos", lista);
	//	mav.addObject("productosSeleccionados",listaProductos);
		return mav;
		//return new ModelAndView("redirect:../../productos/listado");
	}
	

	
}

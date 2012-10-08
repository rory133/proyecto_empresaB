package org.proyecto.empresaB.mvc;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.proyecto.empresaB.model.Carro_B;
import org.proyecto.empresaB.model.Producto_B;
import org.proyecto.empresaB.model.TarjetaCredito;
import org.proyecto.empresaB.service.impl.Carro_BServiceImpl;
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
@RequestMapping("/tarjeta")
public class tarjetaController {
	
	@Autowired
	private Carro_B carro_b;
	
	@Autowired
	Carro_BServiceImpl carro_BService;
	
	
	protected static Logger logger = Logger.getLogger("*en tarjetaController*");
	

	
	@RequestMapping(value="/validarTarjeta", method = RequestMethod.POST)
	public ModelAndView validarTarjeta(@Valid @ModelAttribute("tarjetaCredito")TarjetaCredito tarjetaCredito,  BindingResult  result, @RequestParam(value="idCarro")String  idCarro, HttpSession session)throws Exception{

		carro_b=carro_BService.findByCarro_BIdCarro_b(idCarro);
		
		if(result.hasErrors()) {
			logger.info("validarTarjeta:---tiene errores----"+result.toString());
				
				ModelAndView mav= new ModelAndView("carro_b/datosTarjeta");
				mav.addObject("tarjetaCredito", tarjetaCredito);
				mav.addAllObjects(result.getModel());
				mav.addObject("carro", carro_b);
				return mav;
			}
		carro_b.setPagado(true);
		carro_BService.update(carro_b);
		session.removeAttribute("carro_b");
		ModelAndView mav= new ModelAndView("redirect: ../../../carro/verTodosLosPedidos");
		return mav;
		
  }
}
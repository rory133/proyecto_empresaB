package com.proyecto.empresaB.mvc;

import java.util.Date;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	
	protected static Logger logger = Logger.getLogger("*en homeController*");
	
	@RequestMapping(value="/aa", method = RequestMethod.GET)
    public ModelAndView home() {
		logger.info("en requestMapping home**");
        String message=new Date().toString();
        return new ModelAndView("home","message", message);
	}
	
/*	@RequestMapping(value="/aa.htm", method = RequestMethod.GET)
    public String home() {
		logger.info("en requestMapping home**");
        String message=new Date().toString();
        return "home";
	}*/
	

}

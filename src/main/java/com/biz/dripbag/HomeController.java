package com.biz.dripbag;

import java.io.IOException;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.drip.controller.Crwaling;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	Crwaling crwaling;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws IOException 
	{
		crwaling = new Crwaling();
		model.addAttribute("TEST", crwaling.test());
		return "home";
	}
	
}

package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.config.TilesView;

@Controller
public class UserController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("hello", "Hello Sir");
		return TilesView.ADMIN_HOME;
	}
}

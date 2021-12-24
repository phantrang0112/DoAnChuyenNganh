package com.trang.TrangWebYTe.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.Controller.Admin.homeadmincontroller;
import com.trang.TrangWebYTe.Controller.BacSi.HomeBacSiController;
import com.trang.TrangWebYTe.mapper.NewsMapper;
import com.trang.TrangWebYTe.model.News;
import com.trang.TrangWebYTe.model.NewsExample;

@Controller
public class homeImportant {
	@Autowired
	NewsMapper newsMapper;
	@Autowired
	HomeBacSiController homeBacsi;
	@Autowired
	homeadmincontroller homeAdmin;
	@GetMapping("/homeImportant")
	public ModelAndView homeImportant(Principal principal) {
		UserDetails userDetails= (UserDetails) ((Authentication) principal).getPrincipal();
		System.out.println(userDetails.getAuthorities().toString()+userDetails.getUsername());
		ModelAndView modelAndView;
		if(userDetails.getAuthorities().toString().contains("BACSI")) {
			 modelAndView= homeBacsi.home(principal);
		}
		else if(userDetails.getAuthorities().toString().contains("ADMIN")) {
		
			 modelAndView= homeAdmin.homeAdmin();
			 
		}
		else {
			modelAndView= new ModelAndView("user/home");
			NewsExample newsExample= new NewsExample();
			newsExample.setOrderByClause(newsExample.getOrderByClause()+","+"ngaytao DESC");
			List<News> newsList= newsMapper.selectByExample(newsExample);
			
			modelAndView.addObject("listNews",newsList);
			 modelAndView.addObject("user", userDetails.getUsername());
		}
		return modelAndView;
	}
	
}

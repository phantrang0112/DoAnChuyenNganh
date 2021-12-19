package com.trang.TrangWebYTe.Controller.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.trang.TrangWebYTe.mapper.NewsMapper;
import com.trang.TrangWebYTe.mapper.RoleMapper;
import com.trang.TrangWebYTe.mapper.UserMapper;
import com.trang.TrangWebYTe.model.News;
import com.trang.TrangWebYTe.model.NewsExample;
import com.trang.TrangWebYTe.model.Role;
import com.trang.TrangWebYTe.model.RoleExample;
import com.trang.TrangWebYTe.model.User;
import com.trang.TrangWebYTe.model.UserExample;
import com.trang.TrangWebYTe.model.UserWithBLOBs;

@Controller
public class HomeController {
	@Autowired
	UserMapper userMapper;
	@Autowired
	RoleMapper RoleMapper;
	@Autowired
	NewsMapper newsMapper;

	@GetMapping(value = { "/", "/login" }) // ten view luc chay tren local
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login"); // truyen vao ten view
		String messageString="Chào mừng bạn đến với Trang Web Hỗ Trợ Y Tế";
		modelAndView.addObject("message",messageString );
		return modelAndView;

	}
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("user/home");
		NewsExample newsExample= new NewsExample();
		newsExample.setOrderByClause(newsExample.getOrderByClause()+","+"ngaytao DESC");
		List<News> newsList= newsMapper.selectByExample(newsExample);
		modelAndView.addObject("listNews",newsList);
		return modelAndView;
	}
	@GetMapping("/homedetail{newsid}")
	public ModelAndView homedetail(@PathVariable int newsid,ModelAndView model) {
		ModelAndView modelAndView = new ModelAndView("user/homedetail");
//		NewsExample newsExample= new NewsExample();
//		newsExample.createCriteria().andIdnewsEqualTo(id);
//		Integer.parseInt(newsid);
		News news=newsMapper.selectByPrimaryKey(newsid);
		if(news!=null) {
			modelAndView.addObject("News",news);
		}
		else {
			modelAndView = new ModelAndView("user/home");
			NewsExample newsExample= new NewsExample();
			List<News> newsList= newsMapper.selectByExample(newsExample);
			modelAndView.addObject("listNews",newsList);
		}
		return modelAndView;
	}
	
}

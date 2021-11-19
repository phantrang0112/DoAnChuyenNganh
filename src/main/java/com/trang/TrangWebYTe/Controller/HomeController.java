package com.trang.TrangWebYTe.Controller;

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
		return modelAndView;

	}

	@GetMapping(value = { "/register" }) // ten view luc chay tren local
	public ModelAndView register(Model model) {
		ModelAndView modelAndView = new ModelAndView("register"); // truyen vao ten view
		UserExample userExample = new UserExample();
		User user = new User();
		modelAndView.addObject("newUser", user);
		return modelAndView;

	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void themQuyen(String role) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);// muốn có nhiều quyền thì add thêm nhiều
																		// authority
		grantedAuthorities.add(authority);
		System.out.println(grantedAuthorities.get(0) + "hhs" + grantedAuthorities.size());
	}

	@RequestMapping("/register/saveUser")
	public ModelAndView SaveCustomer(Model model, @ModelAttribute User newUser) {
		ModelAndView modelAndView;
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andTenquyenEqualTo("USER");
		List<Role> role = RoleMapper.selectByExample(roleExample);
		String tenQuyen = role.get(0).getTenquyen();
		if(tenQuyen!= null) {
			themQuyen("USER");
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			newUser.setRoleid(role.get(0).getId());
			System.out.println(role.get(0).getId()+tenQuyen+ newUser.getRoleid());
			int a = userMapper.insert(newUser);
			if (a > 0) {
				modelAndView = new ModelAndView("home");
				NewsExample newsExample= new NewsExample();
				List<News> newsList= newsMapper.selectByExample(newsExample);
				modelAndView.addObject("listNews",newsList);
				return modelAndView;
			} else {
				modelAndView = new ModelAndView("register");
			}
		}
		else {
			modelAndView = new ModelAndView("register");
		}
		
		
		
		return modelAndView;
	}

	@GetMapping("/home")
	public ModelAndView home(Model model) {
		ModelAndView modelAndView = new ModelAndView("home");
		NewsExample newsExample= new NewsExample();
		List<News> newsList= newsMapper.selectByExample(newsExample);
		modelAndView.addObject("listNews",newsList);
		return modelAndView;
	}
	@GetMapping("/homedetail{newsid}")
	public ModelAndView homedetail(@PathVariable int newsid,ModelAndView model) {
		ModelAndView modelAndView = new ModelAndView("homedetail");
//		NewsExample newsExample= new NewsExample();
//		newsExample.createCriteria().andIdnewsEqualTo(id);
//		Integer.parseInt(newsid);
		News news=newsMapper.selectByPrimaryKey(newsid);
		if(news!=null) {
			modelAndView.addObject("News",news);
		}
		else {
			modelAndView = new ModelAndView("home");
			NewsExample newsExample= new NewsExample();
			List<News> newsList= newsMapper.selectByExample(newsExample);
			modelAndView.addObject("listNews",newsList);
		}
		return modelAndView;
	}
}

package com.trang.TrangWebYTe.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.UserMapper;
import com.trang.TrangWebYTe.model.User;
import com.trang.TrangWebYTe.model.UserExample;
@Controller
public class DSBenhNhanAdminController {
	@Autowired
	UserMapper userMapper;
	@GetMapping("/dsbenhnhanadmin")
	public ModelAndView GetAllDSBacSi() {
		ModelAndView modelAndView = new ModelAndView("admin/dsbenhnhan");
		UserExample userExample= new UserExample();
		List<User> listUsers= userMapper.selectByExample(userExample);
		modelAndView.addObject("listBenhNhan", listUsers);
		System.out.println(listUsers.size());
		return modelAndView;
	}
}

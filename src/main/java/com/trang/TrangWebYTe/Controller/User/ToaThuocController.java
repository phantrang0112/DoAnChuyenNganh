package com.trang.TrangWebYTe.Controller.User;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


import com.trang.TrangWebYTe.mapper.SoKhamBenhMapper;
import com.trang.TrangWebYTe.mapper.chitietSoKhamBenhMapper;
import com.trang.TrangWebYTe.model.SoKhamBenh;
import com.trang.TrangWebYTe.model.SoKhamBenhExample;

@Controller
public class ToaThuocController {
	@Autowired
	SoKhamBenhMapper soKhamBenhMapper;
	@Autowired
	chitietSoKhamBenhMapper chitietsoKhamBenhMapper;

	@GetMapping("/toathuoc")
	public ModelAndView toathuoc(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("user/toathuoc");
		HashMap<String, Object> parentHashMap = new HashMap<>();
		User user = (User) ((Authentication) principal).getPrincipal();
		parentHashMap.put("username", user.getUsername());
		List<Map<String, Object>> listSoKhamBenhList = soKhamBenhMapper.getAllSoKhamBenh(parentHashMap);
		modelAndView.addObject("listSoKhamBenh", listSoKhamBenhList);
		return modelAndView;

	}
	@GetMapping("/toathuoc/chitiet{ma}")
	public ModelAndView chiTietToaThuoc(@PathVariable int ma,ModelAndView model) {
		ModelAndView modelAndView= new ModelAndView("user/chitiettoathuoc");
		SoKhamBenh SKB= soKhamBenhMapper.selectByPrimaryKey(ma);
		List<Map<String, Object>> listBenhList=chitietsoKhamBenhMapper.getAllBenh(ma);
		List<Map<String, Object>> listToaThuoc= chitietsoKhamBenhMapper.getToaThuoc(ma);
		modelAndView.addObject("ListBenh", listBenhList);
		modelAndView.addObject("ListToaThuoc", listToaThuoc);
		modelAndView.addObject("SKB",SKB);
		
		return modelAndView;
	}
	
}

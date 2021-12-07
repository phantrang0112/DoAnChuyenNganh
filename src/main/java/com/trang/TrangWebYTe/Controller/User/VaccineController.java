package com.trang.TrangWebYTe.Controller.User;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.ChiTietSoTiemChungMapper;
import com.trang.TrangWebYTe.mapper.UserMapper;
import com.trang.TrangWebYTe.mapper.VaccineMapper;
import com.trang.TrangWebYTe.model.ChiTietSoTiemChung;
import com.trang.TrangWebYTe.model.Khoa;
import com.trang.TrangWebYTe.model.KhoaExample;

@Controller
public class VaccineController {
	@Autowired
	VaccineMapper vaccineMapper;
	@Autowired
	ChiTietSoTiemChungMapper chitietSoTiemChungMapper;
	@Autowired
	UserMapper userMapper;

	@GetMapping("/vaccine")
	public ModelAndView selectVaccine(Model model,Principal principal) {
		ModelAndView modelAndView = new ModelAndView("user/vaccine");
		Map< String, Object> parenMap= new HashMap<>();
		User user=  (User) ((Authentication) principal).getPrincipal();
		parenMap.put("username",user.getUsername());
		List<Map<String, Object>> listSTC= chitietSoTiemChungMapper.getAllchitietSoTiemChung(parenMap);
		modelAndView.addObject("listSTC", listSTC);
		return modelAndView;
	}
	@RequestMapping(value="/vaccine/selectVaccine",method = RequestMethod.POST)
	private ModelAndView selectVaccine(@RequestParam("tenVaccine") String tenVaccine,Principal principal){
		ModelAndView modelAndView= new ModelAndView("user/vaccine");
		List<Map<String, Object>> listSTC;
		Map< String, Object> parenMap= new HashMap<>();
		System.out.println("mbacsi"+tenVaccine);
		
		User user=  (User) ((Authentication) principal).getPrincipal();
		if(tenVaccine!=null)
		{	
			parenMap.put("username",user.getUsername());
			parenMap.put("tenvaccine", "%"+tenVaccine+"%");
			listSTC= chitietSoTiemChungMapper.getAllVaccineTheoten(parenMap);
		}
		else {
			parenMap.put("username",user.getUsername());
			listSTC= chitietSoTiemChungMapper.getAllchitietSoTiemChung(parenMap);

		}
		modelAndView.addObject("listSTC", listSTC);
		return modelAndView;
	}


}

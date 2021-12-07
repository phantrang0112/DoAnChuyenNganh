package com.trang.TrangWebYTe.Controller.BacSi;

import java.security.Principal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.LichKhamMapper;

@Controller
public class HomeBacSiController {
	@Autowired
	LichKhamMapper lichkhamMapper;

	@GetMapping("/homebacsi")
	public ModelAndView home(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("bacsi/homebacsi");
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		Map<String, Object> parent= new HashMap<>();
		parent.put("username", userDetails.getUsername());
		parent.put("trangthai", "Đã khám");
		List<Map<String,Object>> listLichKham= lichkhamMapper.selectLichKhamVoiTenBacSi(parent);
		modelAndView.addObject("listlichkham", listLichKham);
		modelAndView.addObject("bacsi", userDetails.getUsername());
		return modelAndView;
	}
	@RequestMapping(value = {"/search"},method= RequestMethod.POST)
	public ModelAndView seach(@RequestParam("ngayKham") String ngay,Principal principal) {
		ModelAndView modelAndView = new ModelAndView("bacsi/homebacsi");
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		Map<String, Object> parent= new HashMap<>();
		parent.put("username", userDetails.getUsername());
		parent.put("trangthai", "Đã khám");
		List<Map<String,Object>> listLichKham;
		try {
			Date ngayDate= Date.valueOf(ngay);
			System.out.println(ngay+"gjhgaj");
			if(ngay!=null) {
				parent.put("ngayhen", ngayDate);
				listLichKham= lichkhamMapper.selectLichKhamTheoNgay(parent);
			}
			else {
				listLichKham= lichkhamMapper.selectLichKhamVoiTenBacSi(parent);
			}
		} catch (Exception e) {
			listLichKham= lichkhamMapper.selectLichKhamVoiTenBacSi(parent);
		}
		
		
		modelAndView.addObject("listlichkham", listLichKham);
		modelAndView.addObject("bacsi", userDetails.getUsername());
		
		return modelAndView;
	}
}

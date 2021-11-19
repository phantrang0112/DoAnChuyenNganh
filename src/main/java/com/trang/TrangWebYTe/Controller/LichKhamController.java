package com.trang.TrangWebYTe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.LichKhamMapper;

@Controller
public class LichKhamController {
 @Autowired
 LichKhamMapper lichKhamMapper;
 @GetMapping("/lichkham")
 public ModelAndView lichkham() {
	 ModelAndView modelAndView= new ModelAndView("lichKham");
	 
	 return modelAndView;
 }
}

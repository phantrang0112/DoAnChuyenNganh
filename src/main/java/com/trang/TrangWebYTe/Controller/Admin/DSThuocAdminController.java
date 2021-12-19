package com.trang.TrangWebYTe.Controller.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.ThuocMapper;
import com.trang.TrangWebYTe.model.Thuoc;
import com.trang.TrangWebYTe.model.ThuocExample;

@Controller
public class DSThuocAdminController {
	@Autowired
	ThuocMapper thuocMapper;
 @GetMapping("/dsthuocadmin")
 public ModelAndView dsThuoc() {
	 ModelAndView modelAndView= new ModelAndView("admin/dsthuoc");
	 ThuocExample thuocExample= new ThuocExample();
	 List<Thuoc> listThuoc= thuocMapper.selectByExample(thuocExample);
	 modelAndView.addObject("listThuoc", listThuoc);
	 return modelAndView;
 }
}

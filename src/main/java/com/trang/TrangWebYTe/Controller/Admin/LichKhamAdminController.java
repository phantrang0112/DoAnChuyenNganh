package com.trang.TrangWebYTe.Controller.Admin;

import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.LichKhamMapper;
import com.trang.TrangWebYTe.model.BacSi;
import com.trang.TrangWebYTe.model.LichKham;
import com.trang.TrangWebYTe.model.LichKhamExample;
import com.trang.TrangWebYTe.model.TaiKhoan;


@Controller
public class LichKhamAdminController {
	@Autowired
	LichKhamMapper lichKhamMapper;
	@GetMapping("/dslichkham")
	public ModelAndView dslichkham() {
		ModelAndView modelAndView = new ModelAndView("admin/dslichkham");
		LichKhamExample lichKhamExample= new LichKhamExample();
		System.out.println(lichKhamExample.getOrderByClause());
		lichKhamExample.setOrderByClause(lichKhamExample.getOrderByClause()+","+"ngayhenkham DESC");
		List<LichKham> listLichKhams= lichKhamMapper.selectByExample(lichKhamExample);
		modelAndView.addObject("dslichkham", listLichKhams);
		LichKham lichKham= new LichKham();
		modelAndView.addObject("updatelichkham", lichKham);
		System.out.println(listLichKhams.get(0).getTrangthai());
		return modelAndView;
	}
	@RequestMapping(value = "/dslichkham/update{item}",method = RequestMethod.POST)
	public ModelAndView UpdateLichKham(@PathVariable String item, @RequestParam Map<String, Object> params) throws ParseException {
		ModelAndView modelAndView= new ModelAndView();
		String message="";
		Calendar cal = Calendar.getInstance();   
		java.util.Date ngayhientai=cal.getTime();
		System.out.println((String)params.get("ngayhenkham"));
		java.util.Date date =  new SimpleDateFormat("yyyy-MM-dd").parse((String)params.get("ngayhenkham"));
		LichKham updateLichKham = lichKhamMapper.selectByPrimaryKey(Integer.parseInt(item));
		if(updateLichKham.getNgayhenkham().compareTo(ngayhientai)>0 && date.compareTo(ngayhientai)>0) {
			
			updateLichKham.setNgayhenkham(date);
			int success= lichKhamMapper.updateByPrimaryKey(updateLichKham);
			if(success>0) {
				message="Update th??nh c??ng";
			}
			else {
				message="Update th???t b???i";
			}
			
		}
		else {
			message="L???ch kh??m ???? kh??m ho???c t???i ng??y kh??m, kh??ng ???????c ch???nh s???a!";
		}
		modelAndView= dslichkham();
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	@RequestMapping(value = "/dslichkham/delete{malichkham}")
	public ModelAndView XoaLichKham(@PathVariable String malichkham) {
		ModelAndView modelAndView= new ModelAndView();
		int idlichkham= Integer.parseInt(malichkham);
		Calendar cal = Calendar.getInstance();   
		java.util.Date ngayhientai=cal.getTime();
		String message="";
		try {
			LichKham updateLichKham = lichKhamMapper.selectByPrimaryKey(idlichkham);
			if(updateLichKham.getTrangthai().toLowerCase().equals("???? Kh??m".toLowerCase())|| updateLichKham.getNgayhenkham().compareTo(ngayhientai)<=0) {
				message="Kh??ng th??? x??a l???ch kh??m ";
			}else {
				int success= lichKhamMapper.deleteByPrimaryKey(idlichkham);
				if(success>0) {
					message="X??a th??nh c??ng";
				}
			}
		} catch (Exception e) {
			message="X??a th??nh c??ng";
		}
		
		
		
		modelAndView= dslichkham();
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	@RequestMapping(value="/selectdslichkham{trangthai}")
	public ModelAndView selectLichKham(@PathVariable String trangthai) {
		ModelAndView modelAndView = new ModelAndView("admin/dslichkham");
		LichKhamExample lichKhamExample= new LichKhamExample();
		List<LichKham> listLichKhams;
		try {
			
			lichKhamExample.createCriteria().andTrangthaiEqualTo(trangthai);
			lichKhamExample.setOrderByClause(lichKhamExample.getOrderByClause()+","+"ngayhenkham DESC");
			 listLichKhams= lichKhamMapper.selectByExample(lichKhamExample);
		} catch (Exception e) {
			lichKhamExample.setOrderByClause(lichKhamExample.getOrderByClause()+","+"ngayhenkham DESC");
			 listLichKhams= lichKhamMapper.selectByExample(lichKhamExample);
		}
	
		modelAndView.addObject("dslichkham", listLichKhams);
		LichKham lichKham= new LichKham();
		modelAndView.addObject("updatelichkham", lichKham);
		return modelAndView;
	}
}

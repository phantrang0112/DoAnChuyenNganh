package com.trang.TrangWebYTe.Controller.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.trang.TrangWebYTe.mapper.BacSiMapper;
import com.trang.TrangWebYTe.mapper.KhoaMapper;
import com.trang.TrangWebYTe.model.BacSiExample;
import com.trang.TrangWebYTe.model.Khoa;
import com.trang.TrangWebYTe.model.KhoaExample;
import com.trang.TrangWebYTe.model.BacSi;

@Controller
public class BacSiController {
	@Autowired
	BacSiMapper bacSiMapper;
	@Autowired
	KhoaMapper khoaMapper;

	@GetMapping("/bacsi")
	private ModelAndView BacSi() {
		ModelAndView modelAndView= new ModelAndView("user/bacSi");
		BacSiExample bacSiExample= new BacSiExample();
		KhoaExample khoaExample= new KhoaExample();
		List<Map<String, Object>> listBacSi= bacSiMapper.getAllBacSiTenKhoa();
		List<Khoa> listKhoa= khoaMapper.selectByExample(khoaExample);
		
		modelAndView.addObject("listBacSi",listBacSi);
		modelAndView.addObject("listKhoa",listKhoa );
		return modelAndView;
	}
	@RequestMapping(value="/selectKhoa{ma}")
	private ModelAndView selectKhoa(@PathVariable int ma){
		BacSiExample bacSiExample= new BacSiExample();
		KhoaExample khoaExample= new KhoaExample();
		List<Khoa> listKhoa;
		List<Map<String, Object>> listBacSi;
		System.out.println("ma "+ma);
		if(ma>0) {
			Map< String, Object> parenMap= new HashMap<>();
			parenMap.put("ma", ma);
			listBacSi= bacSiMapper.getAllBacSiTenKhoaTheoId(parenMap);
			 listKhoa= khoaMapper.selectByExample(khoaExample);
			
			
		}
		else {
			listBacSi= bacSiMapper.getAllBacSiTenKhoa();
			 listKhoa= khoaMapper.selectByExample(khoaExample);
		}
		
		ModelAndView modelAndView= new ModelAndView("user/bacSi");
		modelAndView.addObject("listKhoa",listKhoa );
		modelAndView.addObject("listBacSi",listBacSi);
		return modelAndView;
		
	}
	@RequestMapping(value="/bacsi/selectKhoa",method = RequestMethod.POST)
	private ModelAndView selectBacSi(@RequestParam("tenBacSi") String tenBacSi){
		ModelAndView modelAndView= new ModelAndView("user/bacSi");
		KhoaExample khoaExample= new KhoaExample();
		List<Map<String, Object>> listBacSi;
		List<Khoa> listKhoa;
		System.out.println("mbacsi"+tenBacSi);
		if(tenBacSi!=null)
		{
			Map< String, Object> parenMap= new HashMap<>();
			parenMap.put("fullName", "%"+tenBacSi+"%");
			listBacSi= bacSiMapper.getAllBacSiTenKhoaTheoten(parenMap);
			listKhoa= khoaMapper.selectByExample(khoaExample);
			for(Map<String, Object> value: listBacSi) {
				System.out.println("h,,,"+value.get("fullName"));
			}
		}
		else {
			listBacSi= bacSiMapper.getAllBacSiTenKhoa();
			 listKhoa= khoaMapper.selectByExample(khoaExample);
		}
		modelAndView.addObject("listBacSi",listBacSi);
		modelAndView.addObject("listKhoa",listKhoa );
		return modelAndView;
	}
	

}

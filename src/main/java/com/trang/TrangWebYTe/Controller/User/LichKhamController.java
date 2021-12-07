package com.trang.TrangWebYTe.Controller.User;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.BacSiMapper;
import com.trang.TrangWebYTe.mapper.KhoaMapper;
import com.trang.TrangWebYTe.mapper.LichKhamMapper;
import com.trang.TrangWebYTe.model.BacSiExample;
import com.trang.TrangWebYTe.model.Khoa;
import com.trang.TrangWebYTe.model.KhoaExample;
import com.trang.TrangWebYTe.model.LichKham;
import com.trang.TrangWebYTe.model.LichKhamExample;

@Controller
public class LichKhamController {
	@Autowired
	LichKhamMapper lichKhamMapper;
	@Autowired
	KhoaMapper khoaMapper;
	@Autowired
	BacSiMapper bacSiMapper;
	@Autowired
	HomeController homecontroller;

	@GetMapping("/lichkham")
	public ModelAndView lichkham(Principal principal) {
		ModelAndView modelAndView;
		KhoaExample khoaExample = new KhoaExample();
		List<Khoa> listKhoa;
		try {
			User user = (User) ((Authentication) principal).getPrincipal();

			System.out.println("hjak" + user.getUsername());
			if (user != null) {
				modelAndView = new ModelAndView("user/lichKham");
				Map<String, Object> parenMap = new HashMap<>();
				parenMap.put("username", user.getUsername());
				List<Map<String, Object>> listLichKham = lichKhamMapper.selectLichKham(parenMap);

				modelAndView.addObject("listLichKham", listLichKham);
				listKhoa = khoaMapper.selectByExample(khoaExample);
				modelAndView.addObject("listKhoa", listKhoa);
				LichKham lichkham = new LichKham();
				modelAndView.addObject("newLichKham", lichkham);
			}
			else {
				modelAndView = homecontroller.home();
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("login");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/selectKhoaLichKham{ma}")
	private ModelAndView selectKhoa(@PathVariable int ma) {
		BacSiExample bacSiExample = new BacSiExample();
		KhoaExample khoaExample = new KhoaExample();
		List<Khoa> listKhoa;
		List<Map<String, Object>> listBacSi;
		System.out.println("ma " + ma);
		if (ma > 0) {
			Map<String, Object> parenMap = new HashMap<>();
			parenMap.put("ma", ma);
			listBacSi = bacSiMapper.getAllBacSiTenKhoaTheoId(parenMap);
			listKhoa = khoaMapper.selectByExample(khoaExample);

		} else {
			listBacSi = bacSiMapper.getAllBacSiTenKhoa();
			listKhoa = khoaMapper.selectByExample(khoaExample);
		}

		ModelAndView modelAndView = new ModelAndView("user/bacSi");
		modelAndView.addObject("listKhoa", listKhoa);
		modelAndView.addObject("listBacSi", listBacSi);
		return modelAndView;

	}

	@RequestMapping(value = "/huydangki{idlichkham}", method = RequestMethod.POST)
	private ModelAndView huyDangKi(@RequestParam("huylich") String btnHuyLich, @PathVariable String idlichkham,
			Principal principal) {
		ModelAndView modelAndView;
		int idlichKham= Integer.parseInt(idlichkham);
		LichKhamExample lichKhamExample = new LichKhamExample();
		try {
			if (btnHuyLich.toLowerCase().equals("đã đăng kí".toLowerCase())) {
				lichKhamExample.createCriteria().andIdlichkhamEqualTo(idlichKham);
				List<LichKham> listhuylichKham = lichKhamMapper.selectByExample(lichKhamExample);
				LichKham lichKham = listhuylichKham.get(0);
				lichKham.setTrangthai("Đã hủy");
				lichKhamMapper.updateByPrimaryKey(lichKham);

				modelAndView = lichkham(principal);
			} else {
				modelAndView = lichkham(principal);
			}
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView = lichkham(principal);

		}
		return modelAndView;

	}
}

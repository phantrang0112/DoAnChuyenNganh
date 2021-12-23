package com.trang.TrangWebYTe.Controller.BacSi;

import java.security.Principal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import com.trang.TrangWebYTe.mapper.BacSiMapper;
import com.trang.TrangWebYTe.mapper.LichKhamMapper;
import com.trang.TrangWebYTe.model.BacSi;
import com.trang.TrangWebYTe.model.BacSiExample;
import com.trang.TrangWebYTe.model.LichKham;
import com.trang.TrangWebYTe.model.LichKhamExample;

@Controller
public class HomeBacSiController {
	@Autowired
	LichKhamMapper lichkhamMapper;
	@Autowired
	BacSiMapper bacsiMapper;
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
	@GetMapping("/thongke")
	public ModelAndView thongke(Principal principal) {
		ModelAndView modelAndView= new ModelAndView("bacsi/thongke");
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		BacSiExample bacSiExample= new BacSiExample();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		bacSiExample.createCriteria().andUsernameEqualTo(userDetails.getUsername());
		List<BacSi> bacSis= bacsiMapper.selectByExample(bacSiExample);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -6);
		int ngay = cal.get(cal.DAY_OF_WEEK);
		// lay ngày đầu tuần nè
		cal.add(Calendar.DAY_OF_MONTH, -ngay + 2);
		java.util.Date ngaydautuan = cal.getTime();
		
		Object[][] listngay=  new Object[7][2];
		String khoangngay ="Từ ngày "+format.format(cal.getTime());
		for(int i=0; i<7; i++) {
			java.util.Date ngayHienTai= cal.getTime();
			LichKhamExample lichKhamExample= new LichKhamExample();
			lichKhamExample.createCriteria().andMabacsiEqualTo(bacSis.get(0).getId()).andNgayhenkhamEqualTo(ngayHienTai).andTrangthaiEqualTo("Đã khám");
			
			for (int j = 0; j < 2; j++) {
				if(j==0) {
					
					
					SimpleDateFormat format1 = new SimpleDateFormat("MMMMMMMMM dd,yyyy HH:mm:ss");
					 String formatted = format1.format(ngayHienTai);
					 listngay[i][j]= formatted;
					System.out.println(listngay[i][j]+ "nè hư");
				}
				else {
					listngay[i][j]= lichkhamMapper.countByExample(lichKhamExample);

				}
			}
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		cal.add(Calendar.DAY_OF_MONTH, -1);
		 khoangngay +="  đến ngày  "+ format.format(cal.getTime());
		for (int i = 0; i < listngay.length; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(listngay[i][j]);
			}
		}
		modelAndView.addObject("mang", listngay);
		modelAndView.addObject("bacsi", userDetails.getUsername());
		modelAndView.addObject("khoangngay", khoangngay);
		return modelAndView;
	}
}

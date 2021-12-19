package com.trang.TrangWebYTe.Controller.BacSi;

import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.BacSiMapper;
import com.trang.TrangWebYTe.mapper.LichTrucMapper;
import com.trang.TrangWebYTe.model.BacSi;
import com.trang.TrangWebYTe.model.BacSiExample;
import com.trang.TrangWebYTe.model.DanhSachBenh;
import com.trang.TrangWebYTe.model.LichTruc;
import com.trang.TrangWebYTe.model.LichTrucExample;

@Controller
public class DangKiLichTrucController {
	@Autowired
	LichTrucMapper lichTrucMapper;
	@Autowired
	BacSiMapper bacSiMapper;
	public String timthu(int thu) {
		String tenThu="";
		switch (thu) {
		case 2:
			tenThu="Thứ 2";
			break;
		case 3:
			tenThu="Thứ 3";
			break;
		case 4:
			tenThu="Thứ 4";
			break;
		case 5:
			tenThu="Thứ 5";
			break;
		case 6:
			tenThu="Thứ 6";
			break;
		case 7:
			tenThu="Thứ 7";
			break;
		case 1:
			tenThu="Chủ Nhật";
			break;

		default:
			break;
		}
		return tenThu;
	}
	public ModelAndView showlichdadangki(java.util.Date datenow, Principal principal) {
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		Calendar cal = Calendar.getInstance();
		LichTrucExample lichTrucExample = new LichTrucExample();
		List<LichTruc> listlichtruc;
		List<Map<String, Object>> listdayList= new ArrayList<Map<String,Object>>();
		cal.setTime(datenow);
	
		int tuan= cal.get(cal.WEEK_OF_YEAR);
		int ngay=cal.get(cal.DAY_OF_WEEK);
		java.util.Date ngaydautuanDate;
		if((ngay==7)) {
			
			System.out.println(cal.get(cal.DAY_OF_WEEK)+"k"+tuan);
			lichTrucExample.createCriteria().andTuanEqualTo(String.valueOf(tuan+1));
			listlichtruc= lichTrucMapper.selectByExample(lichTrucExample);
			System.out.println(listlichtruc.get(0).getNgaytruc());
			cal.add(Calendar.DAY_OF_MONTH,7-ngay+2);
			 ngaydautuanDate= cal.getTime();
		}
		else {
			
			lichTrucExample.createCriteria().andTuanEqualTo(String.valueOf(tuan));
			listlichtruc= lichTrucMapper.selectByExample(lichTrucExample);
			cal.add(Calendar.DAY_OF_MONTH,-ngay+2);
			ngaydautuanDate= cal.getTime();
		}
		Boolean checkBoolean= true;
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		DanhSachBenh dsngaydangki= new DanhSachBenh();
		String[] listngay= new String[listlichtruc.size()];
		int dem=0;
		
		for (int i = 2; i < 8; i++) {
			
			
			checkBoolean=true;
			HashMap<String, Object> dayHashMap= new HashMap<String, Object>();
			for(LichTruc item:listlichtruc) {
				cal.setTime(item.getNgaytruc());
				if(cal.get(cal.DAY_OF_WEEK)==i) {
					 String formatted = format1.format(item.getNgaytruc());
					dayHashMap.put("ngay",formatted);
					dayHashMap.put("thu",timthu(cal.get(cal.DAY_OF_WEEK)) );
					dayHashMap.put("trangthai", "Đã đăng kí");
					listngay[dem]=formatted;
					dem++;
					checkBoolean=false;
				}
			}
			if(checkBoolean==true) {
				cal.setTime(ngaydautuanDate);
				if(i!=1) {
					cal.add(Calendar.DAY_OF_MONTH,i-2 );
				}
				
				 String formatted = format1.format(cal.getTime());
				dayHashMap.put("ngay",formatted);
				dayHashMap.put("thu",timthu(cal.get(cal.DAY_OF_WEEK)) );
				dayHashMap.put("trangthai", "Chưa đăng kí");
				
			}
			listdayList.add(dayHashMap);
		}
		dsngaydangki.setListngay(listngay);
		ModelAndView modelAndView= new ModelAndView("bacsi/dangkilichtruc");
		modelAndView.addObject("listngaytuan",listdayList );
		modelAndView.addObject("listngaydk",dsngaydangki);
		modelAndView.addObject("bacsi", userDetails.getUsername());
		return modelAndView;
	}
	public ModelAndView DangKiLichtruc(java.util.Date datenow,Principal principal) {
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		String message= "Thứ 7 rồi đăng kí lịch thôi nào!!!";
		List<Map<String, Object>> listdayList= new ArrayList<Map<String,Object>>();
		Calendar cal = Calendar.getInstance();
		int ngay= cal.get(cal.DAY_OF_WEEK);
		System.out.println(cal.get(cal.DAY_OF_WEEK)+"ngay"+cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH,7-ngay+1 );
		System.out.println("ngay"+cal.getTime());
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		for (int i = 1; i < 7; i++) {
			HashMap<String, Object> dayHashMap= new HashMap<String, Object>();
			cal.add(Calendar.DAY_OF_MONTH,1 );
			 String formatted = format1.format(cal.getTime());
			dayHashMap.put("ngay",formatted);
			dayHashMap.put("thu",timthu(cal.get(cal.DAY_OF_WEEK)) );
			dayHashMap.put("trangthai", "Chưa đăng kí");
			System.out.println(formatted +"hmm"+cal.get(cal.DAY_OF_WEEK)+timthu(cal.get(cal.DAY_OF_WEEK)));
			listdayList.add(dayHashMap);
		}
		for(Map<String,Object>iteMap: listdayList) {
			iteMap.get("thu");
			System.out.println(iteMap.get("thu")+"k"+ iteMap.get("ngay"));
		}
		String[] listngayString= new String[7];
		ModelAndView modelAndView= new ModelAndView("bacsi/dangkilichtruc");
		modelAndView.addObject("listngaytuan",listdayList );
		modelAndView.addObject("listngaydk",new DanhSachBenh());
		modelAndView.addObject("bacsi", userDetails.getUsername());
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	@GetMapping("/dangkilich")
	public ModelAndView DangKiLich(Principal principal) {
		ModelAndView modelAndView;
		List<Map<String, Object>> listdayList= new ArrayList<Map<String,Object>>();
		Boolean display=true;
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime()+"ngay hien tai");
//		cal.add(Calendar.DAY_OF_MONTH,1);
//		System.out.println(cal.getTime());
		java.util.Date datenow= cal.getTime();
		int ngay= cal.get(cal.DAY_OF_WEEK);
		int tuan= cal.get(cal.WEEK_OF_YEAR);
		List<LichTruc> listlichtruc;
		System.out.println(cal.get(cal.DAY_OF_WEEK)+"ngay"+cal.getTime());
		LichTrucExample lichTrucExample = new LichTrucExample();
		if(ngay==7) {
			System.out.println(tuan);
			int m= tuan+1;
			lichTrucExample.createCriteria().andTuanEqualTo(String.valueOf(m));
			listlichtruc= lichTrucMapper.selectByExample(lichTrucExample);
			if(listlichtruc.size()>0) {
				modelAndView= showlichdadangki(datenow, principal);
				display=false;
			}
			else {
				modelAndView= DangKiLichtruc(datenow, principal);
				display=true;
			}
		}
		else {
			modelAndView= showlichdadangki(datenow, principal);
			display=false;
		}
		modelAndView.addObject("display", display);
		return modelAndView;
	}
	@RequestMapping(value="/addlichkham", method = RequestMethod.POST)
	public ModelAndView addlichkham(@ModelAttribute("listngay") DanhSachBenh ds, Principal principal ) throws ParseException {
		ModelAndView modelAndView;
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		String message= "Đăng kí thành công";
		BacSiExample bacSiExample= new BacSiExample();
		bacSiExample.createCriteria().andUsernameEqualTo(userDetails.getUsername());
		List<BacSi> bacSis= bacSiMapper.selectByExample(bacSiExample);
		
		System.out.println(ds.getListngay()[0]);
		Calendar cal = Calendar.getInstance();
		java.util.Date date = new SimpleDateFormat("dd-MM-yyyy").parse(ds.getListngay()[0]);
		
		cal.setTime(date);
		int tuan= cal.get(cal.WEEK_OF_YEAR);
		for (int i = 0; i < ds.getListngay().length; i++) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);
			LocalDate dates = LocalDate.parse(ds.getListngay()[i], formatter);
			Date dateDate= Date.valueOf(dates);
			LichTruc lichTruc= new LichTruc();
			lichTruc.setMabacsi(bacSis.get(0).getId());
			lichTruc.setNgaytruc(dateDate);
			lichTruc.setTuan(String.valueOf(tuan));
			int a = lichTrucMapper.insert(lichTruc);
			if(a<=0) {
				message="Đăng kí thất bại";
			}
			
		}
		modelAndView=showlichdadangki(cal.getTime(),principal);
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}

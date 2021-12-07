package com.trang.TrangWebYTe.Controller.BacSi;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.model.DanhSachBenh;

@Controller
public class DangKiLichTrucController {
	public String timthu(int thu) {
		String tenThu="";
		switch (thu) {
		case 1:
			tenThu="Thứ 2";
			break;
		case 2:
			tenThu="Thứ 3";
			break;
		case 3:
			tenThu="Thứ 4";
			break;
		case 4:
			tenThu="Thứ 5";
			break;
		case 5:
			tenThu="Thứ 6";
			break;
		case 6:
			tenThu="Thứ 7";
			break;
		case 7:
			tenThu="Chủ Nhật";
			break;

		default:
			break;
		}
		return tenThu;
	}
	@GetMapping("/dangkilich")
	public ModelAndView DangKiLich() {
//		long millis=System.currentTimeMillis();   
//		java.sql.Date date=new java.sql.Date(millis);  
//		DayOfWeek b = date.toLocalDate().getDayOfWeek().of(1);
//		int a=date.toLocalDate().getDayOfWeek().of(1).getValue();
//		date.toLocalDate();
//		int c= LocalDate.of(date.getYear(), date.getMonth(), date.toLocalDate().getDayOfWeek().getValue());
	//	LocalDate localDate= LocalDate.now(); lấy ngày hiện tại
	//	int tuan= localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()); lấy tuần của nă,
//		 cal.setWeekDate(cal.getWeekYear(), tuan, ngay); trare về 1 ngày khi truyền vào năm, tuần, ngay
//	    System.out.println(cal.getTime());
		List<Map<String, Object>> listdayList= new ArrayList<Map<String,Object>>();
		
		Calendar cal = Calendar.getInstance();
//		java.util.Date dates = cal.getTime();// lấy ngày hiện tại
//		java.util.Date dateAfter = cal.getTime();/// gán ngày hiện tại
		int ngay= cal.get(cal.DAY_OF_WEEK);
		cal.add(Calendar.DAY_OF_MONTH,7-ngay );
		System.out.println("ngay"+cal.getTime());
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		for (int i = 1; i < 8; i++) {
			HashMap<String, Object> dayHashMap= new HashMap<String, Object>();
			cal.add(Calendar.DAY_OF_MONTH,1 );
			 String formatted = format1.format(cal.getTime());
			dayHashMap.put("ngay",formatted);
			dayHashMap.put("thu",timthu(cal.get(cal.DAY_OF_WEEK)) );
			System.out.println(formatted +"hmm"+cal.get(cal.DAY_OF_WEEK)+timthu(cal.get(cal.DAY_OF_WEEK)));
			listdayList.add(dayHashMap);
		}
		for(Map<String,Object>iteMap: listdayList) {
			iteMap.get("thu");
			System.out.println(iteMap.get("thu")+"k"+ iteMap.get("ngay"));
		}
//		 Date datess= new Date(dateAfter.getTime());//chuyển util sang sql
		String[] listngayString= new String[7];
		ModelAndView modelAndView= new ModelAndView("bacsi/dangkilichtruc");
		modelAndView.addObject("listngaytuan",listdayList );
		modelAndView.addObject("listngaydk",new DanhSachBenh());
		return modelAndView;
	}
	@RequestMapping(value="/addlichkham", method = RequestMethod.POST)
	public ModelAndView addlichkham(@ModelAttribute("listngay") DanhSachBenh ds ) throws ParseException {
		ModelAndView modelAndView= new ModelAndView("bacsi/dangkilichtruc");
		System.out.println(ds.getListngay()[0]);
		Calendar cal = Calendar.getInstance();
		java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ds.getListngay()[0]);
		cal.setTime(date);
		int tuan= cal.get(cal.WEEK_OF_YEAR);
		for (int i = 0; i < ds.getListngay().length; i++) {
			
			
		}
		
		return modelAndView;
	}
}

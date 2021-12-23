package com.trang.TrangWebYTe.Controller.User;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.trang.TrangWebYTe.mapper.LichKhamMapper;
import com.trang.TrangWebYTe.mapper.LichTrucMapper;
import com.trang.TrangWebYTe.mapper.UserMapper;
import com.trang.TrangWebYTe.model.BacSi;
import com.trang.TrangWebYTe.model.BacSiExample;
import com.trang.TrangWebYTe.model.Khoa;
import com.trang.TrangWebYTe.model.KhoaExample;
import com.trang.TrangWebYTe.model.LichKham;
import com.trang.TrangWebYTe.model.LichKhamExample;
import com.trang.TrangWebYTe.model.LichTruc;
import com.trang.TrangWebYTe.model.LichTrucExample;
import com.trang.TrangWebYTe.model.UserExample;

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
	@Autowired
	LichTrucMapper lichTrucMapper;
	@Autowired
	UserMapper userMapper;

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
				System.out.println(listKhoa.size() + "listkhoa");
				LichKham lichkham = new LichKham();
				modelAndView.addObject("newLichKham", lichkham);
			} else {
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
		List<BacSi> listBacSi;
		System.out.println("ma " + ma);
		if (ma > 0) {
			bacSiExample.createCriteria().andMakhoaEqualTo(ma);
			listBacSi = bacSiMapper.selectByExample(bacSiExample);
			listKhoa = khoaMapper.selectByExample(khoaExample);

		} else {
			listBacSi = bacSiMapper.selectByExample(bacSiExample);
			listKhoa = khoaMapper.selectByExample(khoaExample);
		}

		ModelAndView modelAndView = DangKiLich();
		modelAndView.addObject("listBacSi", listBacSi);
		System.out.println(listBacSi.size());
		return modelAndView;

	}

	@RequestMapping(value = "/huydangki{idlichkham}", method = RequestMethod.POST)
	private ModelAndView huyDangKi(@RequestParam("huylich") String btnHuyLich, @PathVariable String idlichkham,
			Principal principal) {
		ModelAndView modelAndView;
		int idlichKham = Integer.parseInt(idlichkham);
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

	@RequestMapping("/dangkilichkham")
	public ModelAndView DangKiLich() {
		ModelAndView modelAndView = new ModelAndView("user/dangkilichkham");
		KhoaExample khoaExample = new KhoaExample();
		List<Khoa> listKhoa;
		listKhoa = khoaMapper.selectByExample(khoaExample);
		modelAndView.addObject("listKhoa", listKhoa);
		System.out.println(listKhoa.size() + "listkhoa");
		Calendar cal= Calendar.getInstance();
		Date dateString = cal.getTime();
		modelAndView.addObject("ngay", dateString);
		return modelAndView;
	}

	@RequestMapping( value = "/loctheongaykham")
	public ModelAndView locNgayKham(@RequestParam("ngaykham") String ngayKham) throws ParseException {
		System.out.println(ngayKham+"ngày khám má");
		java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayKham);
		
		ModelAndView modelAndView = new ModelAndView();
		String mesageString="";
	Calendar calendar= Calendar.getInstance();
	Date ngayhientai=calendar.getTime();
	if(ngayhientai.compareTo(date)<0) {
		
		LichTrucExample lichtrucExample = new LichTrucExample();
		lichtrucExample.createCriteria().andNgaytrucEqualTo(date);
		List<LichTruc> listLichTruc = lichTrucMapper.selectByExample(lichtrucExample);
		System.out.println(listLichTruc.size());
		List<BacSi> listBacSi = new ArrayList<BacSi>();
		for (LichTruc item : listLichTruc) {

			listBacSi.add(bacSiMapper.selectByPrimaryKey(item.getMabacsi()));
			modelAndView = DangKiLich();
			modelAndView.addObject("listBacSi", listBacSi);
			modelAndView.addObject("ngayhenkham", ngayKham);
		}
	}
	else {
		modelAndView = DangKiLich();
		mesageString=" Ngày đăng kí phải lớn hơn ngày hiện tại";
	}
		modelAndView.addObject("message",mesageString);
		return modelAndView;
	}
	@RequestMapping(value = "/themlichkham", method = RequestMethod.POST)
	public ModelAndView themLichKham(@RequestParam("ngayhenkham") String ngayhenkham, @RequestParam("mabacsi") String maBacSi,Principal principal) throws ParseException {
		ModelAndView modelAndView= new ModelAndView();
		String mesageString="";
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayhenkham);
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(userDetails.getUsername());
		List<com.trang.TrangWebYTe.model.User> listuUser= userMapper.selectByExample(userExample);
		LichKham lichKham= new LichKham();
		lichKham.setMabacsi(Integer.parseInt(maBacSi));
		lichKham.setNgayhenkham(date);
		lichKham.setTrangthai("Đã đăng kí");
		lichKham.setUserid(listuUser.get(0).getId());
		int success= lichKhamMapper.insert(lichKham);
		if(success>0) {
			mesageString="Đăng kí thành công";
		}
		else {
			mesageString="Đăng kí thất bại";
		}
		
		modelAndView = DangKiLich();
		modelAndView.addObject("message",mesageString);
		return modelAndView;
	}
	
}

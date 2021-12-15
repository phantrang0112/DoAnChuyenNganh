package com.trang.TrangWebYTe.Controller.Admin;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.BacSiMapper;
import com.trang.TrangWebYTe.mapper.LichKhamMapper;
import com.trang.TrangWebYTe.mapper.UserMapper;
import com.trang.TrangWebYTe.model.BacSiExample;
import com.trang.TrangWebYTe.model.LichKhamExample;
import com.trang.TrangWebYTe.model.UserExample;
@Controller
public class homeadmincontroller {
	@Autowired
	LichKhamMapper lichKhamMapper;
	@Autowired
	BacSiMapper bacSiMapper;
	@Autowired
	UserMapper userMapper;

	public int layTongLichKhamTrongTuan(Date date) {
		int sum=0;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int ngay = cal.get(cal.DAY_OF_WEEK);
		// lay ngày đầu tuần nè
		cal.add(Calendar.DAY_OF_MONTH, -ngay + 2);
		java.util.Date ngaydautuan = cal.getTime();
		// lay ngày cuối tuần nè
		cal.add(Calendar.DAY_OF_MONTH, 6);
		Date ngaycuoituan = cal.getTime();;
		LichKhamExample lichKhamExample = new LichKhamExample();
		lichKhamExample.createCriteria().andNgayhenkhamBetween(ngaydautuan, ngaycuoituan);
		sum = (int) lichKhamMapper.countByExample(lichKhamExample);
		return sum;
	}
	// Lấy ngày đầu tháng nè
	public int layTongLichKhamTrongThang(Date date) {
		int sum;
		Calendar cal = Calendar.getInstance();
		LichKhamExample lichKhamExample = new LichKhamExample();
		cal.setTime(date);
		int ngayht = cal.get(Calendar.DAY_OF_MONTH);
		int ngayct = cal.getMaximum(Calendar.DATE);
		cal.add(Calendar.DAY_OF_MONTH, -ngayht + 1);
		Date ngayDauThang = cal.getTime();
		//Lấy ngày cuối tháng nè
		cal.add(Calendar.DAY_OF_MONTH, ngayct - 1);
		Date ngayCuoiThang = cal.getTime();
		lichKhamExample.createCriteria().andNgayhenkhamBetween(ngayDauThang, ngayCuoiThang);
		sum = (int) lichKhamMapper.countByExample(lichKhamExample);
		return sum;
		
	}
	public int layTongBacSi() {
		BacSiExample bacSiExample= new BacSiExample();
		int sum= (int) bacSiMapper.countByExample(bacSiExample);
		return sum;
	}
	public int layTongBenhNhan() {
		UserExample userExample= new UserExample();
		
		int sum= (int) userMapper.countByExample(userExample);
		return sum;
	}
	@GetMapping("/homeadmin")
	public ModelAndView homeAdmin() {
		ModelAndView modelAndView = new ModelAndView("admin/homeadmin");
		Calendar cal = Calendar.getInstance();
		Date ngayHienTai = cal.getTime();
		int tongLichKhamTrongTuan;
		int tongLichKhamTrongThang;
		int tongBacSi= layTongBacSi();
		int tongBenhNhan= layTongBenhNhan();
		Object mang[][]= new Object[7][3];
	
		int ngay = cal.get(cal.DAY_OF_WEEK);
		// lay ngày đầu tuần nè
		cal.add(Calendar.DAY_OF_MONTH, -ngay + 2);
		for (int i = 0; i < mang.length; i++) {
			LichKhamExample lichKhamExample = new LichKhamExample();
			for (int j = 0; j < mang[0].length; j++) {
				if(i==0) {
					if(j==0) {
						mang[0][j]="Tuần";
					}
					else if(j==1) {
						mang[0][j]="Đã Đăng Ký";
					}
					else {
						mang[0][j]="Hủy";
					}
					
				}
				else {
					cal.add(Calendar.DAY_OF_MONTH, 1);
					if(j==0) {
						
						mang[i][j]="Ngày thứ "+(i+1);
					}
					else if(j==1) {
						lichKhamExample.createCriteria().andNgayhenkhamEqualTo(cal.getTime());
						lichKhamExample.createCriteria(). andTrangthaiNotEqualTo("Đã hủy");
						
						int songay= (int) lichKhamMapper.countByExample(lichKhamExample);
						if(songay==0) {
							mang[i][j]=0;
						}
						else {
							mang[i][j]=songay;
						}
						
					}
					else {
						lichKhamExample.createCriteria().andNgayhenkhamEqualTo(cal.getTime());
						lichKhamExample.createCriteria().andTrangthaiEqualTo("Đã hủy");
						int songayhuy= (int) lichKhamMapper.countByExample(lichKhamExample);
						if(songayhuy==0) {
							mang[i][j]=0;
						}
						else {
							mang[i][j]=songayhuy;
						}
						
					}
					
				}
			}
		}
		System.out.println(mang.toString());
		
		tongLichKhamTrongThang= layTongLichKhamTrongThang(ngayHienTai);
		tongLichKhamTrongTuan= layTongLichKhamTrongTuan(ngayHienTai);
		
		System.out.println(tongLichKhamTrongTuan + "tongnef" + tongLichKhamTrongThang);
		modelAndView.addObject("sumtuan",tongLichKhamTrongTuan);
		modelAndView.addObject("sumthang", tongLichKhamTrongThang);
		modelAndView.addObject("sumbacsi", tongBacSi);
		modelAndView.addObject("sumbenhnhan", tongBenhNhan);
		modelAndView.addObject("mang", mang);
		return modelAndView;
	}
}

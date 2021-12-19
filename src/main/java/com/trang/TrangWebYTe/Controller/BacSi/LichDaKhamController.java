package com.trang.TrangWebYTe.Controller.BacSi;

import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.LichKhamMapper;
import com.trang.TrangWebYTe.mapper.SoKhamBenhMapper;
import com.trang.TrangWebYTe.model.LichKham;
import com.trang.TrangWebYTe.model.LichKhamExample;
import com.trang.TrangWebYTe.model.SoKhamBenh;
import com.trang.TrangWebYTe.model.SoKhamBenhExample;

@Controller
public class LichDaKhamController {
	 @Autowired
	 LichKhamMapper lichkhamMapper;
	 @Autowired
	 SoKhamBenhMapper soKhamBenhMapper;
	 
	 
	public String chuyenTrangThaiThanhChoXacNhan(String trangthai,Date ngayhenkham) {
		long millis=System.currentTimeMillis(); 
		java.sql.Date date=new java.sql.Date(millis);   
		LichKhamExample lichKhamExample= new LichKhamExample();
		lichKhamExample.createCriteria().andTrangthaiEqualTo(trangthai).andNgayhenkhamEqualTo(ngayhenkham);
		List<LichKham> listlichKhams= lichkhamMapper.selectByExample(lichKhamExample);
		for(LichKham item: listlichKhams) {
			if(item.getTrangthai().toLowerCase().equals("đã đăng kí".toLowerCase())) {
				
				if(item.getNgayhenkham().compareTo(date)<=0) {
					item.setTrangthai("Chờ xác nhận");
					trangthai="Chờ xác nhận";
					int a= lichkhamMapper.updateByPrimaryKey(item);
					if(a>0) {
						System.out.println("cập nhật thành công");
					}
					else {
						System.out.println("fail nha má");
					}
				}
			}
		}
		
		
		return trangthai;
	}
	@GetMapping("/lichdakham")
	public ModelAndView lichdakham(Principal principal) throws ParseException {
		ModelAndView modelAndView= new ModelAndView("bacsi/lichdakham");
		long millis=System.currentTimeMillis();   
		java.sql.Date date=new java.sql.Date(millis);   
		System.out.println(date);
		Boolean display=true;
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		Map<String, Object> parent= new HashMap<>();
		parent.put("username", userDetails.getUsername());
		parent.put("trangthai", "Đã hủy");
		List<Map<String,Object>> listLichKham= lichkhamMapper.selectLichKhamVoiTenBacSi(parent);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 List<Map<String,Object>> listlichdakham= new ArrayList<Map<String,Object>>();
		for(Map<String, Object>item: listLichKham) {
			Date ngayhenDate= (Date) item.get("ngayhenkham");
			String trangthaiString= (String) item.get("trangthai");
			if(date.compareTo(ngayhenDate)>=0 ) {
			String  trangthai=	chuyenTrangThaiThanhChoXacNhan(trangthaiString,ngayhenDate);
			if(trangthai.toLowerCase().contains("Chờ xác nhận".toLowerCase())) {
				display=false;
			}else {
				display= true;
			}
				item.put("display", display);
				item.remove("trangthai");
				item.put("trangthai",trangthai );
				 listlichdakham.add(item);
			}
		}
		modelAndView.addObject("listlichdakham", listlichdakham);
		
		modelAndView.addObject("bacsi", userDetails.getUsername());
		return modelAndView;
	}
	@RequestMapping(value = {"/lichdakhamsearch"},method= RequestMethod.POST)
	public ModelAndView seach(@RequestParam("ngayKham") String ngay,Principal principal) {
		ModelAndView modelAndView = new ModelAndView("bacsi/lichdakham");
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		Map<String, Object> parent= new HashMap<>();
		Boolean display=true;
		Boolean checkBoolean=true;
		
		parent.put("username", userDetails.getUsername());
		parent.put("trangthai", "Đã hủy");
		
		List<Map<String,Object>> listLichKham= lichkhamMapper.selectLichKhamVoiTenBacSi(parent);
		 List<Map<String,Object>> listlichdakham= new ArrayList<Map<String,Object>>();
		 try {
			
			 Date ngayDate= Date.valueOf(ngay);
				System.out.println(ngay+"gjhgaj");
			for(Map<String, Object>item: listLichKham) {
				Date ngayhenDate= (Date) item.get("ngayhenkham");
				String trangthaiString= (String) item.get("trangthai");
				
				if(ngayhenDate.compareTo(ngayDate)==0) {
					System.out.println("voday");
					listlichdakham.add(item);
					checkBoolean=false;

					if(trangthaiString.toLowerCase().contains("Chờ xác nhận".toLowerCase())) {
						display=false;
					}else {
						display= true;
			
					}
				}
				else {
					checkBoolean=false;
				}
				
			}
			if(checkBoolean==true) {
				
				listlichdakham=List.copyOf(listLichKham);
			}
		} catch (Exception e) {
			for(Map<String, Object>item: listLichKham) {
				String trangthaiString= (String) item.get("trangthai");
				if(trangthaiString.toLowerCase().contains("Chờ xác nhận".toLowerCase())) {
					display=false;
				}else {
					display= true;
		
				}
			}
			listlichdakham=List.copyOf(listLichKham);
		}
		
		modelAndView.addObject("listlichdakham", listlichdakham);
		
		modelAndView.addObject("bacsi", userDetails.getUsername());
		return modelAndView;
	}
	public boolean kiemtradieukienSKB(SoKhamBenh skb) {
		SoKhamBenhExample soKhamBenhExampleExample= new SoKhamBenhExample();
		soKhamBenhExampleExample.createCriteria().andMalichkhamEqualTo(skb.getMalichkham());
		List<SoKhamBenh> listSkb= soKhamBenhMapper.selectByExample(soKhamBenhExampleExample);
		if(listSkb.size()>0) {
			return false;
		}
		return true;
	}
	@RequestMapping(value="/xacnhandakham{idlichkham}",method = RequestMethod.POST)
	public ModelAndView xacnhandakham(@RequestParam("trangthai") String trangthai, @PathVariable int idlichkham,Principal principal) throws ParseException {
		long millis=System.currentTimeMillis();   
		java.sql.Date date=new java.sql.Date(millis); 
		try {
			LichKhamExample lichKhamExample= new LichKhamExample();
			lichKhamExample.createCriteria().andIdlichkhamEqualTo(idlichkham);
			List<LichKham> listlichkham= lichkhamMapper.selectByExample(lichKhamExample);
			System.out.println("hmmm"+listlichkham.size());
			for(LichKham item : listlichkham) {
				if(item.getNgayhenkham().compareTo(date)<=0 ) {
					item.setTrangthai("Đã khám");
					SoKhamBenh soKhamBenh= new SoKhamBenh();
					soKhamBenh.setMalichkham(item.getIdlichkham());
					soKhamBenh.setNgaykham(date);
					if(kiemtradieukienSKB(soKhamBenh)) {
						soKhamBenhMapper.insert(soKhamBenh);
					}
					lichkhamMapper.updateByPrimaryKey(item);
					
				}
			}
		} catch (Exception e) {
			ModelAndView modelAndView= lichdakham(principal);
		}
		
		ModelAndView modelAndView= lichdakham(principal);
		return modelAndView;
	}
	
}

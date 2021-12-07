package com.trang.TrangWebYTe.Controller.BacSi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.View;

import java.io.LineNumberInputStream;
import java.lang.*;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.trang.TrangWebYTe.mapper.BenhMapper;
import com.trang.TrangWebYTe.mapper.ChiTietToaThuocMapper;
import com.trang.TrangWebYTe.mapper.LichKhamMapper;
import com.trang.TrangWebYTe.mapper.SoKhamBenhMapper;
import com.trang.TrangWebYTe.mapper.ThuocMapper;
import com.trang.TrangWebYTe.mapper.ToaThuocMapper;
import com.trang.TrangWebYTe.mapper.chitietSoKhamBenhMapper;
import com.trang.TrangWebYTe.model.Benh;
import com.trang.TrangWebYTe.model.BenhExample;
import com.trang.TrangWebYTe.model.ChiTietSoKhamBenhTam;
import com.trang.TrangWebYTe.model.ChiTietToaThuoc;
import com.trang.TrangWebYTe.model.ChiTietToaThuocExample;
import com.trang.TrangWebYTe.model.DanhSachBenh;
import com.trang.TrangWebYTe.model.SoKhamBenh;
import com.trang.TrangWebYTe.model.SoKhamBenhExample;
import com.trang.TrangWebYTe.model.Thuoc;
import com.trang.TrangWebYTe.model.ThuocExample;
import com.trang.TrangWebYTe.model.ToaThuoc;
import com.trang.TrangWebYTe.model.User;
import com.trang.TrangWebYTe.model.chitietSoKhamBenhExample;
import com.trang.TrangWebYTe.model.chitietSoKhamBenhKey;

@Controller
public class SoKhamBenhController {
	@Autowired
	SoKhamBenhMapper soKhamBenhMapper;
	@Autowired
	chitietSoKhamBenhMapper chitietsoKhamBenhMapper;
	@Autowired
	LichKhamMapper lichkhamMapper;
	@Autowired
	BenhMapper benhMapper;
	@Autowired
	ThuocMapper thuocMapper;
	@Autowired
	ToaThuocMapper toaThuocMapper;
	@Autowired
	ChiTietToaThuocMapper chiTietToaThuocMapper;
	
	public ModelAndView chiTietSoKhamBenhMoi( int idlichkham,Principal principal) {
		ModelAndView modelAndView = new ModelAndView("bacsi/chitietsokhambenh");
		BenhExample benhExample = new BenhExample();
		ThuocExample thuocExample = new ThuocExample();
		ChiTietSoKhamBenhTam CTSKBT = new ChiTietSoKhamBenhTam();
		List<Benh> listBenh = benhMapper.selectByExample(benhExample);
		List<Thuoc> listThuoc = thuocMapper.selectByExample(thuocExample);
		HashMap<String, Object> SKB = lichkhamMapper.selectlichKhamtheoId(idlichkham);
		SoKhamBenhExample soKhamBenhExample= new SoKhamBenhExample();
		soKhamBenhExample.createCriteria().andMalichkhamEqualTo(idlichkham);
		List<SoKhamBenh> soKhamBenh= soKhamBenhMapper.selectByExample(soKhamBenhExample);
		SKB.put("MaSKB",soKhamBenh.get(0).getMasokhambenh() );
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		modelAndView.addObject("SKB", SKB);
		modelAndView.addObject("listThuoc", listThuoc);
		modelAndView.addObject("listBenh", listBenh);
		modelAndView.addObject("CTSKBT", CTSKBT);
		modelAndView.addObject("Benhs", new DanhSachBenh());
		modelAndView.addObject("bacsi", userDetails.getUsername());
		return modelAndView;
	}
	public ModelAndView ChiTietSoKhamBenhCoId(int idSKB,Principal principal) {
		ModelAndView modelAndView = new ModelAndView("bacsi/chitietsokhambenh");
		UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
		SoKhamBenh SKBenh = soKhamBenhMapper.selectByPrimaryKey(idSKB);
		chitietSoKhamBenhExample chitietSoKhamBenhExample= new chitietSoKhamBenhExample();
		chitietSoKhamBenhExample.createCriteria().andMasokhambenhEqualTo(idSKB);
		List<chitietSoKhamBenhKey> CTSKB= chitietsoKhamBenhMapper.selectByExample(chitietSoKhamBenhExample);
		String[] listBenh= new String[CTSKB.size()];
		
		ChiTietToaThuocExample chiTietToaThuocExample= new ChiTietToaThuocExample();
		chiTietToaThuocExample.createCriteria().andMatoathuocEqualTo(SKBenh.getMatoathuoc());
		 List<ChiTietToaThuoc> listCTTTT=chiTietToaThuocMapper.selectByExample(chiTietToaThuocExample) ;
		 List<ChiTietSoKhamBenhTam> listCTTTTam= new ArrayList<ChiTietSoKhamBenhTam>();
		int i=0;
		
		for(chitietSoKhamBenhKey item: CTSKB) {
			Benh benh = benhMapper.selectByPrimaryKey(item.getMabenh());
			listBenh[i]=benh.getTenbenh();
			i++;
		}
		for(ChiTietToaThuoc item: listCTTTT) {
			ChiTietSoKhamBenhTam CTSKBT = new ChiTietSoKhamBenhTam();
			Thuoc thuoc= thuocMapper.selectByPrimaryKey(item.getMathuoc());
			System.out.println(thuoc.getTenthuoc());
			CTSKBT.setTenthuoc(thuoc.getTenthuoc());
			CTSKBT.setCachdung(item.getCachdung());
			CTSKBT.setSoluongdung(item.getSoluongdung());
			listCTTTTam.add(CTSKBT);
		}
		
		HashMap<String, Object> SKB = lichkhamMapper.selectlichKhamtheoId(SKBenh.getMalichkham());
		SKB.put("MaSKB", idSKB);
		modelAndView.addObject("SKB", SKB);
		modelAndView.addObject("listCTTTTam", listCTTTTam);
		modelAndView.addObject("listBenhs", listBenh);
		modelAndView.addObject("bacsi", userDetails.getUsername());
		return modelAndView;

	}
	@RequestMapping(value = "/ChiTietSoKhamBenh{idlichkham}")
	public ModelAndView chiTietSoKhamBenh(@PathVariable int idlichkham, Principal principal) {
		SoKhamBenhExample soKhamBenhExample = new SoKhamBenhExample();
		ModelAndView modelAndView;
		Boolean display = true;
		
		soKhamBenhExample.createCriteria().andMalichkhamEqualTo(idlichkham);
		List<SoKhamBenh> listSKB = soKhamBenhMapper.selectByExample(soKhamBenhExample);
		System.out.println(idlichkham+"idlichkham"+ listSKB.get(0).getMatoathuoc());
		if(listSKB.get(0).getMatoathuoc()==null) {
			modelAndView= chiTietSoKhamBenhMoi(idlichkham,principal);
			display=false;
		}
		else {
			display=true;
			modelAndView= ChiTietSoKhamBenhCoId(listSKB.get(0).getMasokhambenh(),principal);
		}
		modelAndView.addObject("display", display);
		modelAndView.addObject("displays", display);
		return modelAndView;

	}
	@RequestMapping(value="/save{id}", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("Benhs") DanhSachBenh insertbenh,@PathVariable String id) {
		int idSKB=Integer.parseInt(id);
		ModelAndView modelAndView=new ModelAndView("bacsi/chitietsokhambenh");
		String messageString="Thêm bệnh thành công";
		Boolean checkBoolean=true;
		System.out.println(insertbenh.getBenhs()[0]+"hihi");
		for (int i = 0; i < insertbenh.getBenhs().length; i++) {
			chitietSoKhamBenhKey chitietSoKhamBenhKey= new chitietSoKhamBenhKey();
			chitietSoKhamBenhKey.setMasokhambenh(idSKB);
			int ma= Integer.parseInt(insertbenh.getBenhs()[i]);
			chitietSoKhamBenhKey.setMabenh(ma);
			int succes= chitietsoKhamBenhMapper.insert(chitietSoKhamBenhKey);
			if(succes<=0) {
				checkBoolean=false;
				messageString="thêm bệnh thất bại";
			}
		}
		System.out.println(checkBoolean);
		SoKhamBenh SKB= soKhamBenhMapper.selectByPrimaryKey(idSKB);
		modelAndView=chiTietSoKhamBenhTam(SKB.getMalichkham());
		if(checkBoolean==true) {
			String[] listBenh= new String[insertbenh.getBenhs().length];
			int i=0;
			for(String item: insertbenh.getBenhs()) {
				int items= Integer.parseInt(item);
				Benh benh = benhMapper.selectByPrimaryKey(items);
				listBenh[i]=benh.getTenbenh();
				i++;
			}
			modelAndView.addObject("listBenhs", listBenh);
		}
		modelAndView.addObject("message", messageString);
		modelAndView.addObject("displays", false);
		modelAndView.addObject("display", checkBoolean);
		
		return modelAndView;
		 
    }
	public ModelAndView chiTietSoKhamBenhTam( int idlichkham) {
		
		ModelAndView modelAndView = new ModelAndView("bacsi/chitietsokhambenh");
		SoKhamBenhExample soKhamBenhExample = new SoKhamBenhExample();
		BenhExample benhExample = new BenhExample();
		ThuocExample thuocExample = new ThuocExample();
		Boolean Display ;
		soKhamBenhExample.createCriteria().andMalichkhamEqualTo(idlichkham);
		List<SoKhamBenh> listSKB = soKhamBenhMapper.selectByExample(soKhamBenhExample);
		int maskb = listSKB.get(0).getMasokhambenh();
		List<Benh> listBenh = benhMapper.selectByExample(benhExample);
		List<Thuoc> listThuoc = thuocMapper.selectByExample(thuocExample);
		ChiTietSoKhamBenhTam	CTSKBT = new ChiTietSoKhamBenhTam();
			Display = false;
			modelAndView.addObject("CTSKBT", CTSKBT);
			modelAndView.addObject("listBenh", listBenh);
			modelAndView.addObject("listThuoc", listThuoc);
			HashMap<String, Object> SKB = lichkhamMapper.selectlichKhamtheoId(idlichkham);
			SKB.put("MaSKB", maskb);
			modelAndView.addObject("SKB", SKB);
			return modelAndView;
	}
	
	
	
	public List<ChiTietSoKhamBenhTam> listCTTTTam= new ArrayList<ChiTietSoKhamBenhTam>();
	@RequestMapping(value = "/deleteItem{index}/{idSKBs}")
	public ModelAndView XoaToaThuocTam( @PathVariable String idSKBs , @PathVariable int index ) {
		System.out.println(index+"hmm"+idSKBs);
		int idSKB= Integer.parseInt(idSKBs);
		SoKhamBenh skBenh = soKhamBenhMapper.selectByPrimaryKey(idSKB);
		Boolean Display = true;
		String messageString=" Đã xóa ";
		Boolean checkBoolean=true;
		index=index-1;
		messageString= messageString+listCTTTTam.get(index).getTenthuoc();
		
		listCTTTTam.remove(index);
		
		ModelAndView modelAndView = chiTietSoKhamBenhTam(skBenh.getMalichkham());
		modelAndView.addObject("listCTTTTam", listCTTTTam);
		modelAndView.addObject("message", messageString);
		modelAndView.addObject("display", Display);
		return modelAndView;
		
	}
	@RequestMapping(value = "/saveToaThuoc{idSKB}", method = RequestMethod.POST)
	public ModelAndView SaverToaThuocTam(@ModelAttribute("CTSKBT") ChiTietSoKhamBenhTam CTSKBT, @PathVariable int idSKB) {
		SoKhamBenh skBenh = soKhamBenhMapper.selectByPrimaryKey(idSKB);
		Boolean Display = true;
		String messageString="";
		Boolean checkBoolean=true;
		for(ChiTietSoKhamBenhTam item:listCTTTTam) {
			if(CTSKBT.getTenthuoc().toLowerCase().equals(item.getTenthuoc().toLowerCase())) {
				messageString="Thuốc đã được thêm, không được thêm lại!";
				checkBoolean=false;
			}
			else if(CTSKBT.getTenthuoc()==null) {
				
				messageString="Chưa nhập tên thuốc!";
				checkBoolean=false;
			}
			
		}
		if(checkBoolean==true) {
			listCTTTTam.add(CTSKBT);
		}
		
		ModelAndView modelAndView = chiTietSoKhamBenhTam(skBenh.getMalichkham());
		modelAndView.addObject("listCTTTTam", listCTTTTam);
		modelAndView.addObject("message", messageString);
		modelAndView.addObject("display", Display);
		return modelAndView;
		
	}
	@RequestMapping(value = "/SaverToaThuoc{idSKB}")
	public ModelAndView SaverToaThuoc(@PathVariable int idSKB,@ModelAttribute("Benhs") DanhSachBenh insertbenh,Principal principal) {
		Boolean checkBoolean;
		String message="Lưu thành công";
		int tam = 0;
		
		SoKhamBenh skBenh = soKhamBenhMapper.selectByPrimaryKey(idSKB);
		for(ChiTietSoKhamBenhTam item:listCTTTTam) {
			tam=SaverTungItem(item, idSKB);
			if(tam<=0) {
				checkBoolean=false;
				message="Lưu không thành công";
			}
			System.out.println("cha m");
		}
		if(tam!=0) {
			message="Lưu thành công";
		 listCTTTTam.clear();
		}
		
		ModelAndView modelAndView = chiTietSoKhamBenh(skBenh.getMalichkham(),principal);
		modelAndView.addObject("message", message);
		return modelAndView;
		
	}

	public int SaverTungItem( ChiTietSoKhamBenhTam CTSKBT,  int idSKB) {
		int tam=0;
		ToaThuoc toaThuoc = new ToaThuoc();
		String messageString = "";
		SoKhamBenh skBenh = soKhamBenhMapper.selectByPrimaryKey(idSKB);
		if (skBenh.getMatoathuoc() == null) {
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			toaThuoc.setNgaytao(date);
			int i = 1;
			while (toaThuocMapper.selectByPrimaryKey(i) != null) {
				i++;

			}
			toaThuoc.setMa(i);
			toaThuocMapper.insert(toaThuoc);
			SoKhamBenh soKhamBenh = new SoKhamBenh();
			soKhamBenh.setMatoathuoc(toaThuoc.getMa());
			soKhamBenh.setMasokhambenh(idSKB);
			int success = soKhamBenhMapper.updateToaThuoc(soKhamBenh);
		} else {
			System.out.println("cha m6"+skBenh.getMatoathuoc());
			toaThuoc = toaThuocMapper.selectByPrimaryKey(skBenh.getMatoathuoc());
		}
		
			ThuocExample thuocExample = new ThuocExample();
			thuocExample.createCriteria().andTenthuocEqualTo(CTSKBT.getTenthuoc());
			
			List<Thuoc> thuoc = thuocMapper.selectByExample(thuocExample);
			if (thuoc != null) {
				ChiTietToaThuoc CTTT = new ChiTietToaThuoc();
				CTTT.setMathuoc(thuoc.get(0).getMa());
				CTTT.setMatoathuoc(toaThuoc.getMa());
				CTTT.setCachdung(CTSKBT.getCachdung());
				CTTT.setSoluongdung(CTSKBT.getSoluongdung());
				int ss = chiTietToaThuocMapper.insert(CTTT);
				if (ss > 0) {
					tam=1;
					messageString = "Thêm thành công!";

				} else {
					messageString = "Thêm thất bại";
				}
			} else {
				messageString = "Thuốc không tồn tại";
			}
		SoKhamBenh SKB = soKhamBenhMapper.selectByPrimaryKey(idSKB);
		
		return tam;
	}
}

package com.trang.TrangWebYTe.Controller.Admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.trang.TrangWebYTe.mapper.BacSiMapper;
import com.trang.TrangWebYTe.mapper.RoleMapper;
import com.trang.TrangWebYTe.mapper.TaiKhoanMapper;
import com.trang.TrangWebYTe.model.BacSi;
import com.trang.TrangWebYTe.model.BacSiExample;
import com.trang.TrangWebYTe.model.LichKham;
import com.trang.TrangWebYTe.model.Role;
import com.trang.TrangWebYTe.model.RoleExample;
import com.trang.TrangWebYTe.model.TaiKhoan;
import com.trang.TrangWebYTe.model.User;

@Controller
public class DSBacSiAdminController {
	@Autowired
	BacSiMapper bacSiMapper;
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	TaiKhoanMapper taiKhoanMapper;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@GetMapping("/dsbacsiadmin")
	public ModelAndView GetAllDSBacSi() {
		ModelAndView modelAndView = new ModelAndView("admin/dsbacsi");
		BacSiExample bacSiExample= new BacSiExample();
		List<BacSi> listBacSi= bacSiMapper.selectByExample(bacSiExample);
		modelAndView.addObject("listBacSi", listBacSi);
		return modelAndView;
	}
	@GetMapping("/thembacsiadmin")
	public ModelAndView themBacSi() {
		ModelAndView modelAndView= new ModelAndView("admin/thembacsi");
		TaiKhoan taikhoan = new TaiKhoan();
		BacSi bacSi= new BacSi();
		modelAndView.addObject("newUser", taikhoan);
		modelAndView.addObject("User",bacSi);
		return modelAndView;
	}
	public void themQuyen(String role) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);// muốn có nhiều quyền thì add thêm nhiều
																		// authority
		grantedAuthorities.add(authority);
		System.out.println(grantedAuthorities.get(0) + "hhs" + grantedAuthorities.size());
	}
	@RequestMapping(value = {"/thembacsi","/saveUser"})
	public ModelAndView SaveCustomer(Model model, @ModelAttribute("newUser") TaiKhoan newUser,@ModelAttribute("User") BacSi user) {
		ModelAndView modelAndView;
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andTenquyenEqualTo("BACSI");
		List<Role> role = roleMapper.selectByExample(roleExample);
		String tenQuyen = role.get(0).getTenquyen();
		try {
			if(tenQuyen!= null) {
				themQuyen("BACSI");
				user.setUsername(newUser.getUsername());
				newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
				newUser.setIdrole(role.get(0).getId());
				System.out.println(role.get(0).getId()+tenQuyen+ newUser.getIdrole());
				System.out.println(role.get(0).getId()+tenQuyen+ user.getFullname()+user.getUsername());
				int a = taiKhoanMapper.insert(newUser);
				int b= bacSiMapper.insert(user);
				if (a > 0 && b>0) {
					modelAndView = GetAllDSBacSi();
					String messageString="Thêm thành công! ";
					modelAndView.addObject("message",messageString );
					return modelAndView;
				} else {
					
					modelAndView = new ModelAndView("admin/thembacsi");
					String messageString="Thêm không thành công!";
					modelAndView.addObject("message",messageString );
				}
			}
			else {
				modelAndView = new ModelAndView("admin/thembacsi");
				String messageString="Thêm không thành công!";
				modelAndView.addObject("message",messageString );
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("admin/thembacsi");
			String messageString="Thêm không thành công! Bạn vui lòng chọn tên đăng nhập khác!!!";
			modelAndView.addObject("message",messageString );
			
		}
		return modelAndView;
		}
	
}


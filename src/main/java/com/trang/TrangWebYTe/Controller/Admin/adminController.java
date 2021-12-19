package com.trang.TrangWebYTe.Controller.Admin;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.AdminMapper;
import com.trang.TrangWebYTe.mapper.RoleMapper;
import com.trang.TrangWebYTe.mapper.TaiKhoanMapper;
import com.trang.TrangWebYTe.model.Admin;
import com.trang.TrangWebYTe.model.AdminExample;
import com.trang.TrangWebYTe.model.BacSi;
import com.trang.TrangWebYTe.model.Role;
import com.trang.TrangWebYTe.model.RoleExample;
import com.trang.TrangWebYTe.model.TaiKhoan;
import com.trang.TrangWebYTe.model.TaiKhoanExample;

@Controller
public class adminController {
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	TaiKhoanMapper taiKhoanMapper;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/dsadmin")
	public ModelAndView dsAdmin() {
		ModelAndView modelAndView = new ModelAndView("admin/dsadmin");
		AdminExample adminExample = new AdminExample();
		List<Admin> listAdmin = adminMapper.selectByExample(adminExample);
		modelAndView.addObject("listAdmin", listAdmin);
		return modelAndView;
	}

	@GetMapping("/themadmin")
	public ModelAndView themBacSi() {
		ModelAndView modelAndView = new ModelAndView("admin/themadmin");
		TaiKhoan taikhoan = new TaiKhoan();
		Admin admin = new Admin();
		modelAndView.addObject("newUser", taikhoan);
		modelAndView.addObject("User", admin);
		return modelAndView;
	}

	public void themQuyen(String role) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);// muốn có nhiều quyền thì add thêm nhiều
																		// authority
		grantedAuthorities.add(authority);
		System.out.println(grantedAuthorities.get(0) + "hhs" + grantedAuthorities.size());
	}

	@RequestMapping(value = { "saverAdmin" })
	public ModelAndView SaveCustomer(Model model, @ModelAttribute("newUser") TaiKhoan newUser,
			@ModelAttribute("User") Admin user) {
		ModelAndView modelAndView;
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andTenquyenEqualTo("ADMIN");
		List<Role> role = roleMapper.selectByExample(roleExample);
		String tenQuyen = role.get(0).getTenquyen();
		try {
			if (tenQuyen != null) {
				themQuyen("ADMIN");
				user.setUsername(newUser.getUsername());
				newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
				newUser.setIdrole(role.get(0).getId());
				System.out.println(role.get(0).getId() + tenQuyen + newUser.getIdrole());
				System.out.println(role.get(0).getId() + tenQuyen + user.getFullname() + user.getUsername());
				int a = taiKhoanMapper.insert(newUser);
				int b = adminMapper.insert(user);
				if (a > 0 && b > 0) {
					modelAndView = dsAdmin();
					String messageString = "Thêm thành công! ";
					modelAndView.addObject("message", messageString);
					return modelAndView;
				} else {

					modelAndView = new ModelAndView("admin/themadmin");
					String messageString = "Thêm không thành công!";
					modelAndView.addObject("message", messageString);
				}
			} else {
				modelAndView = new ModelAndView("admin/themadmin");
				String messageString = "Thêm không thành công!";
				modelAndView.addObject("message", messageString);
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("admin/themadmin");
			String messageString = "Thêm không thành công! Bạn vui lòng chọn tên đăng nhập khác!!!";
			modelAndView.addObject("message", messageString);

		}
		return modelAndView;
	}

	@GetMapping("/accountadmin")
	public ModelAndView getAccountAdmin(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("admin/admindetail");
		org.springframework.security.core.userdetails.User userdetailUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();
		Map<String, Object> parenMap = new HashMap<>();
		parenMap.put("username", userdetailUser.getUsername());
		System.out.println(userdetailUser.getUsername());
		Admin admin = adminMapper.getAllAdminTheoTen(parenMap);
		TaiKhoan taikhoan = taiKhoanMapper.selectByPrimaryKey(userdetailUser.getUsername());
		System.out.println("id" + userdetailUser.getUsername());
		modelAndView.addObject("updateAdmin", admin);
		modelAndView.addObject("updateTaiKhoan", taikhoan);

		return modelAndView;

	}

	@RequestMapping("/updateadmin")
	public ModelAndView UpdateUser(Model model, @ModelAttribute("updateBacSi") Admin updateUser, @ModelAttribute("updateTaiKhoan") TaiKhoan taiKhoan, Principal principal) {
		ModelAndView modelAndView;
		String messageString;
		org.springframework.security.core.userdetails.User userdetailUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();
		taiKhoan.setPassword(bCryptPasswordEncoder.encode(taiKhoan.getPassword()));
		System.out.println(
				updateUser.getFullname() + taiKhoan.getPassword() + updateUser.getPhone() + updateUser.getId());
		updateUser.setUsername(taiKhoan.getUsername());
		int a = adminMapper.updateByPrimaryKeyAdmin(updateUser);
		System.out.println("jhka" + taiKhoan.getUsername() + taiKhoan.getPassword() + taiKhoan.getIdrole()
				+ userdetailUser.getUsername());

		TaiKhoanExample taiKhoanExample = new TaiKhoanExample();
		taiKhoanExample.createCriteria().andUsernameEqualTo(userdetailUser.getUsername());
		int b = taiKhoanMapper.updateTaiKhoan(taiKhoan, taiKhoanExample);
		System.out.println(b+"hmm"+a);

		if (a > 0 && b > 0) {
			modelAndView = getAccountAdmin(principal);
			messageString = "Cập nhật thông tin thành công!!!";
			modelAndView.addObject("message", messageString);

			return modelAndView;
		} else {
			messageString = "Cập nhật thông tin thất bại!!!";
			modelAndView = getAccountAdmin(principal);
			modelAndView.addObject("message", messageString);
		}
		
		return modelAndView;
	}

}

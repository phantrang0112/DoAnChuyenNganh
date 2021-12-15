package com.trang.TrangWebYTe.Controller.BacSi;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.BacSiMapper;
import com.trang.TrangWebYTe.mapper.TaiKhoanMapper;
import com.trang.TrangWebYTe.model.BacSi;
import com.trang.TrangWebYTe.model.TaiKhoan;
import com.trang.TrangWebYTe.model.TaiKhoanExample;
import com.trang.TrangWebYTe.model.User;

@Controller
public class UserBacSiController {
	@Autowired
	BacSiMapper bacSiMapper;
	@Autowired
	TaiKhoanMapper taiKhoanMapper;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/accountbacsi")
	public ModelAndView getAccount(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("bacsi/bacsidetail");
		org.springframework.security.core.userdetails.User userdetailUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();
		Map<String, Object> parenMap = new HashMap<>();
		parenMap.put("username", userdetailUser.getUsername());
		System.out.println(userdetailUser.getUsername());
		BacSi bacsi = bacSiMapper.getAllBacSiTheoTen(parenMap);
		TaiKhoan taikhoan = taiKhoanMapper.selectByPrimaryKey(userdetailUser.getUsername());
		System.out.println("id" + userdetailUser.getUsername());
		modelAndView.addObject("updateBacSi", bacsi);
		modelAndView.addObject("updateTaiKhoan", taikhoan);
		
		modelAndView.addObject("bacsi", userdetailUser.getUsername());
		return modelAndView;

	}

	@RequestMapping("/accountbacsi/update")
	public ModelAndView UpdateUser(Model model, @ModelAttribute("updateBacSi") BacSi updateUser,
			@ModelAttribute("updateTaiKhoan") TaiKhoan taiKhoan, Principal principal) {
		ModelAndView modelAndView;
		String messageString;
		org.springframework.security.core.userdetails.User userdetailUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
				.getPrincipal();
		taiKhoan.setPassword(bCryptPasswordEncoder.encode(taiKhoan.getPassword()));
		System.out.println(
				updateUser.getFullname() + taiKhoan.getPassword() + updateUser.getPhone() + updateUser.getId());
		updateUser.setUsername(taiKhoan.getUsername());
		int a = bacSiMapper.updateByPrimaryKeyBacSi(updateUser);
		System.out.println("jhka" + taiKhoan.getUsername() + taiKhoan.getPassword() + taiKhoan.getIdrole()
				+ userdetailUser.getUsername());

		TaiKhoanExample taiKhoanExample = new TaiKhoanExample();
		taiKhoanExample.createCriteria().andUsernameEqualTo(userdetailUser.getUsername());
		int b = taiKhoanMapper.updateTaiKhoan(taiKhoan, taiKhoanExample);
		System.out.println(b);

		if (a > 0 && b > 0) {
			modelAndView = getAccount(principal) ;
			messageString = "Cập nhật thông tin thành công!!!";
			modelAndView.addObject("message", messageString);
			
			return modelAndView;
		} else {
			messageString = "Cập nhật thông tin thất bại!!!";
			modelAndView = getAccount(principal);
			modelAndView.addObject("message", messageString);
		}
		modelAndView.addObject("bacsi", userdetailUser.getUsername());
		return modelAndView;
	}
}

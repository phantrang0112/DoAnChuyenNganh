package com.trang.TrangWebYTe.Controller.User;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.trang.TrangWebYTe.mapper.NewsMapper;
import com.trang.TrangWebYTe.mapper.RoleMapper;
import com.trang.TrangWebYTe.mapper.TaiKhoanMapper;
import com.trang.TrangWebYTe.mapper.UserMapper;
import com.trang.TrangWebYTe.model.News;
import com.trang.TrangWebYTe.model.NewsExample;
import com.trang.TrangWebYTe.model.Role;
import com.trang.TrangWebYTe.model.RoleExample;
import com.trang.TrangWebYTe.model.TaiKhoan;
import com.trang.TrangWebYTe.model.TaiKhoanExample;
import com.trang.TrangWebYTe.model.User;
import com.trang.TrangWebYTe.model.UserExample;


@Controller
public class UserController {
	@Autowired
	UserMapper userMapper;
	@Autowired
	TaiKhoanMapper taiKhoanMapper;
	@Autowired
	RoleMapper RoleMapper;
	@Autowired
	NewsMapper newsMapper;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping(value = { "/register" }) // ten view luc chay tren local
	public ModelAndView register(Model model) {
		ModelAndView modelAndView = new ModelAndView("user/register"); // truyen vao ten view
		UserExample userExample = new UserExample();
		TaiKhoan taikhoan = new TaiKhoan();
		User user= new User();
		modelAndView.addObject("newUser", taikhoan);
		modelAndView.addObject("User", user);
		String messageString="";
		modelAndView.addObject("message",messageString );
		return modelAndView;

	}
	public void themQuyen(String role) {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);// muốn có nhiều quyền thì add thêm nhiều
																		// authority
		grantedAuthorities.add(authority);
		System.out.println(grantedAuthorities.get(0) + "hhs" + grantedAuthorities.size());
	}

	@RequestMapping(value = {"/register/saveUser","/saveUser"})
	public ModelAndView SaveCustomer(Model model, @ModelAttribute("newUser") TaiKhoan newUser,@ModelAttribute("User") User user) {
		ModelAndView modelAndView;
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andTenquyenEqualTo("USER");
		List<Role> role = RoleMapper.selectByExample(roleExample);
		String tenQuyen = role.get(0).getTenquyen();
		try {
			if(tenQuyen!= null) {
				themQuyen("USER");
				user.setUsername(newUser.getUsername());
				newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
				newUser.setIdrole(role.get(0).getId());
				System.out.println(role.get(0).getId()+tenQuyen+ newUser.getIdrole());
				System.out.println(role.get(0).getId()+tenQuyen+ user.getFullname()+user.getUsername());
				int a = taiKhoanMapper.insert(newUser);
				int b= userMapper.insert(user);
				if (a > 0 && b>0) {
					modelAndView = new ModelAndView("login");
					String messageString="Đăng kí thành công! Bạn vui lòng đăng nhập lại!!!";
					modelAndView.addObject("message",messageString );
					return modelAndView;
				} else {
					
					modelAndView = new ModelAndView("user/register");
					String messageString="Đăng kí không thành công!";
					modelAndView.addObject("message",messageString );
				}
			}
			else {
				modelAndView = new ModelAndView("user/register");
				String messageString="Đăng kí không thành công!";
				modelAndView.addObject("message",messageString );
			}
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("user/register");
			String messageString="Đăng kí không thành công! Bạn vui lòng chọn tên đăng nhập khác!!!";
			modelAndView.addObject("message",messageString );
			
		}
		
		
		
		
		return modelAndView;
	}
	@GetMapping("/account")
	public ModelAndView account(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("user/userdetail");
		org.springframework.security.core.userdetails.User userdetailUser= (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
		Map<String, Object> parenMap = new HashMap<>();
		parenMap.put("username", userdetailUser.getUsername());
		
		User user= userMapper.getAlluserTheoTen(parenMap);
		TaiKhoan taikhoan = taiKhoanMapper.selectByPrimaryKey(userdetailUser.getUsername());
		System.out.println("id"+ userdetailUser.getUsername());
		modelAndView.addObject("updateUser", user);
		modelAndView.addObject("updateTaiKhoan", taikhoan);
		String messageString="";
		
		
		modelAndView.addObject("message",messageString );
		return modelAndView;
	}
	@RequestMapping(value = "/account/update", method = RequestMethod.POST)
	public ModelAndView UpdateUser(Model model, @ModelAttribute("updateUser") User updateUser,@ModelAttribute("updateTaiKhoan") TaiKhoan taiKhoan,Principal principal) {
		ModelAndView modelAndView;
		String messageString;
		org.springframework.security.core.userdetails.User userdetailUser= (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
		taiKhoan.setPassword(bCryptPasswordEncoder.encode(taiKhoan.getPassword()));
		System.out.println(updateUser.getFullname()+taiKhoan.getPassword()+updateUser.getPhone()+updateUser.getId());
		   updateUser.setUsername(taiKhoan.getUsername());
		   int a = userMapper.updateByPrimaryKeySelective(updateUser);
		   System.out.println("jhka"+taiKhoan.getUsername()+taiKhoan.getPassword()+taiKhoan.getIdrole()+userdetailUser.getUsername());
			
		   	TaiKhoanExample taiKhoanExample= new TaiKhoanExample();
		   	taiKhoanExample.createCriteria().andUsernameEqualTo(userdetailUser.getUsername());
		    int b= taiKhoanMapper.updateTaiKhoan(taiKhoan,taiKhoanExample);
		    System.out.println(b);
			
			if (a > 0 && b>0) {
				modelAndView = new ModelAndView("user/userdetail");
				messageString="Cập nhật thông tin thành công!!!";
				modelAndView.addObject("message",messageString );
				modelAndView.addObject("updateUser", updateUser);
				return modelAndView;
			} else {
				messageString="Cập nhật thông tin thất bại!!!";
				modelAndView = new ModelAndView("user/userdetail");
				modelAndView.addObject("message",messageString );
			}	
		
		return modelAndView;
	}
}

package com.trang.TrangWebYTe.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trang.TrangWebYTe.mapper.RoleMapper;
import com.trang.TrangWebYTe.mapper.TaiKhoanMapper;
import com.trang.TrangWebYTe.mapper.UserMapper;
import com.trang.TrangWebYTe.model.Role;
import com.trang.TrangWebYTe.model.RoleExample;
import com.trang.TrangWebYTe.model.TaiKhoan;
import com.trang.TrangWebYTe.model.TaiKhoanExample;

@Service
public class CustomerService implements UserDetailsService {
	@Autowired
	TaiKhoanMapper taikhoanMapper;
	@Autowired
	RoleMapper roleMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {// username nhập liệu từ front
		TaiKhoanExample taikhoanExample = new  TaiKhoanExample();
		taikhoanExample.createCriteria().andUsernameEqualTo(username);
		List<TaiKhoan> listUser= taikhoanMapper.selectByExample(taikhoanExample);
		List<GrantedAuthority> grantedAuthorities= new ArrayList<GrantedAuthority>();
		if(listUser.size()>0) {
			TaiKhoan user = listUser.get(0);
			Role role= roleMapper.selectByPrimaryKey(listUser.get(0).getIdrole());
			
			GrantedAuthority authority= new SimpleGrantedAuthority("ROLE_"+role.getTenquyen());//muốn có nhiều quyền thì add thêm nhiều authority
			grantedAuthorities.add(authority);
			UserDetails userDetails= new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
			return userDetails;
		}
		else {
			new UsernameNotFoundException("Đăng nhập không thành công");
		}
		return null;
	}
	
}

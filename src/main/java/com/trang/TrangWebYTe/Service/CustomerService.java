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

import com.trang.TrangWebYTe.mapper.UserMapper;
import com.trang.TrangWebYTe.model.User;
import com.trang.TrangWebYTe.model.UserExample;



@Service
public class CustomerService implements UserDetailsService {
	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {// username nhập liệu từ front
		UserExample userExample = new  UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		List<User> listUser= userMapper.selectByExample(userExample);
		if(listUser.size()>0) {
			User user = listUser.get(0);
			List<GrantedAuthority> grantedAuthorities= new ArrayList<GrantedAuthority>();
			GrantedAuthority authority= new SimpleGrantedAuthority("ADMIN");//muốn có nhiều quyền thì add thêm nhiều authority
			grantedAuthorities.add(authority);
			
			UserDetails userDetails= new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
			System.out.println(user.getUsername()+ user.getPassword()+"hạkajshkds");
			System.out.println("huhu"+username);
			return userDetails;
		}
		else {
			new UsernameNotFoundException("Đăng nhập không thành công");
		}
		return null;
	}
}

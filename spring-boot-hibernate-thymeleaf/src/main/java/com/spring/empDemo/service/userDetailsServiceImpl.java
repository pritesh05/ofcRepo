package com.spring.empDemo.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.empDemo.model.entity.RolesEntity;
import com.spring.empDemo.model.entity.UsersEntity;
import com.spring.empDemo.repository.UsersRepository;


@Service
public class userDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsersRepository uRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " called !!!...");

		Optional<UsersEntity> optionalUser = uRepository.findByName(username);
		System.err.println(optionalUser);
		if (optionalUser == null) throw new UsernameNotFoundException(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (RolesEntity role : optionalUser.get().getRoles()) {
//			System.out.println("---> " + role);
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
		}

		User userDetails = new User(optionalUser.get().getName(),
				new BCryptPasswordEncoder().encode(optionalUser.get().getPassword()), grantedAuthorities);
		return userDetails;

	}
}
























/*
 * UsersEntity user = findUserbyUername(username); System.err.println(user);
 * UserBuilder builder = null; if (user != null) { System.err.println("--->" +
 * user + " username: " + username); builder =
 * org.springframework.security.core.userdetails.User.withUsername(username);
 * builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
 * 
 * } else { throw new UsernameNotFoundException("User not found."); }
 * 
 * return builder.build();
 */

//
//Optional<UsersEntity>  optionalUsers = uRepository.findByName(username);
//System.err.println(optionalUsers);
//       optionalUsers
//               .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//       return optionalUsers
//               .map(DbUserDetails::new).get();
package com.registration.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registration.entity.Customer;
import com.registration.repository.CustomerRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	CustomerRepository userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer=userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with userName:" +username));
		return UserDetailsImpl.build(customer);
	}

}

package base.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import base.entity.User;
import base.repository.UserRegisterRepo;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {// Used to load the user from database

	@Autowired
	private UserRegisterRepo userRepo;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepo.findByEmail(email);
		if (user == null)
			throw new UsernameNotFoundException("No User Found.");

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.isEnable(), true, true, true, getAuthorities(List.of(user.getRole())));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<String> roles) {
		ArrayList<GrantedAuthority> authoritites = new ArrayList<>();
		for (String role : roles) {
			authoritites.add(new SimpleGrantedAuthority(role));
		}
		return authoritites;
	}
}

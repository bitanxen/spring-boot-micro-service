package in.bitanxen.poc.app;

import java.util.*;
import java.util.Optional;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		Object token = authentication.getCredentials();
		return this.getAuthentication(token);
	}

	
	private AppUser getAuthentication(Object token) {
		if(token.toString().equals("123")) {
			
			List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
			authorities.add(new SimpleGrantedAuthority("GET_USER"));
			
			authorities.add(new SimpleGrantedAuthority("ADD_USER"));
			
			return new AppUser("user123", "p1234", authorities);
		}
		
		throw new BadCredentialsException("Invalid Token Provided");
	}
}

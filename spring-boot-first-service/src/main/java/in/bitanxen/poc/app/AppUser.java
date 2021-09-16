package in.bitanxen.poc.app;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUser extends User {
	
	private String username;
	
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;

	public AppUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

}

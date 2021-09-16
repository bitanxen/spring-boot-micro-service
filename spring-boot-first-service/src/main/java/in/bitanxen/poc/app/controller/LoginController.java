package in.bitanxen.poc.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class LoginController {

	
	@PostMapping("/login")
	public String login(String username, String password) {
		return "token";
	}
}

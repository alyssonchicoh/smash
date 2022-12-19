package br.com.ifce.smash;

import br.com.ifce.smash.model.User;
import br.com.ifce.smash.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TemplateApplication implements CommandLineRunner {

	private final UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

	public TemplateApplication(UserService userService){
		this.userService = userService;
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

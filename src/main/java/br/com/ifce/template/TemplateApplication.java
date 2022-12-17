package br.com.ifce.template;

import br.com.ifce.template.model.User;
import br.com.ifce.template.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		User user = new User();
		user.setEmail("alysson.chicoh@gmail.com");

	//	this.userService.save(user);
	}
}

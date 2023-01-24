package com.backend.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.backend.workshop.entities.User;
import com.backend.workshop.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// executado quando a aplicação for iniciada
		User firstUser = new User(null, "Maria da Silva", "maria@gmail.com", "0022334455", "123456");
		User secondUser = new User(null, "Jose da Silva", "eujose@gmail.com", "0000112233", "123456");
		User thirdUser = new User(null, "Victorio Silva", "vic-victorio@outlook.com", "0055558877", "123456");
		
		userRepository.saveAll(Arrays.asList(firstUser, secondUser, thirdUser));
	}
}

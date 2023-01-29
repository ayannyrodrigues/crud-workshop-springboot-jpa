package com.backend.workshop.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.backend.workshop.entities.Category;
import com.backend.workshop.entities.Order;
import com.backend.workshop.entities.User;
import com.backend.workshop.enums.OrderStatus;
import com.backend.workshop.repository.CategoryRepository;
import com.backend.workshop.repository.OrderRepository;
import com.backend.workshop.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		// executado quando a aplicação for iniciada
		User firstUser = new User(null, "Maria da Silva", "maria@gmail.com", "0022334455", "123456", new ArrayList<Order>());
		User secondUser = new User(null, "Jose da Silva", "eujose@gmail.com", "0000112233", "123456", new ArrayList<Order>());
		User thirdUser = new User(null, "Victorio Silva", "vic-victorio@outlook.com", "0055558877", "123456", new ArrayList<Order>());
						
		Order firstOder = new Order(null, Instant.parse("2023-01-05T19:53:07Z"), OrderStatus.CANCELED, firstUser);
		Order secondOder = new Order(null, Instant.parse("2022-10-10T11:50:09Z"), OrderStatus.DELIVERED, secondUser);
		Order thirdOder = new Order(null, Instant.parse("2022-03-21T22:40:07Z"), OrderStatus.PAID, thirdUser);
		Order fourthOder = new Order(null, Instant.parse("2022-03-21T22:40:07Z"), OrderStatus.WAITING_PAYMENT, firstUser);
		
		
		Category firstCategory = new Category(null, "Books");
		Category secondCategory = new Category(null, "Computers");
		Category thirdCategory = new Category(null, "Electronics");
		
		userRepository.saveAll(Arrays.asList(firstUser, secondUser, thirdUser));
		orderRepository.saveAll(Arrays.asList(firstOder, secondOder, thirdOder, fourthOder));
		categoryRepository.saveAll(Arrays.asList(firstCategory, secondCategory, thirdCategory));
	}
}

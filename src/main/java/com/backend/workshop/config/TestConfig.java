package com.backend.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.backend.workshop.entities.Category;
import com.backend.workshop.entities.Order;
import com.backend.workshop.entities.Product;
import com.backend.workshop.entities.User;
import com.backend.workshop.enums.OrderStatus;
import com.backend.workshop.repository.CategoryRepository;
import com.backend.workshop.repository.OrderRepository;
import com.backend.workshop.repository.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		// executado quando a aplicação for iniciada
		User firstUser = new User("Maria da Silva", "maria@gmail.com", "0022334455", "123456");
		User secondUser = new User("Jose da Silva", "eujose@gmail.com", "0000112233", "123456");
		User thirdUser = new User("Victorio Silva", "vic-victorio@outlook.com", "0055558877", "123456");
						
		Order firstOder = new Order(Instant.parse("2023-01-05T19:53:07Z"), OrderStatus.CANCELED, firstUser);
		Order secondOder = new Order(Instant.parse("2022-10-10T11:50:09Z"), OrderStatus.DELIVERED, secondUser);
		Order thirdOder = new Order(Instant.parse("2022-03-21T22:40:07Z"), OrderStatus.PAID, thirdUser);
		Order fourthOder = new Order(Instant.parse("2022-03-21T22:40:07Z"), OrderStatus.WAITING_PAYMENT, firstUser);
		
		Product firstProduct = new Product("Star Wars: Episode II – Attack of the Clones", "Is a 2002 American epic space opera film directed by George Lucas and written by Lucas and Jonathan Hales.", 90.5, "");
		Product secondProduct = new Product("Smart TV", "4K Ultra HD deliver a clearer and more vibrant picture with brighter colors.", 2190.0, "");
		Product thirdProduct = new Product("PC Gamer", "This powerful gaming PC is capable of running all your favorite games.", 3600.0, "");
		Product fourthProduct = new Product("Wireless Headphones", "Ultra-comfortable, lightweight design with soft fit leather", 200.0, "");
				
		
		Category firstCategory = new Category("Books");
		Category secondCategory = new Category("Computers");
		Category thirdCategory = new Category("Electronics");
		
		userRepository.saveAll(Arrays.asList(firstUser, secondUser, thirdUser));
		orderRepository.saveAll(Arrays.asList(firstOder, secondOder, thirdOder, fourthOder));
		productRepository.saveAll(Arrays.asList(firstProduct, secondProduct, thirdProduct, fourthProduct));
		categoryRepository.saveAll(Arrays.asList(firstCategory, secondCategory, thirdCategory));
		
		firstProduct.getCategories().add(firstCategory);
		secondProduct.getCategories().add(thirdCategory);
		thirdProduct.getCategories().add(secondCategory);
		thirdProduct.getCategories().add(thirdCategory);
		fourthProduct.getCategories().add(thirdCategory);
		
		productRepository.saveAll(Arrays.asList(firstProduct, secondProduct, thirdProduct, fourthProduct));
	}
}

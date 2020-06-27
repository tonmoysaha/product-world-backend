package com.fullstack.springboot.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fullstack.springboot.entity.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void test() {
		List<Product> findAll = this.productRepository.findAll();
		for (Product product : findAll) {
			System.out.println(product);
		}
		assertNotNull(findAll);
	}

}

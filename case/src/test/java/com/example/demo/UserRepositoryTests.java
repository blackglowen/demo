package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

		@Autowired
		private UserRepository repo;
		
		@Autowired
		private TestEntityManager entityManager;
		
		@Test
		public void testCreateUser() {
			User user=new User();
			user.setEmail("blackglowen12@gmail.com");
			user.setPassword("ilk");
			user.setFirstName("ibo");
			user.setLastName("kacmaz");
			
			User savedUser= repo.save(user);
			
			User existUser =entityManager.find(User.class,savedUser.getId());
			
			assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

}
		@Test
		public void testFinduserByEmail() {
			String email="sefer@gmail.com";
			
			User user =repo.findByEmail(email);
			
			assertThat(user).isNotNull();
			
			
			
		}



}

package com.pruebas.springboot.jpa;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.pruebas.springboot.jpa.entity.User;
import com.pruebas.springboot.jpa.repository.UserRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	private UserRepository userRepository;

	private Log logger = LogFactory.getLog(JpaApplication.class);

	public JpaApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//grabarUsuariosDB();
		getInforUser();
	}

	private void getInforUser() {
		logger.info(" usuario encontrado =  "
				+ userRepository.findByEmail("carlos@domain.com").orElseThrow(() -> new RuntimeException("No se hallo usuario que cumpliera con el parametro")).toString());
		
		
		
		userRepository.findAndSort("", Sort.by("id").ascending()).stream().forEach(user -> logger.info("Usuarios: " + user));
		
		userRepository.findByNombre("luis").stream().forEach(user -> logger.info("usuario obtenido con query method: " + user));
		
		logger.info("usuario buscado por email y nombre " + userRepository.findByEmailAndNombre("carlos@domain.com", "carlos").orElseThrow(() -> new RuntimeException("No se encontro el usuario")).toString());
		
		userRepository.findByNombreLike("%au%").stream().forEach(user -> logger.info("usuario con like hallado " + user) );
		
		userRepository.findByNombreLikeOrNombreLike("%au%", "%ua%").stream().forEach(user -> logger.info("usuario con varios like y or hallado " + user) );;
		
	}

	private void grabarUsuariosDB() {
		User user1 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 10, 20));
		User user2 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 04, 20));
		User user3 = new User("Antonio", "antonio@domain.com", LocalDate.of(2021, 06, 20));
		User user4 = new User("Laura", "laura@domain.com", LocalDate.of(2021, 11, 20));
		User user5 = new User("Jose", "jose@domain.com", LocalDate.of(2020, 01, 02));
		User user6 = new User("Juan", "juan@domain.com", LocalDate.of(2020, 01, 02));
		User user7 = new User("luisa", "luisa@domain.com", LocalDate.of(2020, 01, 02));

		List<User> listaUsuarios = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);

		listaUsuarios.stream().forEach(user -> userRepository.save(user));

	}

}

package com.codehunt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurity2Application  implements CommandLineRunner{

    private final BCryptPasswordEncoder encode;

    SpringSecurity2Application(BCryptPasswordEncoder encode) {
        this.encode = encode;
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}

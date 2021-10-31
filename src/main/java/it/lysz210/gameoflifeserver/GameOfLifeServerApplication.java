package it.lysz210.gameoflifeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GameOfLifeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameOfLifeServerApplication.class, args);
	}

}

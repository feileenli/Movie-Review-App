package dev.feileen.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//this annotation combines @controller and @responsebody so that we don't need to annotate each method indvidually  
@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}
	//This annotation maps HTTP GET requests onto the apiRoot method.
	//when a GET request is made to http://localhost:8080/ the apiRoot method is invoked 
	@GetMapping("/")
	public String apiRoot()  {
		return "Hello, World!";
	}

}

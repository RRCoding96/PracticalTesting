package sample.cafekiosk.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing // -> mockMvc 띄울 때 이거도 띄워야돼서 config 따로 관리
@SpringBootApplication
public class CafekioskApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafekioskApplication.class, args);
	}

}

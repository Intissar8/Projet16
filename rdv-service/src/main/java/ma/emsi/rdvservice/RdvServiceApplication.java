package ma.emsi.rdvservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class RdvServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdvServiceApplication.class, args);
	}
    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

}

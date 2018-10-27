package hpbui.gamerportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("hpbui.gamerportal.repository")
@EntityScan("hpbui.gamerportal.entity")
@SpringBootApplication
public class GamerPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamerPortalApplication.class, args);
	}
}

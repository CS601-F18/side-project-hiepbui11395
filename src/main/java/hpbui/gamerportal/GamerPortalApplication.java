package hpbui.gamerportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableJpaRepositories("hpbui.gamerportal.repository")
@EntityScan("hpbui.gamerportal.entity")
@SpringBootApplication
@EnableScheduling
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class GamerPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamerPortalApplication.class, args);
	}
}

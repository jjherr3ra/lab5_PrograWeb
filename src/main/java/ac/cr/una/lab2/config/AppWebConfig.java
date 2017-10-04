package ac.cr.una.lab2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ac.cr.una.lab2")
public class AppWebConfig {
}

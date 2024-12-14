package WebTech.Webtech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public  void addCorsMappings(final CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("http://localhost:5177",
                        "https://webtech-frontend-fthr.onrender.com")
                .allowCredentials(true);
    }
}

package sda24.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import sda24.HWController;
import sda24.query.QueryDao;

/**
 * Created by RENT on 2017-03-01.
 */

@Configuration
@ComponentScan(basePackageClasses = {HWController.class, QueryDao.class})
@EnableWebMvc
public class Config extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").allowedMethods("*").allowedOrigins("*");
    }

}

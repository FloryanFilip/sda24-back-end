package sda24.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import sda24.HWController;
import sda24.handler.ExceptionHandler;
import sda24.parser.Parser;
import sda24.parser.WebConnector;

import java.util.concurrent.Executor;

/**
 * Created by RENT on 2017-03-01.
 */

@Configuration
@ComponentScan("sda")
@EnableWebMvc
@EnableAsync
public class Config extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").allowedMethods("*").allowedOrigins("*");
    }

//


}

package sda24.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import sda24.HWController;
import sda24.query.GoogleDao;

/**
 * Created by RENT on 2017-03-01.
 */
@Configuration
@ComponentScan(basePackageClasses = {HWController.class, GoogleDao.class})
@EnableWebMvc
public class Config {
}

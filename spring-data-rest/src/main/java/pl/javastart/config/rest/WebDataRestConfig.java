package pl.javastart.config.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@ComponentScan(basePackageClasses = CustomDataRestConfig.class)
public class WebDataRestConfig extends RepositoryRestMvcConfiguration {
}

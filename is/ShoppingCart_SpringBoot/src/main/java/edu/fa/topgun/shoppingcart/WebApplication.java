package edu.fa.topgun.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "edu.fa.topgun.shoppingcart.*" })
public class WebApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(
      SpringApplicationBuilder application) {
    return application.sources(WebApplication.class);
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(WebApplication.class, args);
  }

}

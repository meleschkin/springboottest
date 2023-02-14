package org.meleschkin;

import lombok.extern.log4j.Log4j2;
import org.meleschkin.customize.HelloWorldSpringApplicationContextInitializer;
import org.meleschkin.customize.HelloWorldSpringApplicationEventListener;
import org.meleschkin.utils.CommonsLangUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;

@SpringBootApplication(exclude = {H2ConsoleAutoConfiguration.class}, scanBasePackageClasses = {Application.class})
@Log4j2
public class Application implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new HelloWorldSpringApplicationEventListener());
        springApplication.addInitializers(new HelloWorldSpringApplicationContextInitializer());
        springApplication.run(args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Here you can initialize your application ...");
        log.info(CommonsLangUtils.baseToString(args.getSourceArgs()));
    }
}

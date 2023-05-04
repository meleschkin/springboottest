package org.meleschkin.customize;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class HelloWorldSpringApplicationEventListener implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("Hello World Application Initialization: Receive Initialization Message " + event.toString());
    }

}

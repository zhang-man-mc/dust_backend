package com.flightfeather.monitor;

import com.flightfeather.monitor.scheduledtasks.TaskController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonitorApplication {
    @Autowired
    private TaskController taskController;

    @Bean
    public ApplicationRunner runner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                taskController.run();
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);

    }

}

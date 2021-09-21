package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages = {"security", "hibernate.repository","config","repository","rest","service", "annotations", "model"})
//@EnableMongoRepositories("repository")
@EntityScan("entity")
@EnableJpaRepositories("hibernate")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
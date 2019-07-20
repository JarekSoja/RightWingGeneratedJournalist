package com.soja.rightwinggeneratedjournalist;

import com.soja.webscrapper.scrappingstrategy.WebScrapperContext;
import com.soja.webscrapper.scrappingstrategy.impl.WPolityceScrappingStrategy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RightWingGeneratedJournalistApplication {

    public static void main(String[] args) {
        SpringApplication.run(RightWingGeneratedJournalistApplication.class, args);


    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
            WebScrapperContext strategy = new WebScrapperContext();
            strategy.scrapeSingleWebsite(new WPolityceScrappingStrategy());

        };
    }
}

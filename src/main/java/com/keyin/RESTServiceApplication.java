//RESTServiceApplication
package com.keyin;

import com.keyin.hello.Greeting;
import com.keyin.hello.GreetingService;
import com.keyin.hello.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RESTServiceApplication implements CommandLineRunner {

    @Autowired
    private GreetingService greetingService;

    public static void main(String[] args) {
        SpringApplication.run(RESTServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        addGreetings();
        displayGreetings();
    }

    private void addGreetings() {
        greetingService.addGreeting(new Greeting("Hello", new Language("English")));
        greetingService.addGreeting(new Greeting("Bonjour", new Language("French")));
        greetingService.addGreeting(new Greeting("こんにちは", new Language("Japanese")));
        greetingService.addGreeting(new Greeting("Ahoj", new Language("Czech")));
        greetingService.addGreeting(new Greeting("Hola", new Language("Spanish")));
    }

    private void displayGreetings() {
        greetingService.getAllGreetings().forEach(g -> {
            System.out.println(g.getText() + " - " + g.getLanguage().getName());
        });
    }
}
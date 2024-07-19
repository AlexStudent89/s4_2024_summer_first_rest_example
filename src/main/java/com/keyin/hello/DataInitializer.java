//DataInitializer
//package com.keyin.hello;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    @Autowired
//    private GreetingService greetingService;
//
//    @Autowired
//    private LanguageRepository languageRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<String> languages = Arrays.asList("English", "French", "Japanese", "Czech", "Spanish");
//
//        for (String lang : languages) {
//            if (languageRepository.findByName(lang) == null) {
//                languageRepository.save(new Language(lang));
//            }
//        }
//
//        Greeting greeting = new Greeting();
//        greeting.setName("Sample Greeting");
//        greeting.setGreeting("Hello in different languages");
//
//        for (String lang : languages) {
//            Language language = languageRepository.findByName(lang);
//            greeting.getLanguages().add(language);
//        }
//
//        greetingService.createGreeting(greeting);
//    }
//}
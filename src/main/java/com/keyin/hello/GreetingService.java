//GreetingService
package com.keyin.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public Greeting addGreeting(Greeting greeting) {
        Language language = languageRepository.findByName(greeting.getLanguage().getName());
        if (language == null) {
            language = languageRepository.save(greeting.getLanguage());
        }
        greeting.setLanguage(language);
        return greetingRepository.save(greeting);
    }

    public List<Greeting> getAllGreetings() {
        return (List<Greeting>) greetingRepository.findAll();
    }
}
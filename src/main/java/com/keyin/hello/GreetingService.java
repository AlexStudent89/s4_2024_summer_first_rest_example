//GreetingService
package com.keyin.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public Greeting getGreeting(long index) {
        Optional<Greeting> result = greetingRepository.findById(index);
        return result.orElse(null);
    }

    public Greeting createGreeting(Greeting newGreeting) {
        if (newGreeting.getLanguages() == null || newGreeting.getLanguages().isEmpty()) {
            Language english = languageRepository.findByName("English");
            if (english == null) {
                english = new Language("English");
                languageRepository.save(english);
            }
            newGreeting.setLanguages(List.of(english));
        } else {
            for (Language language : newGreeting.getLanguages()) {
                Language langInDB = languageRepository.findByName(language.getName());
                if (langInDB == null) {
                    language = languageRepository.save(language);
                }
            }
        }
        return greetingRepository.save(newGreeting);
    }

    public List<Greeting> getAllGreetings() {
        return (List<Greeting>) greetingRepository.findAll();
    }

    public Greeting updateGreeting(long index, Greeting updatedGreeting) {
        Greeting greetingToUpdate = getGreeting(index);
        if (greetingToUpdate != null) {
            greetingToUpdate.setName(updatedGreeting.getName());
            greetingToUpdate.setGreeting(updatedGreeting.getGreeting());
            greetingToUpdate.setLanguages(updatedGreeting.getLanguages());
            return greetingRepository.save(greetingToUpdate);
        }
        return null;
    }

    public void deleteGreeting(long index) {
        Greeting greeting = getGreeting(index);
        if (greeting != null) {
            greetingRepository.delete(greeting);
        }
    }

    public List<Greeting> findGreetingsByNameAndGreeting(String name, String greetingName) {
        return greetingRepository.findByNameAndGreeting(name, greetingName);
    }

    public Greeting addLanguageToGreeting(Long greetingId, Language newLanguage) {
        Optional<Greeting> optionalGreeting = greetingRepository.findById(greetingId);
        if (optionalGreeting.isPresent()) {
            Greeting greeting = optionalGreeting.get();
            boolean languageExists = greeting.getLanguages().stream()
                    .anyMatch(language -> language.getName().equalsIgnoreCase(newLanguage.getName()));
            if (!languageExists) {
                greeting.getLanguages().add(newLanguage);
                return greetingRepository.save(greeting);
            }
        }
        return null;
    }
}
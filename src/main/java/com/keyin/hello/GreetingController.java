//GreetingController
package com.keyin.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("search_greeting")
    public List<Greeting> searchGreeting(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "greeting", required = false) String greeting) {
        return greetingService.findGreetingsByNameAndGreeting(name, greeting);
    }

    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @GetMapping("/{index}")
    public Greeting getGreeting(@PathVariable Long index) {
        return greetingService.getGreeting(index);
    }

    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting newGreeting) {
        return greetingService.createGreeting(newGreeting);
    }

    @PutMapping("/{index}")
    public Greeting updateGreeting(@PathVariable Long index, @RequestBody Greeting updatedGreeting) {
        return greetingService.updateGreeting(index, updatedGreeting);
    }

    @DeleteMapping("/{index}")
    public void deleteGreeting(@PathVariable Long index) {
        greetingService.deleteGreeting(index);
    }

    @PutMapping("/{id}/languages")
    public Greeting addLanguageToGreeting(@PathVariable Long id, @RequestBody Language newLanguage) {
        return greetingService.addLanguageToGreeting(id, newLanguage);
    }
}
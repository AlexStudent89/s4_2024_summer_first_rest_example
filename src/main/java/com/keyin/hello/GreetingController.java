//GreetingController
package com.keyin.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @PutMapping
    public Greeting addGreeting(@RequestBody Greeting greeting) {
        return greetingService.addGreeting(greeting);
    }

    @GetMapping
    public Iterable<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
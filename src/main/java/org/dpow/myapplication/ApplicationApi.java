package org.dpow.myapplication;

import org.dpow.myapplication.api.controller.GreetingController;
import org.dpow.myapplication.api.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationApi {
    @Autowired
    GreetingController greetingController;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return greetingController.greeting(name);
    }

    @PostMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, @RequestBody String postBody) {
        return greetingController.greeting(name, postBody);
    }
}

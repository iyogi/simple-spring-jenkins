package com.yrs.spring.springjenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {


    //http://localhost:9090/users/whoami
    @GetMapping(path = "/whoami")
    public User whoAmI() {
        return new User("John");
    }


    public static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}

package com.dev.mobileappws.ui.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable String id) {
        return "getUser() was called with id: " + id;
    }

    @GetMapping()
    public String getUser(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {
        return "getUser() was called with page = " + page + " and limit = " + limit;
    }

    @PostMapping
    public String createUser() {
        return "createUser() was called";
    }

    @PutMapping
    public String updateUser() {
        return "updateUser() was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser() was called";
    }

}

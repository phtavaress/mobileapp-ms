package com.dev.mobileappws.ui.controllers;

import com.dev.mobileappws.ui.model.request.UserDetailsRequest;
import com.dev.mobileappws.ui.model.response.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User returnedValue = new User();
        returnedValue.setEmail("test@test.com");
        returnedValue.setFirstName("Pedro");
        returnedValue.setLastName("Tavares");
        return new ResponseEntity<User>(returnedValue, HttpStatus.OK);
    }

    @GetMapping()
    public String getUser(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit,
            @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
    ) {
        return "getUser() was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDetailsRequest userDetailsRequest) {
        User returnedValue = new User();
        returnedValue.setEmail(userDetailsRequest.getEmail());
        returnedValue.setFirstName(userDetailsRequest.getFirstName());
        returnedValue.setLastName(userDetailsRequest.getLastName());
        return new ResponseEntity<User>(returnedValue, HttpStatus.OK);
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

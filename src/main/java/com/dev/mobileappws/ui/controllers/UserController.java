package com.dev.mobileappws.ui.controllers;

import com.dev.mobileappws.ui.model.request.UpdateUserDetail;
import com.dev.mobileappws.ui.model.request.UserDetailsRequest;
import com.dev.mobileappws.ui.model.response.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    Map<String, User> users;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        if(users.containsKey(id)) {
            return new ResponseEntity<User>(users.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
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
        String userId = UUID.randomUUID().toString();
        returnedValue.setUserId(userId);
        if(users == null) users = new HashMap<>();
        users.put(userId, returnedValue);
        return new ResponseEntity<User>(returnedValue, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable String id, @Valid @RequestBody UpdateUserDetail updateUserDetail) {
        User storedUser = users.get(id);
        storedUser.setFirstName(updateUserDetail.getFirstName());
        storedUser.setLastName(updateUserDetail.getLastName());
        users.put(id, storedUser);
        return storedUser;
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser() was called";
    }

}

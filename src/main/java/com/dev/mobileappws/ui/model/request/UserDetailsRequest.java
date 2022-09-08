package com.dev.mobileappws.ui.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDetailsRequest {

    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be grater than 8 characteres and less than 16 characteres")
    private String password;

}

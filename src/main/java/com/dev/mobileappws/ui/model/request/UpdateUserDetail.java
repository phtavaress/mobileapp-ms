package com.dev.mobileappws.ui.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserDetail {
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;
}

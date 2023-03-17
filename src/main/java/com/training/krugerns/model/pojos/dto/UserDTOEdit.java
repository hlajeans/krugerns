package com.training.krugerns.model.pojos.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class UserDTOEdit {
    @NotNull
    @NotEmpty
    private String names;

    @NotNull
    @NotEmpty
    private String lastName;


    @NotNull
    @Min(value = 1000000000)
    @Max(value = 2000000000)
    private int ci;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Min(1)
    private int idRole;

    @NotNull
    @NotEmpty
    private Date birthDate;

    @NotNull
    @NotEmpty
    private String adress;

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;

}

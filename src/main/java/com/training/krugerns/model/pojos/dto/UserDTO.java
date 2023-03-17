package com.training.krugerns.model.pojos.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UserDTO {
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

}

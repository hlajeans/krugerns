package com.training.krugerns.model.pojos.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserVO {
    private int id;
    private int ci;
    private String lastName;
    private String names;
    private String email;
    private String role;
}

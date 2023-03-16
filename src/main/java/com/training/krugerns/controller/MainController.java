package com.training.krugerns.controller;

import com.training.krugerns.commons.ResultResponse;
import com.training.krugerns.model.entity.User;
import com.training.krugerns.model.entity.enums.HttpMessageResponse;
import com.training.krugerns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public ResponseEntity<?> findAll(Pageable pageable){
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpMessageResponse.FIND_SUCESS.getValue()).data(userService.findAll(pageable)).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")int id){
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            userService.delete(user.get());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpMessageResponse.DELETE_SUCESS.getValue()).build(), HttpStatus.OK);
    }else{
            return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpMessageResponse.NOT_FOUND.getValue()).build(),HttpStatus.OK);
        }
    }

}

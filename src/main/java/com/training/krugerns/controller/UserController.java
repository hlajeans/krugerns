package com.training.krugerns.controller;

import com.training.krugerns.commons.ResultResponse;
import com.training.krugerns.model.entity.User;
import com.training.krugerns.model.entity.enums.HttpMessageResponse;
import com.training.krugerns.model.pojos.dto.UserDTO;
import com.training.krugerns.service.RoleService;
import com.training.krugerns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping("/users")
    public ResponseEntity<?> findAll(Pageable pageable){
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpMessageResponse.FIND_SUCESS.getValue()).data(userService.findAll(pageable)).build(), HttpStatus.OK);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<?> findAllRole(@PathVariable("id") int id){
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpMessageResponse.FIND_SUCESS.getValue()).data(roleService.findId(id)).build(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> persist(@Valid @RequestBody UserDTO dto){
        Optional<User> user = userService.findByCI(dto.getCi());
        if(user.isEmpty()){
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(HttpMessageResponse.SAVE_SUCESS.getValue()).data(userService.persist(dto)).build(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(ResultResponse.builder().status(false).message(HttpMessageResponse.CLONED.getValue()).build(), HttpStatus.OK);
        }
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

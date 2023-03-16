package com.training.krugerns.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id;

    @Column(name = "ci", unique = true ,length =10)
    private int ci;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "nombres")
    private String names;

    @Column(name = "correo")
    private String email;

    @Column(name = "fecha_nacimiento")
    private Date birthDate;

    @Column(name = "direccion")
    private String address;

    @Column(name = "telefono", length = 10)
    private Integer telephone;

    @Column(name= "usuario")
    private String user;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Role role;

}

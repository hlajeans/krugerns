package com.training.krugerns.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "vacunacion")

public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacunacion")
    private int id;

    @Column(name = "fecha")
    private Date date;

    @Column(name = "dosis")
    private int dose;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_vacuna")
    private Vaccine vaccine;
}

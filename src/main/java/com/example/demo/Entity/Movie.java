package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmovie", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "iduser", nullable = false)
    private User iduser;

    @Column(name = "titulo", nullable = false, length = 45)
    private String titulo;

    @Column(name = "overview", nullable = false, length = 45)
    private String overview;

    @Column(name = "popularidad", nullable = false, length = 45)
    private String popularidad;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

}

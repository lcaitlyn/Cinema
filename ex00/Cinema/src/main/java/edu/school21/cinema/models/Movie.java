package edu.school21.cinema.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "cinema")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "age_limit")
    private Integer ageLimit;
    private String description;
}

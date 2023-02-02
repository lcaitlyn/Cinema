package edu.school21.cinema.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "cinema")
@Data
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer seats;
}

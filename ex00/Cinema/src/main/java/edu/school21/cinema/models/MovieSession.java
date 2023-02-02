package edu.school21.cinema.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "cinema")
@Data
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;
    private Integer price;
    @ManyToOne
    private Hall hall;
}

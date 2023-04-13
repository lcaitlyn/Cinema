package edu.school21.cinema.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MovieImage {
    @Id
    private String id;

    private String type;
}

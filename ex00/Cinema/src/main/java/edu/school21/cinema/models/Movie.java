package edu.school21.cinema.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(schema = "cinema")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Заполните поле")
    private String name;

    @Column(name = "release_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Выберите дату")
    private LocalDate releaseDate;

    @Column(name = "age_limit")
    @Min(value = 0, message = "Возвраст не может быть ниже 0")
    @NotNull(message = "Заполните поле")
    private Integer ageLimit;

    @Column(name = "movie_image_id")
    @OneToOne
    @NotNull(message = "Добавьте постер")
    private MovieImage image;

    private String description;
}

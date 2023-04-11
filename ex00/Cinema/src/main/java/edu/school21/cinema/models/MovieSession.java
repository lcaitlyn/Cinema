package edu.school21.cinema.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(schema = "cinema")
@Data
public class MovieSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Заполните поле")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime time;

    @NotNull(message = "Заполните поле")
    @Min(value = 0, message = "Цена не может быть меньше 0")
    private Integer price;

    @ManyToOne
    @NotNull(message = "Заполните поле")
    private Hall hall;
}

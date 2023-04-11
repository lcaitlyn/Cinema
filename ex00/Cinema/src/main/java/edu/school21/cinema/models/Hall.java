package edu.school21.cinema.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "cinema")
@Data
public class Hall {
    @Id
    @NotNull(message = "Заполните поле")
    @Min(value = 1, message = "Номер зала не может быть меньше 1")
    private Long id;

    @NotNull(message = "Заполните поле")
    @Min(value = 1, message = "Количество мест не может быть меньше 1")
    private Integer seats;
}

package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import org.springframework.stereotype.Repository;

@Repository
public class HallDao extends AbstractDao<Hall> {

    public HallDao() {
        super(Hall.class);
    }
}

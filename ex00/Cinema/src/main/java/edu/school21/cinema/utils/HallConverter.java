package edu.school21.cinema.utils;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.repositories.HallDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HallConverter implements Converter<String, Hall> {

    @Autowired
    HallDao hallDao;

    @Override
    public Hall convert(String source) {
        try {
            Long id = Long.valueOf(source);
            return hallDao.findById(id);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

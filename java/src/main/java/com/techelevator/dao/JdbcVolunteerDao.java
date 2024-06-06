package com.techelevator.dao;

import com.techelevator.model.VolunteerDto;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcVolunteerDao implements VolunteerDao {
    private JdbcTemplate template;

    public JdbcVolunteerDao(DataSource ds) {
        template = new JdbcTemplate(ds);
    }
    @Override
    public VolunteerDto addVolunteer(VolunteerDto volunteerToAdd) {
        return new VolunteerDto();
    }
}

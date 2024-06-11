package com.techelevator.dao;

import com.techelevator.model.VolunteerDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcVolunteerDao implements VolunteerDao {
    private JdbcTemplate jdbcTemplate;
    private UserDao userDao;

    public JdbcVolunteerDao(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }
    @Override
    public VolunteerDto getVolunteer(int volunteerId) {
        VolunteerDto volunteer = new VolunteerDto();
        String sql = "SELECT * FROM volunteers WHERE volunteer_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, volunteerId);
            if (results.next()) {
                volunteer = mapRowToVolunteer(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting to database");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Problem with Data Integrity");
        }
        return volunteer;
    }
    @Override
    public List<VolunteerDto> getAllVolunteers() {
        List<VolunteerDto> volunteers = new ArrayList<>();
        String sql = "SELECT * FROM volunteers";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                VolunteerDto volunteer = mapRowToVolunteer(results);
                volunteers.add(volunteer);
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Data problems");
        }
        return volunteers;
    }

    @Override
    public VolunteerDto addVolunteer(VolunteerDto volunteerToAdd) {

        // Set new volunteer's initial username to be their provided email address,
        // and temp password to "password" which they will change when they login for the first time.
        final String NEW_USER_USERNAME = volunteerToAdd.getEmail();
        final String NEW_USER_TEMP_PASSWORD = new BCryptPasswordEncoder().encode("password");
        final String NEW_USER_ROLE = "ROLE_USER";

        // Using a Common Table Expression (CTE)
        String sql = "WITH user_insert AS (" +
                "INSERT INTO users (username, password_hash, role) " +
                "VALUES (?, ?, ?) " +
                "RETURNING user_id" +
                ") " +
                "INSERT INTO volunteers (user_id, first_name, last_name, email, phone_number, zip_code, approval_status) " +
                "SELECT user_id, ?, ?, ?, ?, ?, ?  " +
                "FROM user_insert " +
                "RETURNING volunteer_id;";

        int newVolunteerId = -1;
        try {
            newVolunteerId = jdbcTemplate.queryForObject(sql, Integer.class,

                    // 3 query parameters for INSERT INTO users
                    NEW_USER_USERNAME, NEW_USER_TEMP_PASSWORD, NEW_USER_ROLE,

                    // 6 query parameters for INSERT INTO volunteers
                    volunteerToAdd.getFirstName(), volunteerToAdd.getLastName(), volunteerToAdd.getEmail(),
                    volunteerToAdd.getPhoneNumber(), volunteerToAdd.getZipCode(), volunteerToAdd.getApprovalStatus()

            );
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting to database");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Problem with Data Integrity");
            System.out.println(e.getMessage());
        }
        return getVolunteer(newVolunteerId);
    }



    @Override
    public VolunteerDto updateVolunteer(VolunteerDto volunteerToUpdate) {

        String sql = "UPDATE volunteers SET approval_status = ? " +
                "WHERE volunteer_id = ?;";

        int updatedCount = -1;
        try {
            updatedCount = jdbcTemplate.update(sql,
                    volunteerToUpdate.getApprovalStatus(),
                    volunteerToUpdate.getVolunteerId()
                );
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting to database");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Problem with Data Integrity");
            System.out.println(e.getMessage());
        }
        if (updatedCount > 0) {
            return getVolunteer(volunteerToUpdate.getVolunteerId());
        } else {
            System.out.println("Nothing updated. Check if volunteer ID exists.");
            return null;
        }
    }



    private VolunteerDto mapRowToVolunteer(SqlRowSet sqlRowSet) {
        VolunteerDto volunteer = new VolunteerDto();

        volunteer.setVolunteerId(sqlRowSet.getInt("volunteer_id"));
        volunteer.setUserId(sqlRowSet.getInt("user_id"));
        volunteer.setFirstName(sqlRowSet.getString("first_name"));
        volunteer.setLastName(sqlRowSet.getString("last_name"));
        volunteer.setEmail(sqlRowSet.getString("email"));
        volunteer.setPhoneNumber(sqlRowSet.getString("phone_number"));
        volunteer.setZipCode(sqlRowSet.getString("zip_code"));
        volunteer.setApprovalStatus(sqlRowSet.getString("approval_status"));
        return volunteer;
    }
}

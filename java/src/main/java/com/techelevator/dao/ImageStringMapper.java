package com.techelevator.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class ImageStringMapper implements RowMapper<String> {
    @Override
    public String mapRow(ResultSet rs, int i) throws SQLException {
        byte[] imageData = rs.getBytes("image_data");

        // Convert byte array to Base64-encoded string
        String imageDataString = Base64.getEncoder().encodeToString(imageData);
        return imageDataString;
    }
}

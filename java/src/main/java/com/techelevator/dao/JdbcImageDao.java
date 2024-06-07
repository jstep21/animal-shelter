package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ImageByteArray;
import com.techelevator.model.ImageUrl;
import com.techelevator.model.Pet;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcImageDao implements ImageDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcImageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ImageUrl> getAllImages() {
        List<ImageUrl> imageUrls = new ArrayList<>();
        String sql = "SELECT image_id, image_url FROM images;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                ImageUrl imageUrl = mapRowToImageUrl(results);
                imageUrls.add(imageUrl);
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Data problems");
        }
        return imageUrls;
    }

    @Override
    public Integer saveImage(MultipartFile file) {
        String sql = "INSERT INTO images" +
                "(image_data, file_name) " +
                "VALUES (?, ?) " +
                "RETURNING image_id;";

        int newImageId = -1;
        try {
            newImageId = jdbcTemplate.queryForObject(sql, Integer.class,
                    file.getBytes(),
                    file.getOriginalFilename());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect", e);
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
            throw new DaoException("Data integrity violation", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newImageId;
    }

    public String getImageDataStringById(int id) {
        String sql = "SELECT * FROM images WHERE image_id = ?;";
        try {
            return jdbcTemplate.queryForObject(sql, new ImageStringMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private ImageUrl mapRowToImageUrl(SqlRowSet sqlRowSet) {
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setImageId(sqlRowSet.getInt("image_id"));
        imageUrl.setImageUrl(sqlRowSet.getString("image_url"));
        return imageUrl;
    }
}


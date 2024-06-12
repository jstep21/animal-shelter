package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ImageByteArray;
import com.techelevator.model.ImageUrl;
import com.techelevator.model.Pet;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.awt.*;
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
    public Integer saveImage(MultipartFile file, int petId) {
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

    public List<String> getImageDataStringById(int id) {
        List<String> images = new ArrayList<>();
        List<Integer> image_ids = new ArrayList<>();
        String sqlForImageIds = "SELECT image_id FROM images WHERE pet_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sqlForImageIds, id);
            while (results.next()) {
                int imageId = results.getInt("image_id");
                if (!results.wasNull()) {
                    image_ids.add(imageId);
                }
            }
        } catch (CannotGetJdbcConnectionException e) {
            System.out.println("Problem connecting");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Data problems");
        }
        for (Integer image_id : image_ids) {
            String sql = "SELECT * FROM images WHERE image_id = ?;";
            try {
                String imageData = jdbcTemplate.queryForObject(sql, new ImageStringMapper(), image_id);
                if (imageData != null) {
                    images.add("data:image/jpg;base64, " + imageData);
                }
            } catch (EmptyResultDataAccessException e) {
                System.out.println(e.getMessage());
            } catch (DataAccessException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
//                System.out.println(e.getMessage());
            }
        }
        return images;
    }

    private ImageUrl mapRowToImageUrl(SqlRowSet sqlRowSet) {
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setImageId(sqlRowSet.getInt("image_id"));
        imageUrl.setImageUrl(sqlRowSet.getString("image_url"));
        return imageUrl;
    }
//    private ImageByteArray mapRowToImageByteArray(SqlRowSet sqlRowSet) {
//        ImageByteArray imageByteArray = new ImageByteArray();
//        imageByteArray.setImageId(sqlRowSet.getInt("image_id"));
//        imageByteArray.setImageFilename(sqlRowSet.getString("file_name"));
//        imageByteArray.setByteData(sqlRowSet.getByte("image_data"));
//        return imageByteArray;
//    }
}


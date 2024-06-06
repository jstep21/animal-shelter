package com.techelevator.dao;

import com.techelevator.model.ImageUrl;
import com.techelevator.model.Pet;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
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
    public void updateImages(String fileName, byte[] byteData) {
        String sql = "UPDATE images SET image_data = ?, file_name = ?;";
        jdbcTemplate.update(sql, )
    }

    private ImageUrl mapRowToImageUrl(SqlRowSet sqlRowSet) {
        ImageUrl imageUrl = new ImageUrl();
        imageUrl.setImageId(sqlRowSet.getInt("image_id"));
        imageUrl.setImageUrl(sqlRowSet.getString("image_url"));
        return imageUrl;
    }
}


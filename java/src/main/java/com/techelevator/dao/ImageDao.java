package com.techelevator.dao;

import com.techelevator.model.ImageUrl;
import com.techelevator.model.Pet;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageDao {
    public List<ImageUrl> getAllImages();
    public Integer saveImage(MultipartFile file, int petId);
    public String getImageDataStringById(int id);
}

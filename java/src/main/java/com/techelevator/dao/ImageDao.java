package com.techelevator.dao;

import com.techelevator.model.ImageUrl;
import com.techelevator.model.Pet;

import java.util.List;

public interface ImageDao {
    public List<ImageUrl> getAllImages();
    public void updateImages(String fileName, byte[] byteData);
}

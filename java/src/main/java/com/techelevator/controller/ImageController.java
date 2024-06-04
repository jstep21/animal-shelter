package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ImageUrl;
import com.techelevator.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ImageController {
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/all-images", method = RequestMethod.GET)
    public String getAllImages(@RequestBody ImageUrl image) {
        try {
            imageService.getAllImages();
            return "All images retrieved successfully";
        } catch (Exception e) {
            return "Failed to retrieve all images: " + e.getMessage();
        }
    }
}

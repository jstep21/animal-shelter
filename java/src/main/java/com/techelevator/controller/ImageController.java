package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ImageUrl;
import com.techelevator.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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
    public String getAllImages() {
        try {
            imageService.getAllImages();
            return "All images retrieved successfully";
        } catch (Exception e) {
            return "Failed to retrieve all images: " + e.getMessage();
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam int petId) {
        System.out.println(file);
        try {
            imageService.saveImage(file, petId);
            String message = "File saved successfully";
            System.out.println(message);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            String errorMessage = "An error occurred";
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path="/retrieve-images", method = RequestMethod.GET)
    public List<String> retrieveImagesById(@RequestParam int petId) {
        try {
            return  imageService.retrieveImagesById(petId);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            return null;
        }
    }
}

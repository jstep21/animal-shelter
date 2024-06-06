package com.techelevator.service;

import com.techelevator.dao.ImageDao;
import com.techelevator.model.ImageUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    RestTemplate restTemplate = new RestTemplate();
    private ImageDao imageDao;

    public ImageService(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public List<ImageUrl> getAllImages(){
        return imageDao.getAllImages();
    }


    public Integer saveImage(MultipartFile file) {
        return imageDao.saveImage(file);
    }

}

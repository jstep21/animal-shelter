package com.techelevator.model;

//CREATE TABLE image (
//        image_id SERIAL PRIMARY KEY,
//        image_filename  VARCHAR(200) NOT NULL,
//        image_data BYTEA NOT NULL
//        );

public class ImageByteArray {
    private int imageId;
    private String imageFilename;
    private String imageString;

    public ImageByteArray(int imageId, String imageFilename, String imageString) {
        this.imageId = imageId;
        this.imageFilename = imageFilename;
        this.imageString = imageString;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public String getImageString() {
        return imageString;
    }

    public void setImageString(String imageString) {
        this.imageString = imageString;
    }
}

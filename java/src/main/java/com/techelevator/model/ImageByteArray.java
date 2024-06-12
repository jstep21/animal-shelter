package com.techelevator.model;

//CREATE TABLE image (
//        image_id SERIAL PRIMARY KEY,
//        image_filename  VARCHAR(200) NOT NULL,
//        image_data BYTEA NOT NULL
//        );

public class ImageByteArray {
    private int imageId;
    private String imageFilename;
    private byte[] byteData;

    public ImageByteArray() {
    }

    public ImageByteArray(int imageId, String imageFilename, byte[] byteData) {
        this.imageId = imageId;
        this.imageFilename = imageFilename;
        this.byteData = byteData;
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

    public byte[] getByteData() {
        return byteData;
    }

    public void setByteData(byte[] byteData) {
        this.byteData = byteData;
    }
}

package com.techelevator.model;

import java.util.Objects;

public class ImageUrl {
    private int imageId;
    private String imageUrl;

    public ImageUrl(int imageId, String imageUrl) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
    }
    public ImageUrl() {}

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageUrl imageUrl1 = (ImageUrl) o;
        return imageId == imageUrl1.imageId && Objects.equals(imageUrl, imageUrl1.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, imageUrl);
    }

    @Override
    public String toString() {
        return "ImageUrl{" +
                "imageId=" + imageId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

package com.example.puza.saltcave.model;

/**
 * Created by Lincoln on 18/05/16.
 */
public class GalleryItem {
    private int thumbnail;

    public GalleryItem() {
    }

    public GalleryItem(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

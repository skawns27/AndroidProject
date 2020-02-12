package com.skawns27.newsapp;
import java.io.Serializable;

public class NewData implements Serializable {//데이터 직렬화->데이터를 byte 단위로 나눔
    private String title;
    private String urlToImage;
    private String description;

    public void setTitle(String title) {
        this.title = title;
    }


    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }


    public String getUrlToImage() {
        return urlToImage;
    }

    public String getDescription() {
        return description;
    }
}

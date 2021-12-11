package com.example.decoratar.model;

public class FurnitureData {
    private String name;
    private int URL;
    private String link;

    public FurnitureData(String name,int url,String link) {
        this.name = name;
        this.URL = url;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getURL() {
        return URL;
    }

    public void setURL(int URL) {
        this.URL = URL;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

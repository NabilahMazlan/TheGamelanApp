package com.example.gamelannagakencana;

public class AnnouncementClass {
    private int imageview;
    private String title, desc;

    public AnnouncementClass(int imageview, String title, String desc) {
        this.imageview = imageview;
        this.title = title;
        this.desc = desc;
    }

    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

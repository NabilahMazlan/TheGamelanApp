package com.example.gamelannagakencana;

public class Video {

    private int image;
    private String title;
    private String group;
    private Double timeline;

    public Video(int image, String title, String group, Double timeline) {
        this.image = image;
        this.title = title;
        this.group = group;
        this.timeline = timeline;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Double getTimeline() {
        return timeline;
    }

    public void setTimeline(Double timeline) {
        this.timeline = timeline;
    }
}

package com.example.gamelannagakencana;

public class CommentClass {
    private String name;
    private String comments;

    public CommentClass(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return  name + "\n" + comments;
    }
}

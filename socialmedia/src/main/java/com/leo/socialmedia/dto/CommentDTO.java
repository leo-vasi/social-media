package com.leo.socialmedia.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {
    private String text;
    private Date date;
    private AuthorDTO author;

    public CommentDTO() {

    }

    public CommentDTO(AuthorDTO author, Date date, String text) {
        this.author = author;
        this.date = date;
        this.text = text;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package com.app.imagine_images_ms.entity;


import java.util.ArrayList;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    private String name;
    @Column(length = 50)
    private String description;

    private ArrayList<String> tags;
    @Column(nullable = false)
    private String ownerId;

    private ArrayList<String> commentsId;
    @Column(nullable = false)
    private String imageStorageId;
    @Column(nullable = false)
    private String url;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public ArrayList<String> getCommentsId() {
        return this.commentsId;
    }

    public void setCommentsId(ArrayList<String> commentsId) {
        this.commentsId = commentsId;
    }

    public String getImageStorageId() {
        return this.imageStorageId;
    }

    public void setImageStorageId(String imageStorageId) {
        this.imageStorageId = imageStorageId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

package com.app.imagine_images_ms.entity;

import java.net.URL;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(length = 50)
    private String description;
    private String tag;
    @Column(nullable = false)
    private Long ownerId;

    private ArrayList<Long> commentsId;
    @Column(nullable = false)
    private Long imageStorageId;
    @Column(nullable = false)
    private URL url;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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


    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    

    public Long getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public ArrayList<Long> getCommentsId() {
        return this.commentsId;
    }

    public void setCommentsId(ArrayList<Long> commentsId) {
        this.commentsId = commentsId;
    }

    public Long getImageStorageId() {
        return this.imageStorageId;
    }

    public void setImageStorageId(Long imageStorageId) {
        this.imageStorageId = imageStorageId;
    }

    public URL getUrl() {
        return this.url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

}

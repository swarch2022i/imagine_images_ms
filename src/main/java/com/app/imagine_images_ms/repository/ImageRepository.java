package com.app.imagine_images_ms.repository;


import java.util.ArrayList;
import java.util.Optional;

import com.app.imagine_images_ms.entity.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,String> {
    
    ArrayList<Image> findByName(String name);

    Optional<Image> findByImageStorageId(String imageId);

    ArrayList<Image> findByOwnerId(String id);


}

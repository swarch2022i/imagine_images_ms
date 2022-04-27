package com.app.imagine_images_ms.repository;


import java.util.ArrayList;


import com.app.imagine_images_ms.entity.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    
    ArrayList<Image> findByName(String name);

    ArrayList<Image> findByOwnerId(String id);

}

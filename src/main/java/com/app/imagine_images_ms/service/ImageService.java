package com.app.imagine_images_ms.service;


import java.util.ArrayList;
import java.util.Optional;


import com.app.imagine_images_ms.entity.Image;
import com.app.imagine_images_ms.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageService  {

    @Autowired
    private ImageRepository imageRepository;

    @Transactional(readOnly = true)
    public Iterable<Image> findAll() {

        return imageRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Image> findById(Long id) {

        return imageRepository.findById(id);
    }

    @Transactional
    public Image save(Image image) {

        return imageRepository.save(image);
    }

    @Transactional(readOnly = true)
    public void deleteById(long id) {
        imageRepository.deleteById(id);

    }

    @Transactional(readOnly = true)
    public ArrayList<Image> findByName(String name) {
        return imageRepository.findByName(name);

    }



    @Transactional
    public ArrayList<Image> findByOwnerId(String id) {
        return imageRepository.findByOwnerId(id);

    }

}

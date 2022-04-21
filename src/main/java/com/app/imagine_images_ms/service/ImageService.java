package com.app.imagine_images_ms.service;

import java.util.Optional;

import com.app.imagine_images_ms.entity.Image;

public interface ImageService {

    public Iterable<Image> findAll();

    public Optional<Image> findById(Long id);

    public Image save(Image image);

    public void deleteById(long id);

    
}

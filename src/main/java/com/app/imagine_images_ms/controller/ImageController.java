package com.app.imagine_images_ms.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.app.imagine_images_ms.entity.Image;
import com.app.imagine_images_ms.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageServiceImpl;

    
    
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Image image){
        return ResponseEntity.status(HttpStatus.CREATED).body(imageServiceImpl.save(image));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long imageId){
        Optional<Image> oImage = imageServiceImpl.findById(imageId);

        if(!oImage.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oImage);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update (@RequestBody Image imageDetails, @PathVariable(value = "id") Long imageId){
        Optional<Image> image = imageServiceImpl.findById(imageId);

        if(!image.isPresent()){
            return ResponseEntity.notFound().build();
        }
        image.get().setName(imageDetails.getName());
        image.get().setDescription(imageDetails.getDescription());
        //image.get().setOwnTags(imageDetails.getOwnTags());
        image.get().setOwnerId(imageDetails.getOwnerId());
        image.get().setCommentsId(imageDetails.getCommentsId());
        image.get().setImageStorageId(imageDetails.getImageStorageId());
        image.get().setUrl(imageDetails.getUrl());

        return ResponseEntity.status(HttpStatus.CREATED).body(imageServiceImpl.save(image.get()));

        

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value = "id") Long imageId){
        if(!imageServiceImpl.findById(imageId).isPresent()){
            return ResponseEntity.notFound().build();
        }

        imageServiceImpl.deleteById(imageId);
        return ResponseEntity.ok().build();
        
    }


    @GetMapping
    public ResponseEntity<List<Image>> readAll() {
        List<Image> images = StreamSupport.stream(imageServiceImpl.findAll().spliterator(), false).collect(Collectors.toList());
        return ResponseEntity.ok(images);

    }

    //Buscar por nombre

    @GetMapping("/names/{name}")
    public ResponseEntity<ArrayList<Image>> readByName (@PathVariable(value = "name") String imageName){
        ArrayList<Image> oImage = imageServiceImpl.findByName(imageName);

        if(oImage.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oImage);
    }

    //Buscar por tags

    @GetMapping("/tags/{tag}")
    public ResponseEntity<ArrayList<Image>> readByTag (@PathVariable(value = "tag") String imageTag){
        List<Image> imagesI = StreamSupport.stream(imageServiceImpl.findAll().spliterator(), false).collect(Collectors.toList());
        ArrayList<Image> imagesF = new ArrayList<>();
        for(int i = 0; i < imagesI.size();i++){
            if(imagesI.get(i).getTags().contains(imageTag)){
                imagesF.add(imagesI.get(i));
            }

            }
        
        return ResponseEntity.ok(imagesF);
    }

    //Buscar por Dueño

    @GetMapping("/people/{id}")
    public ResponseEntity<ArrayList<Image>> readByOwnerId (@PathVariable(value = "id") String OwnerId){
        ArrayList<Image> oImage = imageServiceImpl.findByOwnerId(OwnerId);

        if(oImage.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oImage);
    }
    
}

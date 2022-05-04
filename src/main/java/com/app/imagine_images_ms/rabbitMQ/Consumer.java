package com.app.imagine_images_ms.rabbitMQ;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.app.imagine_images_ms.entity.Image;
import com.app.imagine_images_ms.service.ImageService;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.json.*;

@Component
public class Consumer {

    @Autowired
    private ImageService imageServiceImpl;

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(Message originalMessage) {

        

        // Pasando el mensaje de buffer a string
        String stringMessage = new String(originalMessage.getBody(), StandardCharsets.UTF_8);
        // Conviertiendo el string a un json
        JSONObject jsonMessage = new JSONObject(stringMessage);
        // Sacando el json de la información que necesito (el primer json solo tiene de
        // atributo "message", todos mis datos estan dentro de message)
        JSONObject json = jsonMessage.getJSONObject("message");
        // Creando la imagen para usarla despues
        Image image = new Image();
        // Asignando atributos, puedo aceptar valores vacios pero tienen que llegar esos
        // campos, si no llegan pos muere, hacer control de ese error luego :v
        String name;
        String description;
        ArrayList<String> tags = new ArrayList<>();
        String ownerId;
        ArrayList<String> commentsId = new ArrayList<>();
        String imageStorageId;
        String url;

        name = json.getString("name");
        description = json.getString("description");
        ownerId = json.getString("ownerId");
        imageStorageId = json.getString("imageStorageId");
        url = json.getString("url");

        JSONArray tagsJSON = json.getJSONArray("tags");
        JSONArray commentsIdJSON = json.getJSONArray("commentsId");
  
        for (int i = 0; i < tagsJSON.length(); i++) {
            tags.add(tagsJSON.getString(i));
        }

        for (int i = 0; i < commentsIdJSON.length(); i++) {
            commentsId.add(commentsIdJSON.getString(i));
        }

        image.setName(name);
        image.setDescription(description);
        image.setTags(tags);
        image.setOwnerId(ownerId);
        image.setCommentsId(commentsId);
        image.setImageStorageId(imageStorageId);
        image.setUrl(url);
        
        
        imageServiceImpl.save(image);

        
    }

}
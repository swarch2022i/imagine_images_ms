FROM openjdk:11
COPY target/imagine_images_ms-0.0.1-SNAPSHOT.jar imagine_images_ms.jar 
EXPOSE 8080
ENTRYPOINT ["java","-jar","imagine_images_ms.jar"]

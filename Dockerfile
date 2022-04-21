#FROM maven:3.6.3-openjdk-14-slim AS build 
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package

#FROM openjdk:14-alpine
#COPY --from=build "home/app/target/imagine_images_ms-0.0.1-SNAPSHOT.jar" "app.jar"




FROM openjdk:11
COPY target/imagine_images_ms-0.0.1-SNAPSHOT.jar sprinboot-docker-demo.jar 

ENV SPRING_DATASOURCE_URL=jdbc:mysql://172.17.0.2:3306/db_prueba
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=1234
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update
ARG URL=0.0.0.0:8080
ENTRYPOINT ["java","-jar","sprinboot-docker-demo.jar"]
#ENTRYPOINT ["java","-jar","app.jar"]
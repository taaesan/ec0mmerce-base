FROM openjdk:8u181-jdk-slim

MAINTAINER PARNRAWEE PHUMKHEM "taaesan@gmail.com"

EXPOSE 8080

COPY ./build/libs/e-commerce-service*.jar e-commerce-service.jar

CMD ["java", "-Dspring.profiles.active=docker", "-jar", "e-commerce-service.jar"]

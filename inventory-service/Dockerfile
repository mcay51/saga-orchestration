FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar /app/inventory-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/inventory-service.jar"]
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar /app/payment-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/payment-service.jar"]

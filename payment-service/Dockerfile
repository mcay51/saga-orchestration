FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/payment-service.jar payment-service.jar
ENTRYPOINT ["java","-jar","/payment-service.jar"]

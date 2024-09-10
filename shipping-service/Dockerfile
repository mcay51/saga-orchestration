FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/shipping-service.jar shipping-service.jar
ENTRYPOINT ["java","-jar","/shipping-service.jar"]

FROM maven:3.8.6-openjdk-11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gateway-service-1.0.0.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gateway-service-1.0.0.jar"]
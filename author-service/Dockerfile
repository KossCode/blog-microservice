#
# Build stage
#
#FROM maven:3.6.0-jdk-11-slim AS Build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
##
## Package stage
##
#FROM openjdk:11-jre-slim
#COPY --from=build /home/app/target/*.jar /usr/local/lib/author-service.jar
#ENTRYPOINT ["java","-jar","/usr/local/lib/author-service.jar"]

FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} author-service-1.0.0.jar
ENTRYPOINT ["java", "-jar", "author-service-1.0.0.jar"]
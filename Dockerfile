FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/embl-fire-api-1.0-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} embl-fire-api-1.0-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","embl-fire-api-1.0-SNAPSHOT.jar"]

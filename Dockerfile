FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/chat-0.0.1-SNAPSHOT.jar /app/chat-application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "chat-application.jar"]
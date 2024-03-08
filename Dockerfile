FROM openjdk:17
ARG JAR_FILE=./target/*.jar
EXPOSE 8080
COPY ./target/websocket.jar /home/run/app.jar
ENTRYPOINT ["java","-jar","/home/run/app.jar"]
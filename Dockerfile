FROM openjdk:8

VOLUME /tmp

ARG DEPENDENCY=build/libs
RUN apt-get update -y
RUN apt-get install -y redis-server

ARG JAR_FILE=build/libs/rivalchess-vie-generator-1.0.0.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]


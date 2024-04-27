FROM openjdk:17-jdk

LABEL author.name="Aniket Pandey"

EXPOSE 8080

ARG JAR_FILE=./target/survey-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} .

CMD [ "java", "-jar",  "/survey-0.0.1-SNAPSHOT.jar"]
FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN mvn clean install
CMD mvn spring-boot:run
ENTRYPOINT ["java","-jar","/app.jar"]



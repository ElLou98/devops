FROM openjdk:8
RUN wget -P ~/var "192.168.1.50:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar"
ARG JAR_FILE= ~/var/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



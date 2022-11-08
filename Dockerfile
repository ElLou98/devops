FROM openjdk:8
RUN wget -P /var/lib/jenkins/workspace/DevopsPipeLine/nexus "192.168.1.50:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar"
ARG JAR_FILE=nexus/*.jar
COPY --from= /var/lib/jenkins/workspace/DevopsPipeLine/nexus/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



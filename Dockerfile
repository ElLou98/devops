FROM openjdk:8
RUN curl -u admin:Mimi2021! -o tpAchatProject-1.0.jar "172.10.0.140:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
COPY /var/lib/jenkins/workspace/DevopsPipeLine/tpAchatProject-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



FROM openjdk:8
RUN curl -u admin:minamoreasma98 -o tpAchatProject-1.0.jar "172.10.0.140:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
COPY ~/tpAchatProject-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
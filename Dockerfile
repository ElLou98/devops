FROM openjdk:8
RUN curl -u admin:minamoreasma98 -o tpAchatProject-1.0.jar "172.10.0.140:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
ARG JAR_FILE = tpAchatProject-1.0.jar 
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
FROM openjdk:11-jre-slim
ADD /target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]

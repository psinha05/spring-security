FROM openjdk:8-jdk-alpine
ADD target/user-mgt.jar user-mgt.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","user-mgt.jar"]
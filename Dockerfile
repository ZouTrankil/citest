FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD build/libs/citest.jar citest.jar
ENTRYPOINT ["java","-jar","citest.jar"]
EXPOSE 8888
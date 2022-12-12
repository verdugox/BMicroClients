FROM openjdk:11
VOLUME /tmp
EXPOSE 9043
ADD ./target/Clients-0.0.1-SNAPSHOT.jar ms-clients.jar
ENTRYPOINT ["java", "-jar","/ms-clients.jar"]


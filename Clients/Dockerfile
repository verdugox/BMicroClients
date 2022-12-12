FROM openjdk:11
VOLUME /tmp
EXPOSE 9040
ADD ./target/Clients-0.0.1-SNAPSHOT.jar ms-clients.jar
ENTRYPOINT ["java", "-jar","/ms-clients.jar"]


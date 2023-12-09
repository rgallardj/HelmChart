FROM openjdk:11
VOLUME [ "/tmp" ]
EXPOSE 8020
ADD ./target/user-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT [ "java", "-jar", "/user.jar" ]
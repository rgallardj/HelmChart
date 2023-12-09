FROM openjdk:11
VOLUME [ "/tmp" ]
EXPOSE 8093
ADD ./target/gestion_horario-0.0.1-SNAPSHOT.jar gestion_horario.jar
ENTRYPOINT [ "java", "-jar", "/gestion_horario.jar" ]
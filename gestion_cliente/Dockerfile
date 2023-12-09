FROM openjdk:11
VOLUME [ "/tmp" ]
EXPOSE 8092
ADD ./target/gestion_cliente-0.0.1-SNAPSHOT.jar gestion_cliente.jar
ENTRYPOINT [ "java", "-jar", "/gestion_cliente.jar" ]

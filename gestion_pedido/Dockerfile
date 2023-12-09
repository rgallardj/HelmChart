FROM openjdk:11
VOLUME [ "/tmp" ]
EXPOSE 8091
ADD ./target/gestion_pedido-0.0.1-SNAPSHOT.jar gestion_pedido.jar
ENTRYPOINT [ "java", "-jar", "/gestion_pedido.jar" ]

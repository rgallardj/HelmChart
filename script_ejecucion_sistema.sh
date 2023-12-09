#!/bin/bash 

# Ejecutar eureka-server  (puerto 8090)
cd eureka-server
pwd
start mvn spring-boot:run
cd ..

# Ejecutar config_server-(puerto 8001)
sleep 5
cd config_server
pwd
start mvn spring-boot:run
cd ..

# Ejecutar gestion_cliente-(puerto 8093)
sleep 5
cd gestion_cliente
pwd
start mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8093 &
start mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8094 &
cd ..

# Ejecutar gestion_pedido (puerto 8091)
sleep 5
cd gestion_pedido
pwd
start mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8091 &
start mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8092 &
cd ..

# Ejecutar gestion_horario (puerto 8093)
sleep 5
cd gestion_horario
pwd
start mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8095 &
start mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8096 &
cd ..

# Ejecutar user (puerto 8020)
sleep 5
cd user
pwd
start mvn spring-boot:run
cd ..

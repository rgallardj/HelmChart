#!/bin/bash

# Pruebas para CLIENTES
echo "Pruebas para CLIENTES:"
curl -X GET http://localhost:8020/clientes
sleep 2
curl -X GET http://localhost:8020/cliente/1
sleep 2
curl -X GET http://localhost:8020/cliente/2
sleep 2
# Separador
echo "---------------------------------------------"

# Pruebas para PEDIDOS
echo "Pruebas para PEDIDOS:"
curl -X GET http://localhost:8020/pedidos
sleep 2
curl -X GET http://localhost:8020/pedidos/1
sleep 2
curl -X GET http://localhost:8020/pedidos/2
sleep 2
curl -X DELETE http://localhost:8020/pedidos/1
sleep 2
# Separador
echo "---------------------------------------------"

# Pruebas para HORARIOS
echo "Pruebas para HORARIOS:"
curl -X GET http://localhost:8020/horarios
sleep 2
curl -X GET http://localhost:8020/horario/1
sleep 2
curl -X GET http://localhost:8020/horario/2
sleep 2
curl -X DELETE http://localhost:8020/horario/1
sleep 2
curl -X DELETE http://localhost:8020/horario/2
sleep 2

# Separador
echo "---------------------------------------------"

# Pruebas desde CLIENTE a PEDIDO
echo "Pruebas desde CLIENTE a PEDIDO:"
curl -X GET http://localhost:8093/pedidos/2
curl -X GET http://localhost:8094/pedidos/2

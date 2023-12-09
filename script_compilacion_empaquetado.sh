#!/bin/bash

# Script para ejecutar `mvn clean package` en varios proyectos

# Lista de proyectos
proyectos=("config_server" "eureka-server" "gestion_cliente" "gestion_horario" "gestion_pedido" "user")

# Ruta al directorio principal que contiene los proyectos
directorio_principal="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# Iterar sobre la lista de proyectos y ejecutar mvn clean package
for proyecto in "${proyectos[@]}"
do
    # Construir la ruta completa al directorio del proyecto
    ruta_proyecto="$directorio_principal/$proyecto"

    # Cambiar al directorio del proyecto
    cd "$ruta_proyecto" || exit

    # Ejecutar mvn clean package
    echo "Compilando y empaquetando el proyecto $proyecto..."
    mvn clean package

    # Verificar el resultado de la compilación
    if [ $? -eq 0 ]; then
        echo "Proyecto $proyecto compilado y empaquetado con éxito."
    else
        echo "Error al compilar y empaquetar el proyecto $proyecto."
        # Puedes agregar acciones adicionales en caso de error, si es necesario
    fi

    # Regresar al directorio principal
    cd "$directorio_principal" || exit

    # Agregar separador para mayor claridad en la salida
    echo "--------------------------------------------"
done

echo "Todos los proyectos han sido compilados y empaquetados."

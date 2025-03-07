# Gestión de Empleados con Listas Doblemente Ligadas  

Este proyecto implementa un sistema de gestión de empleados utilizando listas doblemente ligadas en Java. Permite agregar, buscar, eliminar y ordenar empleados, además de calcular estadísticas sobre los salarios.  

## Descripción de los Archivos  

### `Empleado.java`  
Define la estructura de un empleado como un nodo de la lista doblemente ligada. Cada empleado tiene un **ID, nombre y salario**, además de referencias a los nodos anterior (`prev`) y siguiente (`next`).  

### `ListaDobleEmpleados.java`  
Implementa la lista doblemente ligada con las siguientes funcionalidades:  
- **Insertar empleados** manteniendo las referencias adecuadas.  
- **Buscar empleados** por ID.  
- **Eliminar empleados**, ajustando punteros para no afectar la estructura.  
- **Ordenar empleados** por nombre o salario.  
- **Calcular estadísticas** como salario promedio, máximo, mínimo y mediana.  
- **Imprimir la lista** de empleados.  

### `GestionEmpleados.java`  
Proporciona una interfaz de usuario mediante un **menú** que permite:  
1. Insertar empleados.  
2. Buscar empleados por ID.  
3. Eliminar empleados.  
4. Ordenar empleados por nombre o salario.  
5. Mostrar la lista de empleados.  
6. Ver estadísticas de salarios.  

## Ejecución  
El programa se ejecuta desde el archivo GestionEmpleados

## Dato Extra
Cuando se vaya a hacer el ordenamiento por nombre o por salario, se tiene que poner true si se quiere de forma ascendente y false si se quiere de forma descendente

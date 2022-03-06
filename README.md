# Carvajal

## Table of Contents
A. [General Info](#general-info)
B. [Technologies](#technologies)
C. [Installation](#installation)

### A.  General Info
***
La finalidad del proyecto es presentar una lista de opciones donde el ususario puede visualizar productos disponibles y agregar algunos de estos a una lista favorita
y poder realizar modificaciones de la misma.

Cuenta con 4 paquetes que contiene sus respectivas clases


1. com.carvajal.dao
    -[menu]--Contiene los metodos para el manejo de el menu de opciones.
    -[producto]-PLantilla de el objeto producto.
2. com.carvajal.dao.impl
    -[listaDeseoImpl]-Contiene los metodos para manipular los datos de la lista favoritos creada.
    -[productoImpl]-Manejo de los datos para los productos ofrecidos.
    -[registroImpl]-Contiene los metodos para llevar el histroial de los registros en favoritos.
3. com.carvajal.database
    -[conexion]-Establece la conexion con la base de datos.
4. com.carvajal.demo
    -[demoCrud]-Es la clase principal en donde se ejecuta la aplicacion.


### B. Technologies
***
A list of technologies used within the project:
* [Eclipse](https://www.eclipse.org/downloads/): 2021-09 (4.21.0) 
* [Xampp](https://www.apachefriends.org/es/download.html): Version 3.3.0
* [Library connection](https://mvnrepository.com/artifact/mysql/mysql-connector-java/5.1.15): Version 5.1.15
### C. Installation
***
* Clonar repositorio https://github.com/hernan0740/Carvajal.
* Establecer conexion con base de datos.
* Iniciar el entorno de Eclipse y ejecutar la clase principal [demoCrud].

## Connection
$db = "retocarvajal";
$login = "root";
$password = "";
$url = "jdbc:mysql://localhost/retocarvajal";
***
## Base de datos
* Nombre db:retocarvajal;
* Contiene las siguientes tablas:
* [productos]-id-nombre-precio-cantidad.
* [listadeseo]-id-idproducto-cantidad.
* [regproducto]-id-idproducto.


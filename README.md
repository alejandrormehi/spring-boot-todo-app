### To - do List para prueba técnica 

- Lenguajes usados: Java, Javascript, SQL, XML
- Frameworks: Spring Boot, Bootstrap
- Extras, ayudas: https://www.baeldung.com/ , https://www.danvega.dev/, https://www.pildorasinformaticas.es/, https://stackoverflow.com/, https://chatgpt.com/
- IDE utilizada: Eclipse
- Versión de Java: 17


# Read me

![](https://bgasparotto.com/wp-content/uploads/2017/12/spring-boot-logo.png)



**Tabla de contenidos**

[TOCM]

[TOC]
##Instalación

- Instalar IDE: Eclipse 
Seguir los pasos de: (https://www.youtube.com/watch?v=hasHQ3o8_is&ab_channel=Roelcode:// "Instalar ECLIPSE castellano")
- Primer paso de pull
[![Primer paso](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/1.png "Primer paso")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/1.png "Primer paso")

- Segundo paso 
[![Segundo paso](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/2.png "Segundo paso")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/2.png "Segundo paso")


- Tercer paso
[![3er Paso, seleccionar URL](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/3.png "3er Paso, seleccionar URL")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/3.png "3er Paso, seleccionar URL")

- Cuarto paso
[![4to paso, copiar link](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/4.png "4to paso, copiar link")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/4.png "4to paso, copiar link")

- Quinto paso
[![5to Paso](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/5.png "5to Paso")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/5.png "5to Paso")

- Sexto paso
[![6to paso](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/6.png "6to paso")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/6.png "6to paso")

- Último paso
[![Último paso](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/7.png "Último paso")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/7.png "Último paso")


## EJECUTAR PROGRAMA

Para ejecutar el programa sigue los siguientes pasos
- Primer paso
Selecciona el script que termine en "Application.java"
[![1er paso ejecucion](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/1eje.png "1er paso ejecucion")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/1eje.png "1er paso ejecucion")

-Segundo paso
Haz click en "Debug as" y luego la opcion 9 Spring Boot App.
Debug ayuda a encontrar fallos en el programa, a diferencia del tipico Run, sin embargo el rendimiento baja un poco....
[![2do paso](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/2eje.png "2do paso")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/2eje.png "2do paso")

-Último
Ahora podrás ver el To do list en tu navegador, en el puerto 8081, si lo tienes abierto con otra aplicacion, puedes cambiar el puerto en el script de ApplicationProperties de la carpeta resources
[![ultimo](https://raw.githubusercontent.com/alestar328/spring-boot-todo-app/main/spring-boot-todo-app/imagenes_ayuda/3eje.png "ultimo")](https://github.com/alestar328/spring-boot-todo-app/blob/main/spring-boot-todo-app/imagenes_ayuda/3eje.png "ultimo")


##Application properties
Aquí hemos configurado las propiedades de la aplicacion, tales como nombre, usuario, puerto, etc. Es muy importante desarrollarlo correctamente ya que muchos errores posteriores pueden ser causados por algun error de sintaxis en esta parte.
```java
spring.application.name=spring-boot-todo-app
server.port=8081

#setup local h2 database config
#spring.datasource.url=jdbc:h2:file:./data/demo
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=super3

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

#setup local h2 database config
spring.h2.console.enabled=true
spring.datasource.generate-unique-name=false
spring.datasource.name=To-do
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=false

#we put false so we dont need to refresh every time we make a change
spring.thymeleaf.cache=false
#help to indicate we want to regenerate internal structure
spring.jpa.hibernate.ddl-auto=update 
spring.jpa.show-sql=true
```
##Clases
Hemos desarrollado 3 clases User, TodoItem y Address. 
Importante, en la clase TodoItem colocar:
`	@GeneratedValue(strategy = GenerationType.IDENTITY)`
IDENTITY mas no AUTO. Esto evita que ocurrar un error al aplicarse la base de datos de ejemplo, ya que al inyectar los datos en las tablas, y posteriormente crear un To-do nuevo, este nuevo To-do puede tener la misma ID a uno ya creado, causando error.

##Controllers

En controllers se intentó aplicar la paginación de los To-do, pero por motivos de tiempo no se terminó a fecha de hoy 22/07/2024, sin embargo actualizaremos este proyecto.

En Homecontroller establecemos el controlador de la pagina principal y como actuará cuando manipulemos los To-do.

TodoFormController, tenemos todos los controladores de los to-do.
##Repositories

Hemos implementado una interface para  tratar a los To-do de manera más eficiente heredando de JpaRepository. Tambien creamos otro para manipular mejor a los Usuarios.
En el repositorio para los To-do, hemos añadido métodos especificos para mejorar la logica del programa.
##Services
En services, hemos dividido los servicios en 2 scrips, uno para los To-do y otro para los User
##Resources
Usamos principalmente templates para las vistas...
Hemos usado para el estilo, el framework Bootstrap y varias vistas para el programa.

Tambien creamos un script SQL para crear una base de datos ficticia de pruebas. Mucho ojo con esto, ya que causó muchos problemas la ordenacion de los datos y su direccion a traves del template.


###End

## Paso preliminar:
* Desde la raiz del proyecto dirigirse a `src/main/resources`, en application.yml eliminar la linea 19.
* Siguiendo en application.yml cambiar la url de datasource de `jdbc:postgresql://localhost:5432/supportdb` a `jdbc:postgresql://localhost:5432/support_db`
* Cambiar username a: `soporte_user`
* Cambiar password a: `soporte_pass`
* Abrir una terminal en la raiz del proyecto.
* Abrir docker desktop o iniciar el servicio de docker.
  

## Primero se debe empaquetar el proyecto
* Desde la terminal abierta previamente ejecutar (Windows 11): `.\mvnw clean package -DskipTests`

## Luego se debe levantar los contenedores en 2 pasos para garantizar que existe la Base de Datos antes que la API
- `docker-compose up -d postgres`
- `docker-compose up app`


## Verificar que todo corra correctamente
-Backend en: http://localhost:8181
-Base de datos PostgreSQL en: localhost:5432


## Probar la API con Postman

```Crear usuario
POST http://localhost:8181/api/users
{
"nombre": "Gaby Valiente",
"correo": "Gaby@example.com",
"password": "admin123",
"nombreRol": "USER"
}```

Crear técnico
POST http://localhost:8181/api/users

{
"nombre": "Soporte Técnico",
"correo": "soporte@example.com",
"password": "admin123",
"nombreRol": "TECH"
}

Crear ticket
POST http://localhost:8181/api/tickets
{
"titulo": "Problema con login",
"descripcion": "No puedo iniciar sesión",
"estado": "ABIERTO",
"correoUsuario": "Gaby@example.com",
"correoSoporte": "soporte@example.com"
}

Url para obtener todos los usuarios de la base de datos
http://localhost:8181/api/users/all 

Url para obtener todos los tickets de la base de datos
http://localhost:8181/api/tickets
```



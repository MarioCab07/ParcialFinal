##Primero se debe empaquetar el proyecto
mvn clean package

##Luego se debe levantar los contenedores
docker-compose up --build

##Verificar que todo corra correctamente
Backend en: http://localhost:8181
Base de datos PostgreSQL en: localhost:5432

#Application.yml
Se espera que para el password se coloque como admin
##Probar la API con Postman

Crear usuario
POST http://localhost:8181/api/users
{
"nombre": "Gaby Valiente",
"correo": "Gaby@example.com",
"password": "admin123",
"nombreRol": "USER"
}

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


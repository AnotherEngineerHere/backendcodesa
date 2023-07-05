# Aplicación del Backend

## Instrucciones para Ejecutar

Para ejecutar el proyecto tienes dos opciones:

1. Descargar o clonar el repositorio y ejecutarlo usando STS o cualquier otro IDE de Java de tu preferencia.

2. Ejecutar "docker-compose up".

El backend estará en funcionamiento en el puerto 8090 de manera predeterminada.

## Manual de API

### UsuarioController:

- Obtener usuario por ID: `GET /usuarios/{idUsuario}`
- Mostrar todos los usuarios: `GET /usuarios/`
- Buscar usuarios por nombre: `GET /usuarios?nombre={nombre}`
- Crear usuario: `POST /usuarios`
- Actualizar usuario por ID: `PUT /usuarios/{idUsuario}`
- Eliminar usuario por ID: `DELETE /usuarios/{idUsuario}`

### RolController:

- Obtener todos los roles: `GET /rol`

Tecnologías utilizadas:
- Java
- Spring Boot
- RESTful API
- Maven
- Postgress
- React (para el frontend) En progreso

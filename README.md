# API Foro - Proyecto de Spring Boot

## Descripción
Este proyecto es una API REST desarrollada con Spring Boot que permite gestionar un foro. Incluye funcionalidades de autenticación con JWT y operaciones CRUD para tópicos de discusión. Utiliza MySQL como base de datos relacional.

---

## Requisitos

- **Java 17** o superior
- **Maven 3.8+**
- **MySQL**
- **Insomnia/Postman** para probar la API

---

## Configuración del Entorno

1. **Base de datos**:
   - Crea una base de datos llamada `apiforo` (puedes usar el comando: `CREATE DATABASE apiforo;`).

2. **Archivo `application.properties`**:
   Configura las credenciales de la base de datos y otros ajustes necesarios:
   ```properties
   spring.application.name=api
   spring.datasource.url=jdbc:mysql://localhost:3306/apiforo?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=root
   hibernate.dialect=org.hibernate.dialect.MySQLDialect

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true

   logging.level.org.springframework.security=DEBUG

   api.security.secret=${JWT_SECRET:123456}
   ```

3. **Dependencias Maven**:
   Este proyecto utiliza las siguientes dependencias principales:
   - Spring Web
   - Spring Security
   - Spring Data JPA
   - MySQL Driver
   - JWT
   Asegúrate de que tu archivo `pom.xml` esté correctamente configurado.

4. **Inicializa el Proyecto**:
   - Ejecuta `mvn spring-boot:run` desde la raíz del proyecto.
   - La API estará disponible en `http://localhost:8080`.

---

## Endpoints Disponibles

### Autenticación
1. **Iniciar sesión**
   - **POST** `/login`
   - **Body**:
     ```json
     {
       "username": "usuario",
       "password": "contraseña"
     }
     ```
   - **Respuesta**:
     ```json
     {
       "token": "<JWT_TOKEN>"
     }
     ```

### Gestión de Tópicos
2. **Listar tópicos**
   - **GET** `/topicos`
   - **Headers**:
     ```
     Authorization: Bearer <JWT_TOKEN>
     ```
   - **Respuesta**:
     ```json
     [
       {
         "id": 1,
         "titulo": "Título del tópico",
         "mensaje": "Mensaje del tópico"
       }
     ]
     ```

3. **Crear un nuevo tópico**
   - **POST** `/topicos`
   - **Headers**:
     ```
     Authorization: Bearer <JWT_TOKEN>
     ```
   - **Body**:
     ```json
     {
       "titulo": "Nuevo Tópico",
       "mensaje": "Contenido del tópico"
     }
     ```

4. **Actualizar un tópico**
   - **PUT** `/topicos/{id}`
   - **Headers**:
     ```
     Authorization: Bearer <JWT_TOKEN>
     ```
   - **Body**:
     ```json
     {
       "titulo": "Título actualizado",
       "mensaje": "Mensaje actualizado"
     }
     ```

5. **Eliminar un tópico**
   - **DELETE** `/topicos/{id}`
   - **Headers**:
     ```
     Authorization: Bearer <JWT_TOKEN>
     ```

---

## Seguridad
- La API está protegida mediante **JSON Web Tokens (JWT)**.
- Configura la clave secreta en `application.properties` usando la variable `api.security.secret`.

---

## Estructura del Proyecto

```plaintext
src/main/java
├── apiForo2.api
   ├── ApiApplication.java       # Clase principal de la aplicación
   ├── controllers
   │   └── TopicosController.java
   ├── models
   │   └── Topico.java
   ├── repositories
   │   └── TopicoRepository.java
   ├── security
   │   ├── SecurityConfigurations.java
   │   └── JwtUtils.java
   └── services
       └── TopicoService.java
```

---

## Pruebas
Para probar la API, puedes usar Insomnia o Postman. Asegúrate de enviar el token JWT en los encabezados de las solicitudes.

Creando el token para poder ingresar al aplicativo:
![image](https://github.com/user-attachments/assets/61f8a07b-ec65-4f06-985e-7b849b37e4d5)

Registro de topico
![image](https://github.com/user-attachments/assets/c3e9aa2b-d86b-4db0-b30b-dc544e8a8333)

Listado de topicos 10 registros por pagina


![image](https://github.com/user-attachments/assets/90158bdb-0c3c-4283-bb22-d6b01eea1952)


Actualizando e Ingresando con seguridad

![image](https://github.com/user-attachments/assets/2954d992-85f7-44e3-ba1e-95c7e2cec300)


![image](https://github.com/user-attachments/assets/53b1c1cf-6ddf-4ee2-a53a-9a8c1a9d3412)

![image](https://github.com/user-attachments/assets/29e1fc82-55d0-4f4d-82df-090a66a0308d)


![image](https://github.com/user-attachments/assets/8795ade2-f1ff-4e43-bb24-e2aa253bff05)








Delete del proyecto



![image](https://github.com/user-attachments/assets/0908f272-ed04-4e1c-97bd-33df579de886)


![image](https://github.com/user-attachments/assets/2181a8a5-2c45-415a-b917-689e260d1036)


Eliminado registro

![image](https://github.com/user-attachments/assets/3e6dc554-d7cc-40ec-97c2-23aca51430b7)












---

## Problemas Comunes

1. **Error 403 Forbidden**:
   - Verifica que el token JWT sea válido y esté presente en los encabezados de la solicitud.

2. **Error de conexión a la base de datos**:
   - Confirma que la base de datos esté en ejecución y que las credenciales en `application.properties` sean correctas.

---

## Contacto
Desarrollado por Fany Quivano.




# User Management API

API REST para el registro de usuarios.

---

## Repositorio

https://github.com/diespinola/user-api

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (en memoria)
- Maven
- JUnit 5 + Mockito
- Instancio (para generación de datos en tests)
- Swagger / OpenAPI
- JWT (JSON Web Token)
- Git

---

## Requisitos

- JDK 17+
- Maven 3.8+
- IntelliJ IDEA (recomendado) o cualquier IDE compatible
- Git

---

## Instalación y ejecución

### 1. Clonar el proyecto:

```bash
git clone https://github.com/diespinola/user-api.git
cd user-api
```

### 2. Crear variable de entorno PASSWORD_REGEX

Puedes definir la variable de entorno PASSWORD_REGEX de dos maneras:

**Opción A: Desde la terminal**

En Linux/macOS:  
`export PASSWORD_REGEX='^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$'`

En Windows (CMD):  
`set PASSWORD_REGEX=^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$`

En Windows (PowerShell):  
`$env:PASSWORD_REGEX = '^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$'`

**Opción B: Desde IntelliJ IDEA (Run/Debug Configurations)**
Abre el menú Run > Edit Configurations....

Selecciona tu configuración de ejecución del proyecto.

En el campo Environment variables, agrega:  
`PASSWORD_REGEX=^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$`

Guarda los cambios y ejecuta tu aplicación.

### 3. Ejecutar la aplicación (Debes tener Maven instalado y configurado en el path)

```bash
mvn clean install
mvn spring-boot:run
mvn test
```

## Swagger

Una vez iniciado el proyecto, accedé a la documentación de la API en:

http://localhost:8080/swagger-ui/index.html

## Autenticación
Al registrar un usuario, el sistema genera un token JWT. Este token se almacena en la base de datos y puede utilizarse como header Authorization: Bearer <token> en endpoints protegidos (a desarrollar).

## Bases de datos
Se utiliza H2 en memoria. Hibernate crea las tablas automáticamente, pero para documentación se incluye el siguiente script:

src/main/resources/create_db.sql

## Bases de datos

El diagrama de la solución se encuentra en:

src/main/resources/Diagram-user.png

## Autor

- Diego Espinola.
- diespinola@gmail.com
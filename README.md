# comexport

## Para rodar a aplicação

1. Clone o projeto `git clone https://github.com/GuiRocha/comexport.git`
2. Para fazer o Build do projeto use `mvn clean package`
3. Rode usando `mvn spring-boot:run`
4. Rode os testes unitarios `mvn test`
5. A aplicação estará disponivel na porta `localhost:8080/users` - acesse usando o POSTMAN

## SwaggerUI - Endpoints

1. Acesse `http://localhost:8080/swagger-ui.html` para conferir os endpoints

## Postman

1. GET - `http://localhost:8080/users/`
2. GET by ID - `http://localhost:8080/users/{id}`
3. GET by EMAIL - `http://localhost:8080/users/email?email{=email}`
4. GET by NAME - `http://localhost:8080/users/name?text={name}`
5. POST - `http://localhost:8080/users/`
- faça post utilizando JSON:
    {
    
        "name": "teste",
        "email": "test@teeest.com",
        "birthDate": "1998-06-26",
        "address": "rua 12"
        
    }
    
6. DELETE - `http://localhost:8080/users/1`
7. PUT - `http://localhost:8080/users`
- faça post utilizando JSON:
    {
    
        "id": 1
        "name": "teste",
        "email": "test@teeest.com",
        "birthDate": "1998-06-26",
        "address": "rua 12"
        
    }
    

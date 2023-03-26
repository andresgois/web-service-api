# Microsoft updates API

## Rodar o sistema
- Baixar o projeto
> git clone https://github.com/andresgois/web-service-api.git

- Entra na pasta do projeto
> cd web-service-api

- Banco: Rodar o docker compose
> docker-compose up -d
- Conectar via terminal
```
docker exec -it microsoft_update bash
psql -h localhost -U postgres -W 
- digita a senha: 123456
\l
\c updates
\d
```

- Agora pode roda a aplicação backend

## Acesso 
- [Swagger](http://localhost:8080/swagger-ui/index.html#/)
- [Aplicação](http://localhost:8080/api/update)
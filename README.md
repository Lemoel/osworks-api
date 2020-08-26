# osworks-api

- Um projeto para validar conceitos de APIExperience;
- Projeto utiliza o padrão de *Domain Model* x *Representation Model* - DTO (Data Transfer Object);
- Foi utilizado framework *lombok*;
- Usado o spring-data-jpa;
- Banco de dados Mysql;
- Migração de dados com FlyWay;
- Bean Validation para validar propriedades dos models;
- Customizando erros para as respostas das API - `ApiExceptionHandler.java`
- Data em padrão do ISO8601 com `OffSetDateTime`;
- `@JsonReadyOnly` - Anotação para readonly em propriedades que não devem ser considerada no momento do post
ex: datahora de finalização da ordem de serviço;
- ModelMapper - Para fazer a transformação dos objetos de dominio em objetos de representação;
em `com.lemoel.osworks.api.model` tem os objetos DTO;
em 
- 
# Getting Started

## Project

Implementation of usuario microservice for the Pixup application.
The usuario microservice provides the following functionalities:
- User Register

The following scripts are provided for the MongoDB database/collections creation:
* usuariodb_creation.js
* estado_collection.js
* tipo_domicilio_collection.js
* load_collections_data.js


## Deploy

`// TODO `

## Test

Execute the next `curl` command to validate the deploy of the service. 

```shell
curl -X 'POST' \
  'http://localhost:8082/api/usuarios/registro' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "usuario": {
        "nombre": "Pedro",
        "primerApellido": "Orozco",
        "segundoApellido": "Silva",
        "password": "clavesecreta",
        "email": "urielhdezorozco@gmail.com",
        "rfc": "ARTY891212RT5"
    }, 
    "domicilio": {
        "calle": "Fresno",
        "numExterior": "107",
        "numInterior": "A201"
    }
}' 
```

The expected result should looks like:

```
{
    "id": "65172cccef52ba0e0df7263a",
    "nombre": "Pedro",
    "primerApellido": "Orozco",
    "segundoApellido": "Silva",
    "password": "clavesecreta",
    "email": "urielhdezorozco@gmail.com",
    "rfc": "ARTY891212RT5",
    "domicilios": [
        {
            "calle": "Fresno",
            "numExterior": "107",
            "numInterior": "A201"
        }
    ]
}
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#web)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)


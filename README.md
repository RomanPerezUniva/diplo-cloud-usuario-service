# Getting Started

## Project

Implementation of usuario microservice for the Pixup application.
The usuario microservice provides the following functionalities:
- User Register

The following scripts are provided for the MongoDB database/collections creation:
* usuariodb_creation.js

```shell
use admin;
db.createUser(
{
	user: "usuario_owner",
	pwd: "usuario_password",
	roles: [ { role: "userAdmin", db: "usuariodb" }]
});
```

  
* estado_collection.js

```shell
db.createCollection('estados', {
  validator: {
    $jsonSchema: {
	  required: ['nombre'],
      properties: {
        nombre: {
          type: 'string',
          description: 'nombre del estado requerido'
        }
      }
    }
  }
});

db.estados.createIndex( { nombre: 1 }, { unique: true } );
```


* tipo_domicilio_collection.js

```shell
db.createCollection('tiposDomicilio', {
  validator: {
    $jsonSchema: {
	  required: ['descripcion'],
      properties: {
        descripcion: {
          type: 'string',
          description: 'descripcion tipoDomicilio requerido'
        }
      }
    }
  }
});

db.tiposDomicilio.createIndex( { descripcion: 1 }, { unique: true } );

db.tiposDomicilio.insertMany( [
   { descripcion: "Entrega" },
   { descripcion: "Facturacion" }
]);
```

* load_collections_data.js
```shell

// insert estados
db.estados.insertMany( [
   	{ 
	   nombre: "CIUDAD DE MÉXICO" 
	}
]);

// insert municipios
db.municipios.insertMany( [
   	{ 
	   	nombre: "Miguel Hidalgo", 
	   	estado: DBRef("estados", db.estados.findOne({nombre: "CIUDAD DE MÉXICO"})._id)
	},
	{ 
	   	nombre: "Cuauhtémoc", 
	   	estado: DBRef("estados", db.estados.findOne({nombre: "CIUDAD DE MÉXICO"})._id)
	}
]);

// insert colonias
db.colonias.insertMany( [
   	{ 
	   	nombre: "Santa María la Ribera", 
	   	cp: "06400",
	   	municipio: DBRef("municipios", db.municipios.findOne({nombre: "Cuauhtémoc"})._id)
	},
	{ 
	   	nombre: "San Rafael", 
	   	cp: "06400",
	   	municipio: DBRef("municipios", db.municipios.findOne({nombre: "Cuauhtémoc"})._id)
	},
	{ 
	   	nombre: "Guerrero", 
	   	cp: "06300",
	   	municipio: DBRef("municipios", db.municipios.findOne({nombre: "Cuauhtémoc"})._id)
	},
	{ 
	   	nombre: "Anáhuac", 
	   	cp: "11320",
	   	municipio: DBRef("municipios", db.municipios.findOne({nombre: "Miguel Hidalgo"})._id)
	},
	{ 
	   	nombre: "Lomas de Chapultepec I Sección", 
	   	cp: "11000",
	   	municipio: DBRef("municipios", db.municipios.findOne({nombre: "Miguel Hidalgo"})._id)
	},
	{ 
	   	nombre: "Lomas de Chapultepec II Sección", 
	   	cp: "11000",
	   	municipio: DBRef("municipios", db.municipios.findOne({nombre: "Miguel Hidalgo"})._id)
	},
	{ 
	   	nombre: "Lomas de Chapultepec III Sección", 
	   	cp: "11000",
	   	municipio: DBRef("municipios", db.municipios.findOne({nombre: "Miguel Hidalgo"})._id)
	}
]);
```

spring.data.mongodb.host=  ${MONGO_HOSTNAME}
spring.data.mongodb.port=  ${MONGO_PORT}
spring.data.mongodb.authentication-database=  ${MONGO_AUTHDB}
spring.data.mongodb.database=  ${MONGO_DB}
spring.data.mongodb.username=  ${MONGO_USER}
spring.data.mongodb.password=  ${MONGO_PWD}


server.port=  ${TOMCAT_PORT}


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


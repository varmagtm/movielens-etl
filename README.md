# Movielens ETL

This is a Java project to migrate the data from any RDBMS databse like MySQL to the MongoDB, a document oriented NoSQL database. This tool uses the best programming paradigms in the Java Programming language such as Dependency Injection(DI) using Spring, Object Relational Mapping(ORM) using Hibernate with JPA annotations. Spring-Hibernate has been used to read the data from MySQL database, and then converts this data into a suitable format as per my MongoDB document design and Spring – MongoDB driver has been used to insert the documents into the MongoDB.

### RDBMS Schema

![Movielens RDBMS Schema](https://image.ibb.co/iMKBQk/movielens_mysql.jpg)

### Hibernate Entities and their realtionships

![Entity models and their relationships](https://github.com/varmagtm/movielens-etl/blob/master/movielens-entity-models-and-realtionships.jpg)


### NoSQL Document JSON Schema

#### Movie Document Schema


```javascript
{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "id": {
      "type": "integer"
    },
    "title": {
      "type": "string"
    },
    "release_date": {
      "type": "string"
    },
    "video": {
      "type": "string"
    },
    "IMDBURL": {
      "type": "string"
    },
    "genres": {
      "type": "array",
      "items": {
        "type": "string"
      }
    },
    "rating": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "user": {
            "type": "integer"
          },
          "rating": {
            "type": "integer"
          },
          "timestamp": {
            "type": "integer"
          }
        }
      }
    }
  }
}
```

#### User Document Schema


```javascript
{
  "$schema": "http://json-schema.org/draft-04/schema#",
  "type": "object",
  "properties": {
    "id": {
      "type": "integer"
    },
    "age": {
      "type": "integer"
    },
    "gender": {
      "type": "string"
    },
    "occupation": {
      "type": "string"
    },
    "zip_code": {
      "type": "string"
    }
  }
}
```

### Prerequisites

* Eclipse(Prefer latest version)
* MySQL 5.7
* MongoDB 3.0.3
* Java (1.7 and above)


### Installing

* Install MongoDB and MySQL.
* Execute the SQL script from the file [https://github.com/varmagtm/movielens-etl/blob/master/movielens.sql Movielens]. Please make sure that you do not have the databse named 'movielens'
* Clone the repository.
```	
git clone https://github.com/varmagtm/movielens-etl.git
```
* Open Eclipse, File --> Import --> Import Existing Maven Projects into workspace.
* Make sure all the Maven dependencies resolved.
* Open the file hw.ac.uk.movielens.etl.driver.MovielensETLDriver' and run it as Java application.


### Maven Dependencies


```
<dependencies>
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-core</artifactId>
		<version>${spring.framework.version}</version>
	</dependency>

	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-orm</artifactId>
		<version>${spring.framework.version}</version>
	</dependency>

	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-entitymanager</artifactId>
		<version>5.0.6.Final</version>
	</dependency>


	<dependency>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-core</artifactId>
		<version>5.0.6.Final</version>
	</dependency>

	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>${spring.framework.version}</version>
	</dependency>

	<dependency>
		<groupId>commons-dbcp</groupId>
		<artifactId>commons-dbcp</artifactId>
		<version>1.4</version>
	</dependency>

	<dependency>
		<groupId>javax.transaction</groupId>
		<artifactId>jta</artifactId>
		<version>1.1</version>
	</dependency>

	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>5.1.6</version>
	</dependency>

	<dependency>
		<groupId>com.google.code.gson</groupId>
		<artifactId>gson</artifactId>
		<version>2.8.0</version>
	</dependency>

	<dependency>
		<groupId>org.springframework.data</groupId>
		<artifactId>spring-data-mongodb</artifactId>
		<version>1.10.0.RELEASE</version>
	</dependency>

	<dependency>
		<groupId>org.mybatis</groupId>
		<artifactId>mybatis</artifactId>
		<version>3.0.1</version>
	</dependency>

</dependencies>
```

### Configuration

The properties file 'movielens-app-config.properties' needs to be modified as per your configuration.
```
# Hibernate dialect
hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
# hibernate.dialect=org.hibernate.dialect.OracleDialect
# RDBMS database URL
db.url=jdbc:mysql://localhost:3306/movielens
# RDBMS driver name
db.driver.classname=com.mysql.jdbc.Driver
# RDBMS Username
db.username=root
# RDBMS password
db.password=****
# The path of SQL script file
mysql.script.path=movielens.sql
# Mongod host
mongo.host=localhost
# MongoDB port
mongo.port=27017
# MongoDB database name
mongo.db.name=movielens
```

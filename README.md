# Movielens ETL

This is a Java project to migrate the data from any RDBMS databse like MySQL to the MongoDB, a document oriented NoSQL database. This tool uses the best programming paradigms in the Java Programming language such as Dependency Injection(DI) using Spring, Object Relational Mapping(ORM) using Hibernate with JPA annotations. Spring-Hibernate has been used to read the data from MySQL database, and then converts this data into a suitable format as per my MongoDB document design and Spring – MongoDB driver has been used to insert the documents into the MongoDB.


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

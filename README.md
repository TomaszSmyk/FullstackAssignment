## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Examples](#examples)

## General info
This project is simple Lorem ipsum dolor generator.
	
## Technologies
Project is created with:
* Java version: 11
* Spring Boot version: 2.4.2
* ReactJS version: 17.0.1
* H2 in-memory database

## Requirements
To run this project, you will need:
* Java 11+ (here: https://www.oracle.com/java/technologies/javase-downloads.html#javasejdk)
* Node.js (here: https://nodejs.org/en/download/)
* maven (here: https://maven.apache.org/download.cgi)
Remember to set up Env variables in your system.
Thanks to in-memory database that was used in this project there is no nee to setup database.
	
## Setup
This project contains both client and server side. 
First, clone this repository
```
git clone https://github.com/TomaszSmyk/FullstackAssignment.git
```
Second, run server side and then client side of application.
* To run server side
Go to ./FullstackAssignment and start the server:

```
$ cd ./FullstackAssignment
$ mvnw spring-boot:run
```

* To run client side
In another command line go to ./FullstackAssignment/src/main/webapp/fullstack_assignment
```
$ cd ./FullstackAssignment/src/main/webapp/fullstack_assignment
```
Now install lacally npm and start(it can take a short while):
```
$ npm install
$ npm start
```

Finally, You can access application at http://localhost:8080


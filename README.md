# Introduction

This project is intended to handle movement of rover robots landed by NASA on a plateau on mars. 

In the plateau n number of robotic rovers can be deployed and their position is recorded. 

We can have a plateau which have a specified set of borders and the robots are not allowed to move out of the dedicated boundaries.


## Key Features and Technologies
*Based on the user input the rover moves across the plateau from one grid to another or rotate left and right accordingly.

*For an input that triggers a specific rover out of the designated plateau area a warning message is sent. 

*To avoid any crash a rover is also not allowed to move to the position which is already occupied by another rover. 

*A robot is also not allowed to move before another rover finishes. 

### Spring and Spring Boot
Spring framework is an open source Java platform that provides comprehensive infrastructure support for developing robust Java applications very easily and very rapidly.
Spring Boot features is used in this project to decouple dependencies by the use of Inversion of Control container utilizing dependency injection.

## Junit 5
JUnit 5 is the next generation of JUnit. The goal is to create an up-to-date foundation for developer-side testing on the JVM. This includes focusing on Java 8 and above, as well as enabling many different styles of testing.

     

## Installation

To run Spring Boot the following dependencies should be added.
  
    compile 'org.springframework.boot:spring-boot-starter-test:2.1.2.RELEASE'
    compile 'org.springframework.boot:spring-boot-starter-parent:2.1.2.RELEASE'
    compile 'org.springframework.boot:spring-boot-starter-web:2.1.2.RELEASE'

Junit 5 should also be added to the class path

 'org.junit.jupiter:junit-jupiter-engine:5.2.0'
 
 
 ## Future Scope
* Motion of every rover should be recorded as part of the Rover object.
* A service for removing of the rover from the designated area should be provided.
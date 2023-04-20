<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.png" alt="Logo" width="200" height="auto">
  </a>
  <h3 align="center">Sakila Rest Api</h3>
  <p align="center">
    An awesome api Service Support different functions to use
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore Api documentation »</strong></a>
    <br />
    <br />
  </p>
</div>

# About The Project
This Project is simple movie store provider and we built a differnet services for developer, Project try to rent movies to our customers and 
our main bussiness is rent those films so we provide rest and soap services to handle all simple crud operations from adding movie to rent it by
customer.

# Get Started
This is an example using our repository so follow those steps:
- Download Tomcat 10 or any other container [Download](https://tomcat.apache.org/download-10.cgi)

- Run Tomcat 

- Clone Repository

  ```sh
    git clone https://github.com/mohamedgomaa23722/Sakila-Rest.git
  ``` 

- Modifing Persistance.xml properities
  we need to add those two properities :
 
  ```sh
     <property name="hibernate.connection.username" value="user"/>
     <property name="hibernate.connection.password" value="password"/>
  ``` 
 
 NOTE : user should have a privilages to access sakila table, i preffer to create standalone user for sakila
 to avoid redundant table error.
 
 - Modifing Pom.xml Tomcat Plugin
  
  ```sh
             <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <username>Enter user name here</username>
                    <password>Enter password here</password>
                    <url>http://localhost:8080/manager/text</url>
                    <path>/RestSakila</path>
                </configuration>
            </plugin>
  ``` 
  NOTE: You need to make sure that port 8080 is available to avoid connection error with tomcat 
    
 - Now you are ready To deploy or deploy using tomcat plugin 
  ```sh
      //mvn deploy
       mvn clean compile install tomcat7:deploy
     //mvn redeploy
       mvn clean compile install tomcat7:redeploy
     //mvn undeploy
       mvn clean compile install tomcat7:undeploy
  ``` 
 👋👋 Congratulations you can interact with our api resources.
 
 # Supported resources
 
   We support eleven Resources each one has its requests and responses, so to if you need 
   to know more about those resources [Api Documentation](https://web.postman.co/documentation/14572081-20c650b2-628c-4480-8f2d-f6198b29025b/publish?workspaceId=a46008db-a28f-4544-8783-508d3280939a#url)
  - Films 
  - Actors
  - Countries 
  - Cities
  - Categories
  - Customers
  - Languages
  - Categories
  - Payments
  - Rentals
  - Staffs
 
# Technology Used
![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/cz.jirutka.rsql/rsql-parser/badge.svg)](https://maven-badges.herokuapp.com/maven-central/cz.jirutka.rsql/rsql-parser)
![MySql](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
- Jakarta
- Hibernate
- JAXB 
- MySQL
- Rest
-jersey

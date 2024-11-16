# **Book Management Service**

---
The Book Management Service is a microservice designed to manage  CRUD operations for managing book listings, including optional filters, as well as adding, editing, and deleting books.
## Overview

---
It includes different core service like:
- BookListing Service: Manages search books with filter options
- ManageBookService:   Manages add, edit and deletion of books

## Technologies

---
- Java 18
- SpringBoot for microservice architecture
- PostgreSQL as the primary database

## How to Set Up

---
### Tools Required

- Any Java IDE
- Pgadmin
- JDK
- Postman

### Steps to Clone and Import

---
#### 1. Clone the repository
1. Open a terminal or command prompt
2. Clone the project using below command:
   ````
   https://github.com/AswiniB16/Book-Management-Service
   ````
3. Navigate to project directory
   ````
   cd Book-Management-Service
   ````
#### 2. Import the project to IDE

#####  For IntelliJ IDE
1. Open IntelliJ IDE
2. Click File > Open 
3. Navigate to project directory and import as a Gradle project
4. For the Initial import/clone it will download dependencies and index the project
5. For building the gradle project use the below command
   ```` 
   gradlew clean build
   ````
### Steps to set Run Configurations

---
1. Click Run > Edit Configurations
2. Click on the + button and select application
3. Select the JDK version and Main class of the project 
4. Click OK to save
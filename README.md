Welcome to the Student Orders mini project. A demo video should be available in the root folder of the project. Nothing special needs to be done to import the schema, I'm using JPA Hibernate to auto create the schema and import some seed data. 

First make sure Docker is running on your machine. Just start running the StudentOrdersApplication.java file, in the Spring Boot application. Then open the Angular front end, enter the command: ng serve in the terminal, to start running the front end. You should see a link to open http://localhost:4200/, or just enter that URL in your browser. You should see the Student Orders page come up. 

For the backend, I used a typical MVC architecture to neatly separate concerns. A repository layer to manage access to the data, a DTO layer to safely transform objects between domain entities and API responses. I use JPA Hibernate entities to act as the source of truth, in order to automatically create the schema. I use Lombok to cut down on boilerplate and make it even simpler to extend, and build upon. 

For the front end, I used Angular with Bootstrap CSS styling. Bootstrap is extremely common, so the layout of the site should feel familiar. I organized the folder structure by feature, to make it easy to find particular features and simplify extension. 

There's certainly room for improvement, such as deleting or archiving students and orders, adding schools, and so forth. I included basic validation, on both the back end and front end, but there is always room for improvement. 

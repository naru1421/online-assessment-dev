# Backend Dev Interview Test

This Repo is based on Spring boot project with h2 database, Gradle and java 8. It includes Schema and test data 
(schema.sql and data.sql) and auto creates schema and data.
Please run Gradle bootRun to start both tomcat and h2 console on localhost 8080.

### Database H2 console
http://localhost:8080/h2-console (jdbc url = jdbc:h2:mem:testdb, user = sa, blank password)

### Application endpoints to implement:
http://localhost:8080/registeredCustomersNotOrderedYet
http://localhost:8080/orderValueFromActiveCustomers

### implementation strategy
Please use only repository CRUD methods and service layer to implement the business logic.

### What we are looking for:

How you structure your code.
Coding best practises you follow.
How well your code is tested and handling exceptions.
How you document the codebase.
How you follow code styling conventions.

### Building & Submmitting your solution
Clone / download this repo and create your GitHub repository and develop the solution.
Make sure the GitHub repo is public and respond to the e-mail with a link to your repo. From there, we'll let you know once we've completed our assessment of your code, and you may delete your repo or make it private.

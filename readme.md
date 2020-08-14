### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.



### Instructions

- Fork this project
- Enhance the code in any ways you can see, you are free!. Some possibilities:
  - Add tests
  - Change syntax
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your fork

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues


> ==============================================================

#### Changes

- Fix Lombock version:
  - Issue: In some machines, Lombok may have update/linking failures or inconsistencies with the current syntax, which does not allow displaying models or returning information with formatting to the Swagger view.
  - Fix: Update, re-link the version and installation of Lombock to be abel to work with the Lombock's code on entities (data/models visualization issues on Swagger). 

- Fix Add Method:
  - Issue: Post Method allows to send empty requests, in fact does not require data and creates null records.
  - Fix: Add input of parameters and validate it (Make the data required) to the "Add employee" POST method" to prevent null records. 

- Fix Put Method:
  - Issue: While trying to update a record, app is creating a new registry with null values and just setting the "Update" value (when ID is not sended on body). 
  - Fix: Link the object to the requested ID.
  - Fix: Validate only the submitted change data and concatenate it with the current information to correctly build the object and send it to the update method.
  
  - Add a descriptive response for the users on the "void return" features.

#### Annotations

- The application has a general correct operation, so for the development of new features is necessary to know the final objective of the same and the requirements from the client.

- The fixes were implemented in a simple and self-descriptive way in the code. Keep it simple, easy to understand.

#### Pending

- Add unit tests.

- Add the features required by the client.

- Build a user-friendly UI

- Add a changes confirmation request.

- Organize better the code responses with Try Catch.

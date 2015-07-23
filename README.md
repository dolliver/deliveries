# Delivery Challenge

### About

This project was created as part of CI&T Challenge.
The goal is to allow the insertion of Maps and calculate the shortest distance between two different spots, as well as a total cost based on mileage of the vehicle as well as gas price.

### Considerations

It is understood that big companis have big customers and chances are the the projects become globalized. Therefore, all code and documentation were written in English.

### Architecture Decisions

- In order for a fast check-in, build, assembly, run and test for the evaluation of this project, it was opted to maintain a single project with all the information. T Since it has very few classes, it wasn't a problem. It will be easier for the evaluator to analyze the code.
- For bigger projects, I would have chosen to separate a back-end project and a front-end one. For the Backend, I could also have separate layers for Controllers and Services.
- Since there is a requirement that all data should be persisted, and we are dealing with Graph problems, I opted to use a graph database, so the data is all stored and ready to be queried anytime. It also allows multiple functions that can be later developed.
- All the required dependencies are embedded in this project, such as the graph database and application server (tomcat), so its promptly test with very few commands, as explained below.
- The database will be persisted and lies inside /target folder. The application can be stopped and started, the data won't be loss. However, upon building the project, it will be cleared, since it is inside /target folder. The Path can be changed on Neo4jConfig class so it is not cleared, but once again to fastly test and run the project, it was kept that way.
- There was VERY little time to execute this project. I wish I could have done more user interfaces (UI), written more tests, have a SWAGGER documentation for APIs and so on, but I spend a lto of time thinking of the best way to complete the project and getting it to work - so I kept it simple to complete the deadline.

### Some Components Used
- Spring Framework 4.1.7
- Junit  4.11
- Embedded Tomcat 7
- Spring-data-neo4j 3.3.1  (and embedded NeoJ graphDatabase)



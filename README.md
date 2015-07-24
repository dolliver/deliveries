# Delivery Challenge

### About

This project was created as part of CI&T Challenge.
The goal is to allow the insertion of Maps and calculate the shortest distance between two different spots, as well as a the total cost based on the mileage of the vehicle as well as the gas price.

### Considerations

- It is understood that big companies have big customers and chances are the the projects will become globalized. Therefore, all code and documentation were written in English.

- In order for a fast check-in, build, assembly, run and test for the evaluation of this project, it was opted to maintain a single project with all the information on it. Since it has very few classes, it wasn't a problem, and it will be easier for the evaluator to analyze the code and test the project.

- For bigger projects, I would have chosen to separate a back-end project and a front-end one. For the Backend, I could also have separate layers for Controllers and Services, or even separate projects. It would make more sense, however, to separate the project according to meaningful pieaces of information that interact with one anothe in their domain.

- Since there is a requirement that all data should be persisted, and we are dealing with Graph problems, I opted to use a graph database, so the data is all stored and ready to be queried anytime. It also allows multiple functions that can be later developed.

- All the required dependencies are embedded in this project, such as the graph database and application server (tomcat), so it's promptly ready to test with very few commands, as explained below.

- The database will be persisted and lies inside /target folder. The application can be stopped and started, the data won't be loss. However, upon building the project (clean&install), it will be cleared, since it is inside /target folder. The Path can be changed on Neo4jConfig class so it is not cleared, but once again to fastly test and run the project, it was kept that way.

- There was very little time to execute this project. I wish I could have done a lot more things, but I spend a lot of time thinking of the best way to complete the project and getting it to work - so I kept it simple to complete the deadline in 24hs. Besides, it was a week day so didn't have much of a change to do it during the day - just at night.
Some of the things I certainly wanted to do (and will do in the future), which I am used to doing in other projects are listed below. Please understand I had very little time, wanted to do it a lot, but had to prioritize having a working project first. The examples are
- GUI to create maps and consult distance costs
- Cache API calls to obtain the distance and invalidate the cache once a map is updated (or received new nodes), to gain performance  (ehCache would be enough for this simple project)
- Execute and evidence stress tests with Jmeter on the APIs
- Make a Swagger API documentation for the APIs
- Create authentication and verify authorization to access the APIs, store the usernames and their roles, use Spring Security to secure the controller methods
- Make OAuth flows available since is is required to have APIs, to make them easy to access
- Written more Unit and integration tests

### Some Components Used
- Spring Framework 4.1.7
- Junit  4.11
- Embedded Tomcat 7
- Spring-data-neo4j 3.3.1  (and embedded NeoJ graphDatabase)
- Apache Maven


### How to test
- Checkout project
```
git clone git@github.com:dolliver/deliveries.git
```

- Enter project dir
```
cd deliveries
```

- Build project
```
mvn clean install
```

- Run project
```
mvn tomcat7:run
```

- Create a new map

POST http://localhost:8080/delivery/maps  -  (Header) Content-type: application/json
```
{
  "name": "Douglas Test Map",
  "nodes": [
    {
       "startingPoint": "A",
       "destinationPoint": "B",
       "distance": 10.0
    },
    {
       "startingPoint": "B",
       "destinationPoint": "D",
       "distance": 15.0
    },
    {
       "startingPoint": "A",
       "destinationPoint": "C",
       "distance": 20.0
    },
    {
       "startingPoint": "C",
       "destinationPoint": "D",
       "distance": 30.0
    },
    {
       "startingPoint": "B",
       "destinationPoint": "E",
       "distance": 50.0
    },   
    {
       "startingPoint": "D",
       "destinationPoint": "E",
       "distance": 30.0
    }        
  ]
}
```

The created map with its id will be returned

```
{
    "id": 0,
    "name": "Douglas Test Map"
}
```

- Verify the shortest distance between two points and give additional parameters to calculate cost

In this example we will verify on Map of ID 0  (just created), the shortest distance between points A and D, and calculate the cost of the trip in a vehicle of milage 10 km/l with gas price of 2.5 currency units per liter.

GET http://localhost:8080/delivery/maps/0/from/A/to/D?gasPrice=2.5&mileage=10

We can see the result below

```
{
    "totalDistance": 25,
    "fullPath": "[A, B, D]",
    "mileage": 10,
    "gasPrice": 2.5,
    "totalCost": 6.25
}
```



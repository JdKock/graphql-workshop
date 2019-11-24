# GraphQL Workshop

# Resources
### GraphQL
* [GraphQL](https://graphql.org/)
* [GraphQL documentation](https://graphql.org/learn/)
* [GraphQL Schema and Types](https://graphql.org/learn/schema/)
* [GraphQL Java](https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/)

### Marvel 
* [Developer portal](https://developer.marvel.com)
* [Interactive documentation](https://developer.marvel.com/docs)
* [Authorizing and signing requests](https://developer.marvel.com/documentation/authorization)

### Others
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.1.RELEASE/maven-plugin/)

### Running the application
`mvn spring-boot:run`

### GraphiQL
You can use the in-browser IDE, GraphiQL, to explore your GraphQL application.
Start your application and go to: http://localhost:8080/graphiql

# Assignment part 1
In this first part of the assignment you will create your GraphQL schema. You can find the schema file in the 
`src/main/resources/graphql/` folder. The schema will basically define what data can be queried. 
We have already created a domain model that corresponds to the following `Character` endpoints 
of the [Marvel API](https://developer.marvel.com/docs).
* `GET /v1/public/characters`
* `GET /v1/public/characters/{characterId}`

# Assignment part 2
In this part of the assignment you will need to implement a service to fetch the data from the Marvel API. 
You will need an API Key which you can get from the [Marvel Developer portal](https://developer.marvel.com).
To be able to call the Marvel API you will also need to create a MD5 Hash. Please refer to the 
[Authorizing and signing requests](https://developer.marvel.com/documentation/authorization) section of the documentation.

You can use any client to actually fetch the data but it might be convenient to use the
[Spring RestTemplate](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html).

# Assignment part 3 (optional)
Try to use [variables](https://graphql.org/learn/queries/#variables), [directives](https://graphql.org/learn/queries/#directives)
and other cool features that GraphQL has to offer while querying your API.


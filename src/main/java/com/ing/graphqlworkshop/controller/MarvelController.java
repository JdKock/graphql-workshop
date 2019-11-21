package com.ing.graphqlworkshop.controller;

import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Controller
@EnableAutoConfiguration
public class MarvelController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World Developer!!!";
    }

//    @Override
//    protected GraphQLConfiguration getConfiguration() {
//        return GraphQLConfiguration.with(createSchema()).build();
//    }
    @RequestMapping("/graphql")
    @ResponseBody
    private GraphQLSchema createSchema() {
        String schema = "type Query{hello: String}";

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);

        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world")))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }
}
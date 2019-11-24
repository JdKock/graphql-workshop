package com.ing.graphqlworkshop.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ing.graphqlworkshop.domain.Character;
import com.ing.graphqlworkshop.domain.Serie;
import com.ing.graphqlworkshop.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private MarvelService marvelService;

    public List<Character> getCharacters(final int limit) throws IOException {
        return this.marvelService.getAllCharacters(limit);
    }

    public Optional<Character> getCharacter(final int id) throws IOException {
        return this.marvelService.getCharacter(id);
    }

}
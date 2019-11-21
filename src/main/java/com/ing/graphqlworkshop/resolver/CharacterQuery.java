package com.ing.graphqlworkshop.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ing.graphqlworkshop.domain.Character;
import com.ing.graphqlworkshop.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CharacterQuery implements GraphQLQueryResolver {

    @Autowired
    private MarvelService marvelService;

    public List<Character> getCharacters(final int count) {
        return this.marvelService.getAllCharacters(count);
    }

    public Optional<Character> getCharacter(final int id) {
        return this.marvelService.getCharacter(id);
    }

}
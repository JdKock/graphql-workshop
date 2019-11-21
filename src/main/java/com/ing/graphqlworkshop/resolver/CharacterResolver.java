package com.ing.graphqlworkshop.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.ing.graphqlworkshop.domain.Character;
import com.ing.graphqlworkshop.service.MarvelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;;import java.util.List;
import java.util.Optional;

/**
 * CharacterResolver is a resolver for the Character
 */
//@Slf4j
//@Component
class CharacterResolver implements GraphQLResolver<Character> {

    @Autowired
    private MarvelService marvelService;

    public List<Character> getCharacters(final int count) {
        return this.marvelService.getAllCharacters(count);
    }

    public Optional<Character> getVehicle(final int id) {
        return this.marvelService.getCharacter(id);
    }

}
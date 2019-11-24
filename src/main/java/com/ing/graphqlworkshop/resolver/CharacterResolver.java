package com.ing.graphqlworkshop.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.ing.graphqlworkshop.domain.Character;
import com.ing.graphqlworkshop.domain.Serie;
import com.ing.graphqlworkshop.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class CharacterResolver implements GraphQLResolver<Character> {

    @Autowired
    private MarvelService marvelService;

    public List<Serie> getSeries(final Character character, int id) throws IOException {
        return this.marvelService.getSeries(id);
    }

}
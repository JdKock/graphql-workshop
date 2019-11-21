package com.ing.graphqlworkshop.service;

import com.ing.graphqlworkshop.domain.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class MarvelService {

    public List<Character> getAllCharacters(int count) {
        return new ArrayList<>();
    }

    public Optional<Character> getCharacter(int id) {
        return Optional.empty();
    }
}

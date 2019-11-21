package com.ing.graphqlworkshop.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Character {
    private int id;
    private String name;
    private String description;
    private String modified;
    private Thumbnail thumbnail;
    private String resourceURI;
    private List<Comic> comics;
    private List<Serie> series;
    private List<Story> stories;
    private List<Event> events;
    private List<Url> urls;
}

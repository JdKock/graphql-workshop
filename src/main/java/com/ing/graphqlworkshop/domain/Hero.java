package com.ing.graphqlworkshop.domain;

import java.util.List;

public class Hero {
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

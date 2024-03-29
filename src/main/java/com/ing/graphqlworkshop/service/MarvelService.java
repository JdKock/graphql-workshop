package com.ing.graphqlworkshop.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.ing.graphqlworkshop.domain.Character;
import com.ing.graphqlworkshop.domain.Serie;
import com.ing.graphqlworkshop.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MarvelService {

    private static final String API_KEY = "apikey";
    private static final String HASH = "hash";
    private static final String TIMESTAMP = "ts";

    @Autowired
    MarvelServiceProperties marvelServiceProperties;

    public List<Character> getAllCharacters(int limit) throws IOException {

        Date now = new Date();
        String timestamp = String.valueOf(now.getTime());

        // generate a md5 digest of the ts parameter, your private key and your public key (e.g. md5(ts+privateKey+publicKey)
        String hash = MD5Util.hash(marvelServiceProperties.getPublicKey(), marvelServiceProperties.getPrivateKey(), timestamp);

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(marvelServiceProperties.getScheme())
                .host(marvelServiceProperties.getHost())
                .path(marvelServiceProperties.getCharacters().getPath())
                .queryParam(API_KEY, marvelServiceProperties.getPublicKey())
                .queryParam(TIMESTAMP, timestamp)
                .queryParam(HASH, hash)
                .queryParam("limit", limit)
                .build();

        return getResults(uriComponents.toString());
    }

    public Optional<Character> getCharacter(int id) throws IOException {

        Date now = new Date();
        String timestamp = String.valueOf(now.getTime());

        // generate a md5 digest of the ts parameter, your private key and your public key (e.g. md5(ts+privateKey+publicKey)
        String hash = MD5Util.hash(marvelServiceProperties.getPublicKey(), marvelServiceProperties.getPrivateKey(), timestamp);

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(marvelServiceProperties.getScheme())
                .host(marvelServiceProperties.getHost())
                .path(marvelServiceProperties.getCharacters().getPath())
                .pathSegment(String.valueOf(id))
                .queryParam(API_KEY, marvelServiceProperties.getPublicKey())
                .queryParam(TIMESTAMP, timestamp)
                .queryParam(HASH, hash)
                .build();

        return getResults(uriComponents.toString()).stream().findFirst();
    }

    public List<Serie> getSeries(int id) throws IOException {

        Date now = new Date();
        String timestamp = String.valueOf(now.getTime());

        // generate a md5 digest of the ts parameter, your private key and your public key (e.g. md5(ts+privateKey+publicKey)
        String hash = MD5Util.hash(marvelServiceProperties.getPublicKey(), marvelServiceProperties.getPrivateKey(), timestamp);

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(marvelServiceProperties.getScheme())
                .host(marvelServiceProperties.getHost())
                .path(marvelServiceProperties.getCharacters().getPath())
                .pathSegment(id+"/series")
                .queryParam(API_KEY, marvelServiceProperties.getPublicKey())
                .queryParam(TIMESTAMP, timestamp)
                .queryParam(HASH, hash)
                .build();

        return getSeries(uriComponents.toString());
    }

    private List<Character> getResults(final String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> json = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(Objects.requireNonNull(json.getBody(), "response body must not be null"));
        JsonNode resultsNode = rootNode.at("/data/results");
        ObjectReader reader = mapper.readerFor(new TypeReference<List<Character>>() {});
        return reader.readValue(resultsNode);
    }

    private List<Serie> getSeries(final String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> json = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(Objects.requireNonNull(json.getBody(), "response body must not be null"));
        JsonNode resultsNode = rootNode.at("/data/results");
        ObjectReader reader = mapper.readerFor(new TypeReference<List<Serie>>() {});
        return reader.readValue(resultsNode);
    }
}

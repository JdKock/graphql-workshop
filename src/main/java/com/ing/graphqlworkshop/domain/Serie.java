package com.ing.graphqlworkshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Serie {
    private int id;
    private String title;
}

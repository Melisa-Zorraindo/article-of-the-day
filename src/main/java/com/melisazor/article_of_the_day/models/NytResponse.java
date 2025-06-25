package com.melisazor.article_of_the_day.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NytResponse {
    @JsonProperty("results")
    private List<Article> articleResponse;
}

package com.melisazor.article_of_the_day.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Multimedia {
    private String url;
    private String format;
}

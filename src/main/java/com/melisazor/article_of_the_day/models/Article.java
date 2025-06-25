package com.melisazor.article_of_the_day.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private String title;
    private String section;

    @JsonProperty("abstract")
    private String excerpt;

    @JsonProperty("byline")
    private String author;

    @JsonProperty("published_date")
    private Date published;

    @JsonProperty("des_facet")
    private List<String> tags;

    private String url;
    private String threeByTwoSmall;
    private String thumbnail;

    @JsonProperty("multimedia")
    private void unpackMultimedia(List<Multimedia> media) {
        if (media == null) {
            return;
        }
        for (Multimedia m : media) {
            if ("threeByTwoSmallAt2X".equals(m.getFormat())) {
                this.threeByTwoSmall = m.getUrl();
            } else if ("Large Thumbnail".equals(m.getFormat())) {
                this.thumbnail = m.getUrl();
            }
        }
    }
}

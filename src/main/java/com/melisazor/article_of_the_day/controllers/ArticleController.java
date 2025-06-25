package com.melisazor.article_of_the_day.controllers;

import com.melisazor.article_of_the_day.models.Article;
import com.melisazor.article_of_the_day.models.NytResponse;
import com.melisazor.article_of_the_day.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/{topic}")
    public ResponseEntity<Article> getArticles(@PathVariable String topic) {
        NytResponse response = articleService.getArticles(topic);
        List<Article> articles = response.getArticleResponse();

        Article a = new Article();
        for (Article ar: articles) {
            if (Objects.equals(ar.getSection(), topic)) {
                a.setTitle(ar.getTitle());
                a.setSection(ar.getSection());
                a.setExcerpt(ar.getExcerpt());
                a.setAuthor(ar.getAuthor());
                a.setPublished(ar.getPublished());
                a.setTags(ar.getTags());
                a.setUrl(ar.getUrl());
                a.setThreeByTwoSmall(ar.getThreeByTwoSmall());
                a.setThumbnail(ar.getThumbnail());
            }
        }

        return new ResponseEntity<>(a, HttpStatus.OK);
    }
}

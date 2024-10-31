package tp.eni.enistore.article.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.eni.enistore.article.bll.ArticleService;
import tp.eni.enistore.article.bll.ResponseService;
import tp.eni.enistore.article.bo.Article;

import java.util.List;


@RestController

public class ArticleRestController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/get-all")

    public ResponseService<List<Article>> getAll() {

        return articleService.getArticlesAll();


    }
    @GetMapping("/get-id/{id}")
    public ResponseService<Article> getId(@PathVariable("id") Long id){


    return articleService.getArticleById(id);
    }


    @DeleteMapping("/delete-id/{id}")
    public ResponseService<Article> delete(@PathVariable("id") Long id) {

        return articleService.deleteById(id);
    }

    @PostMapping("/article")
    public ResponseService<Article> save(@RequestBody Article article) {
        return articleService.save(article);
    }



}

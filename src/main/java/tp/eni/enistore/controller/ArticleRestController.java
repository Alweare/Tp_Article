package tp.eni.enistore.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp.eni.enistore.bll.ArticleService;
import tp.eni.enistore.bll.ResponseService;
import tp.eni.enistore.bo.Article;

import java.util.List;


@RestController
@Api(tags = "Articles")
public class ArticleRestController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/get-all")
    @ApiOperation(value = "Récupérer tous les articles", response = List.class)
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

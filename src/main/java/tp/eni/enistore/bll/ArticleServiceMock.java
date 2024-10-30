package tp.eni.enistore.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.eni.enistore.bo.Article;
import tp.eni.enistore.dal.IDAOArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class ArticleServiceMock {
    @Autowired
    ResponseService responseService;
    IDAOArticle articleDAO;



List<Article> articles = new ArrayList<Article>();
    Article article1 = new Article("1", "brosse a dent");
    Article article2 = new Article("2", "épingle a cheveux");
    Article article3 = new Article("3" ,"morissette");
    Article article4 = new Article("4", "un pneu");

    public ArticleServiceMock(List<Article> articles) {
        this.articles = articles;
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);

    }



    public ResponseService getArticlesAll() {
        List<Article> foundArticle =  articleDAO.findAll();
        if(foundArticle.isEmpty()){
            return responseService.buildResponse("703", " y a pas d'article", null);
        }

        return responseService.buildResponse("202", "Voici vos articles ! ", articles);
    }

    public ResponseService getArticleById(String id) {

        Article articleById = articles.stream().filter(c -> Objects.equals(c.id, id)).findFirst().orElse(null);

        if(articleById == null){
            return responseService.buildResponse("703", " y a pas d'article", null);
        }


//        if(articleById == null){
//            return responseService.buildResponse("703", " y a pas d'article", null);
//        }

        return responseService.buildResponse("202", "Voici l'article ! ", articleById);
    }

    public ResponseService deleteById(String id){
        Article articleADelete = articles.stream().filter(c -> Objects.equals(c.id, id)).findFirst().orElse(null);
        if(articleADelete == null){
            responseService.buildResponse("703", " y a pas d'article", null);

        }
        articles.remove(articleADelete);

        return responseService.buildResponse("202", "article delete", articleADelete);


    }

    public ResponseService save(Article article) {
        Article articleASave = articles.stream().filter(c -> Objects.equals(c.id, article.id)).findFirst().orElse(null);
        if (articleASave != null) {
            articleASave.title = article.title;
            return responseService.buildResponse("202", " article update", articleASave);
        }

        articles.add(articleASave);


        return responseService.buildResponse("202", " articel sauvegarder", null);

    }




}

package tp.eni.enistore.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.eni.enistore.bo.Article;
import tp.eni.enistore.dal.IDAOArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ArticleService {
    @Autowired
    ResponseService responseService;

    @Autowired
    IDAOArticle articleDAO;


    public ResponseService<List<Article>> getArticlesAll() {
        List<Article> foundArticle =  articleDAO.findAll();
        if(foundArticle.isEmpty()){
            return ResponseService.buildResponse("703", " y a pas d'article", null);
        }

        return ResponseService.buildResponse("202", "Voici vos articles ! ", foundArticle);
    }

    public ResponseService<Article> getArticleById(String id) {

        Article articleById = articleDAO.findById(id);

        if(articleById == null){
            return ResponseService.buildResponse("703", " y a pas d'article", null);
        }

//        if(articleById == null){
//            return responseService.buildResponse("703", " y a pas d'article", null);
//       }
        return ResponseService.buildResponse("202", "Voici l'article ! ", articleById);
    }

    public ResponseService<Article> deleteById(String id){
        Article articleADelete = articleDAO.findById(id);
        if(articleADelete == null){
            ResponseService.buildResponse("703", " y a pas d'article", null);

        }
        articleDAO.delete(articleADelete);

        return ResponseService.buildResponse("202", "article delete", articleADelete);


    }

    public ResponseService<Article> save(Article article) {
        Article articleTitle = articleDAO.findByTitle(article.title);
        boolean articleIsNew= article.id == null || articleDAO.findById(article.id) == null;



        if(articleTitle != null && articleIsNew){
            return ResponseService.buildResponse("701", " le titre existe déjà", article);
        }

        if (!articleIsNew && articleTitle != null && articleTitle.id.equals(article.id)) {

                    return ResponseService.buildResponse("202", " article update", article);
        }

        articleDAO.save(article);

        return ResponseService.buildResponse("202", " articel sauvegarder", null);

    }




}

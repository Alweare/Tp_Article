package tp.eni.enistore.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import tp.eni.enistore.bo.Article;
import tp.eni.enistore.config.MessageHelper;
import tp.eni.enistore.dal.IDAOArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class ArticleService {
    @Autowired
    ResponseService responseService;

    @Autowired
    IDAOArticle articleDAO;

    @Autowired
    MessageHelper messageHelper;




    public ResponseService<List<Article>> getArticlesAll() {
        List<Article> foundArticle =  articleDAO.findAll();
        if(foundArticle.isEmpty()){
            return ResponseService.buildResponse("703", messageHelper.i18n("ERROR_ALL"), null);
        }

        return ResponseService.buildResponse("202", messageHelper.i18n("SUCCESS_ALL"), foundArticle);
    }

    public ResponseService<Article> getArticleById(Long id) {

        Article articleById = articleDAO.findById(id);

        if(articleById == null){
            return ResponseService.buildResponse("703", messageHelper.i18n("ERROR_ARTICLE_ID"), null);
        }

//        if(articleById == null){
//            return responseService.buildResponse("703", " y a pas d'article", null);
//       }
        return ResponseService.buildResponse("202", messageHelper.i18n("SUCCESS_ARTICLE_ID"), articleById);
    }

    public ResponseService<Article> deleteById(Long id){
        Article articleADelete = articleDAO.findById(id);
        if(articleADelete == null){
            ResponseService.buildResponse("703", messageHelper.i18n("ERROR_DELETE_ARTICLE"), null);

        }
        articleDAO.delete(articleADelete);

        return ResponseService.buildResponse("202", messageHelper.i18n("SUCCESS_DELETE_ARTICLE"), articleADelete);


    }

    public ResponseService<Article> save(Article article) {
        Article articleTitle = articleDAO.findFirstByTitle(article.title) ;
        boolean articleIsNew= article.id == null || articleDAO.findById(article.id) == null;



        if(articleTitle != null && articleIsNew){
            return ResponseService.buildResponse("701", messageHelper.i18n("ERROR_SAVE_ARTICLE_TITLE_EXIST"), article);
        }

        if (!articleIsNew && articleTitle != null && Objects.equals(articleTitle.id, article.id)) {

                    return ResponseService.buildResponse("202", messageHelper.i18n("SUCCESS_SAVE_UPDATE_TITLE"), article);
        }

        articleDAO.save(article);

        return ResponseService.buildResponse("202", messageHelper.i18n("SUCCESS_SAVE_ARTICLE"), null);

    }




}

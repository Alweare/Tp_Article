package tp.eni.enistore.article.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import tp.eni.enistore.article.bo.Article;

import java.util.List;
@Profile("jpa")
@Repository
public class ArticleDAORepository implements IDAOArticle{
    @Autowired
    MySQLRepo monRepo;

    @Override
    public Article findById(Long id) {
        return monRepo.findById(id).orElse(null);
    }

    @Override
    public Article findFirstByTitle(String title) {
        return monRepo.findFirstByTitle(title);
    }

    @Override
    public Article save(Article article) {
        return monRepo.save(article);
    }

    @Override
    public void delete(Article article) {
        monRepo.delete(article);

    }

    @Override
    public List<Article> findAll() {
        return monRepo.findAll();
    }
}

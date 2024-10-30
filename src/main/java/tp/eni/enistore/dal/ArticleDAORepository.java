package tp.eni.enistore.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import tp.eni.enistore.bo.Article;

import java.util.List;
@Profile("mongodb")
@Repository
public class ArticleDAORepository implements IDAOArticle{
    @Autowired
    MonRepo monRepo;

    @Override
    public Article findById(String id) {
        return monRepo.findById(id).orElse(null);
    }

    @Override
    public Article findByTitle(String title) {
        return monRepo.findByTitle(title);
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

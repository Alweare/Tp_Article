package tp.eni.enistore.dal;

import tp.eni.enistore.bo.Article;

import java.util.List;

public class ArticleDAOSQL implements IDAOArticle{
    @Override
    public Article findById(String id) {
        return null;
    }

    @Override
    public Article findByTitle(String title) {
        return null;
    }

    @Override
    public Article save(Article article) {
        return null;
    }

    @Override
    public void delete(Article article) {

    }

    @Override
    public List<Article> findAll() {
        return List.of();
    }
}

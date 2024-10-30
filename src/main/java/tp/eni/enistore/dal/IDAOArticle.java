package tp.eni.enistore.dal;

import tp.eni.enistore.bo.Article;

import java.util.List;

public interface IDAOArticle {
    public Article findById(String id);
    public Article findByTitle(String title);
    public Article save(Article article);
    public void delete(Article article);
    public List<Article> findAll();
}

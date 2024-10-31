package tp.eni.enistore.article.dal;

import tp.eni.enistore.article.bo.Article;

import java.util.List;

public interface IDAOArticle {
    public Article findById(Long id);
    public Article findFirstByTitle(String title);
    public Article save(Article article);
    public void delete(Article article);
    public List<Article> findAll();

}

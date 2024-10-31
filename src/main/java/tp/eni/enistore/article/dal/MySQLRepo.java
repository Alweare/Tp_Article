package tp.eni.enistore.article.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.eni.enistore.article.bo.Article;

public interface MySQLRepo extends JpaRepository<Article, Long> {
    public Article findFirstByTitle(String title);
}

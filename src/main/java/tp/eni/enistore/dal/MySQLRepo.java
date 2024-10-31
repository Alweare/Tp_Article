package tp.eni.enistore.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.eni.enistore.bo.Article;

public interface MySQLRepo extends JpaRepository<Article, Long> {
    public Article findFirstByTitle(String title);
}

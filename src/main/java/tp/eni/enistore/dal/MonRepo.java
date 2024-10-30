package tp.eni.enistore.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import tp.eni.enistore.bo.Article;

public interface MonRepo extends MongoRepository<Article, String> {
    public Article findByTitle(String title);
}

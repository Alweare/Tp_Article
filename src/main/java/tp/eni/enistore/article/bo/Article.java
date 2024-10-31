package tp.eni.enistore.article.bo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @NotBlank(message="il faut un titre")
    public String title;

    public Article() {
    }
    public Article(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

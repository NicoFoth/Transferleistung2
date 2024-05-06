package foth.transferleistung.activeRecord;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TeaService {

    @Transactional
    public Long createArticle(String type, int amount) {
        Tea article = new Tea();
        article.type = type;
        article.amount = amount;
        article.persist();
        return article.id;
    }

    public Tea getById(Long id) {
        return Tea.findById(id);
    }

    public List<Tea> getAll() {
        return Tea.listAll();
    }

    @Transactional
    public Tea updateArticle(Tea tea) {
        Tea article = Tea.findById(tea.id);
        article.amount = tea.amount;
        article.type = tea.type;
        return article;
    }

    @Transactional
    public void deleteArticle(Long id) {
        Tea article = Tea.findById(id);
        article.delete();
    }
}

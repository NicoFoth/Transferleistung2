package foth.transferleistung.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CoffeeService {

    CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Transactional
    public Long createArticle(String type, int amount) {
        Coffee article = new Coffee();
        article.type = type;
        article.amount = amount;
        coffeeRepository.persist(article);
        return article.id;
    }

    public Coffee getById(Long id) {
        return coffeeRepository.findById(id);
    }

    public List<Coffee> getAll() {
        return coffeeRepository.listAll();
    }

    @Transactional
    public Coffee updateArticle(Coffee coffee) {
        Coffee article = coffeeRepository.findById(coffee.id);
        article.amount = coffee.amount;
        article.type = coffee.type;
        return article;
    }

    @Transactional
    public void deleteArticle(Long id) {
        Coffee article = coffeeRepository.findById(id);
        coffeeRepository.delete(article);
    }
}

package foth.transferleistung.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class CoffeeService {

    CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Transactional
    public Long createArticle(CoffeeOrderDTO coffeeOrderDTO) {
        CoffeeOrder article = new CoffeeOrder();
        article.type = coffeeOrderDTO.type();
        article.amount = coffeeOrderDTO.amount();
        coffeeRepository.persist(article);
        return article.id;
    }

    public CoffeeOrder getById(Long id) {
        return coffeeRepository.findById(id);
    }

    public List<CoffeeOrder> getAll() {
        return coffeeRepository.listAll();
    }

    @Transactional
    public CoffeeOrder updateArticle(CoffeeOrder coffeeOrder) {
        CoffeeOrder article = coffeeRepository.findById(coffeeOrder.id);
        article.amount = coffeeOrder.amount;
        article.type = coffeeOrder.type;
        return article;
    }

    @Transactional
    public void deleteOrder(Long id) {
        CoffeeOrder order = coffeeRepository.findById(id);
        if (order == null) {
            throw new NotFoundException();
        }
        coffeeRepository.delete(order);
    }
}

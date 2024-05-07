package foth.transferleistung.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CoffeeRepository implements PanacheRepository<CoffeeOrder> {

    public CoffeeOrder findByType(String type) {
        return find("type", type).firstResult();
    }

    public List<CoffeeOrder> listAmountGreaterThan(int amount) {
        return find("amount > ?1", amount).list();
    }
}

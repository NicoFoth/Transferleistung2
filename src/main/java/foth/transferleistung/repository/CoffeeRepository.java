package foth.transferleistung.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CoffeeRepository implements PanacheRepository<Coffee> {

    public Coffee findByType(String type) {
        return find("type", type).firstResult();
    }

    public List<Coffee> listAmountGreaterThan(int amount) {
        return find("amount > ?1", amount).list();
    }
}

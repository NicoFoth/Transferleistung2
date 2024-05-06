package foth.transferleistung.activeRecord;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Tea extends PanacheEntity {

    public String type;

    public int amount;

    public static Tea findByType(String type) {
        return find("type", type.toLowerCase()).firstResult();
    }

    public List<Tea> listAmountGreaterThan(int amount) {
        return find("amount > ?1", amount).list();
    }
}

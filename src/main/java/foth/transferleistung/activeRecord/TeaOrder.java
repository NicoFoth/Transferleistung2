package foth.transferleistung.activeRecord;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class TeaOrder extends PanacheEntity {

    public String type;

    public int amount;

    public static TeaOrder findByType(String type) {
        return find("type", type.toLowerCase()).firstResult();
    }

    public List<TeaOrder> listAmountGreaterThan(int amount) {
        return find("amount > ?1", amount).list();
    }
}

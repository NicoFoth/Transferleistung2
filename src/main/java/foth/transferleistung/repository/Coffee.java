package foth.transferleistung.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Coffee {

    @Id
    @GeneratedValue
    public long id;

    public String type;

    public int amount;
}

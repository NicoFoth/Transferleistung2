package foth.transferleistung.activeRecord;

import foth.transferleistung.repository.Coffee;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TeaServiceTest {

    @Test
    void createArticle() {
        String type = "Latte";
        int amount = 2;

        Tea mockArticle = new Tea();
        mockArticle.type = type;
        mockArticle.amount = amount;

        // TODO: Write test
    }

    @Test
    void updateArticle() {
    }

    @Test
    void deleteArticle() {
    }
}
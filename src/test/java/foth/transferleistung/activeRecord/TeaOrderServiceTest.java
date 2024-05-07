package foth.transferleistung.activeRecord;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TeaOrderServiceTest {
    @Inject
    TeaService teaService;

    @Test
    void testCreateOrder() {
        String type = "Latte";
        int amount = 2;
        Long id = 1L;
        TeaOrderDTO teaOrderDTO = new TeaOrderDTO(type, amount);

        Long orderId = teaService.createOrder(teaOrderDTO);

        assertEquals(id, orderId);
        TeaOrder teaOrder = TeaOrder.findById(orderId);
        assertEquals(type, teaOrder.type);
        assertEquals(amount, teaOrder.amount);
    }

    @Test
    void updateArticle() {
    }

    @Test
    void testDeleteOrder_notFound() {
        Long orderId = 1L;
        assertThrows(NotFoundException.class, () -> teaService.deleteOrder(orderId));
    }

    @Test
    void testDeleteOrder_successful() {
        Long orderId = 1L;
        String type = "Latte";
        int amount = 2;

        // Depending on the createOrder method to test the deleteOrder method
        teaService.createOrder(new TeaOrderDTO(type, amount));

        teaService.deleteOrder(orderId);
        assertNull(TeaOrder.findById(orderId));
    }
}
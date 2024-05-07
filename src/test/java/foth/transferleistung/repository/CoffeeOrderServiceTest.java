package foth.transferleistung.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class CoffeeOrderServiceTest {

    private final CoffeeRepository coffeeRepositoryMock = mock(CoffeeRepository.class);
    private final CoffeeService coffeeService = new CoffeeService(coffeeRepositoryMock);

    @Test
    public void testCreateArticle() {
        String type = "Latte";
        int amount = 2;

        CoffeeOrder mockArticle = new CoffeeOrder();
        mockArticle.type = type;
        mockArticle.amount = amount;

        Mockito.doAnswer(invocation -> {
            CoffeeOrder coffeeOrder = invocation.getArgument(0);
            coffeeOrder.id = 1L;
            return null;
        }).when(coffeeRepositoryMock).persist(Mockito.any(CoffeeOrder.class));

        Long orderId = coffeeService.createArticle(new CoffeeOrderDTO(type, amount));

        Mockito.verify(coffeeRepositoryMock).persist(Mockito.any(CoffeeOrder.class));

        assertEquals(1L, orderId);
    }

    @Test
    public void updateArticle() {
        CoffeeOrder mockArticle = new CoffeeOrder();
        mockArticle.id = 1L;
        mockArticle.type = "Latte";
        mockArticle.amount = 2;

        Mockito.when(coffeeRepositoryMock.findById(1L)).thenReturn(mockArticle);

        CoffeeOrder updatedArticle = new CoffeeOrder();
        updatedArticle.id = 1L;
        updatedArticle.type = "Espresso";
        updatedArticle.amount = 3;

        CoffeeOrder updated = coffeeService.updateArticle(updatedArticle);

        assertThat(updated, samePropertyValuesAs(updatedArticle));
    }

    @Test
    public void deleteArticle() {
        CoffeeOrder mockArticle = new CoffeeOrder();
        mockArticle.id = 1L;
        mockArticle.type = "Latte";
        mockArticle.amount = 2;

        Mockito.when(coffeeRepositoryMock.findById(1L)).thenReturn(mockArticle);

        coffeeService.deleteOrder(1L);

        Mockito.verify(coffeeRepositoryMock).delete(mockArticle);
    }
}

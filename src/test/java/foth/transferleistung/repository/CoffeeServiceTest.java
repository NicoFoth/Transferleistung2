package foth.transferleistung.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class CoffeeServiceTest {

    private final CoffeeRepository coffeeRepositoryMock = mock(CoffeeRepository.class);
    private final CoffeeService coffeeService = new CoffeeService(coffeeRepositoryMock);

    @Test
    public void testCreateArticle() {
        String type = "Latte";
        int amount = 2;

        Coffee mockArticle = new Coffee();
        mockArticle.type = type;
        mockArticle.amount = amount;

        Mockito.doAnswer(invocation -> {
            Coffee coffee = invocation.getArgument(0);
            coffee.id = 1L;
            return null;
        }).when(coffeeRepositoryMock).persist(Mockito.any(Coffee.class));

        Long orderId = coffeeService.createArticle(type, amount);

        Mockito.verify(coffeeRepositoryMock).persist(Mockito.any(Coffee.class));

        assertEquals(1L, orderId);
    }

    @Test
    public void updateArticle() {
        Coffee mockArticle = new Coffee();
        mockArticle.id = 1L;
        mockArticle.type = "Latte";
        mockArticle.amount = 2;

        Mockito.when(coffeeRepositoryMock.findById(1L)).thenReturn(mockArticle);

        Coffee updatedArticle = new Coffee();
        updatedArticle.id = 1L;
        updatedArticle.type = "Espresso";
        updatedArticle.amount = 3;

        Coffee updated = coffeeService.updateArticle(updatedArticle);

        assertThat(updated, samePropertyValuesAs(updatedArticle));
    }

    @Test
    public void deleteArticle() {
        Coffee mockArticle = new Coffee();
        mockArticle.id = 1L;
        mockArticle.type = "Latte";
        mockArticle.amount = 2;

        Mockito.when(coffeeRepositoryMock.findById(1L)).thenReturn(mockArticle);

        coffeeService.deleteArticle(1L);

        Mockito.verify(coffeeRepositoryMock).delete(mockArticle);
    }
}

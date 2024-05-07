package foth.transferleistung.repository;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/coffee")
public class CoffeeResource {

    @Inject
    CoffeeService coffeeService;

    @POST
    public Long createArticle(CoffeeOrderDTO coffeeOrderDTO) {
        return coffeeService.createArticle(coffeeOrderDTO);
    }

    @GET
    public List<CoffeeOrder> getAll() {
        return coffeeService.getAll();
    }

    @GET
    @Path("/{id}")
    public CoffeeOrder getById(Long id) {
        CoffeeOrder coffeeOrder = coffeeService.getById(id);
        if (coffeeOrder == null) {
            throw new NotFoundException();
        }
        return coffeeOrder;
    }

    @PUT
    @Path("/{id}")
    public CoffeeOrder updateArticle(CoffeeOrder coffeeOrder) {
        return coffeeService.updateArticle(coffeeOrder);
    }

    @DELETE
    @Path("/{id}")
    public void deleteArticle(Long id) {
        coffeeService.deleteOrder(id);
    }
}

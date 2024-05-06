package foth.transferleistung.repository;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/coffee")
public class CoffeeResource {

    @Inject
    CoffeeService coffeeService;

    @POST
    public Long createArticle(String type, int amount) {
        return coffeeService.createArticle(type, amount);
    }

    @GET
    public List<Coffee> getAll() {
        return coffeeService.getAll();
    }

    @GET
    @Path("/{id}")
    public Coffee getById(Long id) {
        Coffee coffee = coffeeService.getById(id);
        if (coffee == null) {
            throw new NotFoundException();
        }
        return coffee;
    }

    @PUT
    @Path("/{id}")
    public Coffee updateArticle(Coffee coffee) {
        return coffeeService.updateArticle(coffee);
    }

    @DELETE
    @Path("/{id}")
    public void deleteArticle(Long id) {
        coffeeService.deleteArticle(id);
    }
}

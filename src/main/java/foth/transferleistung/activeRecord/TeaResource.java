package foth.transferleistung.activeRecord;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/tea")
public class TeaResource {

    @Inject
    TeaService teaService;

    @POST
    public Long createArticle(String type, int amount) {
        return teaService.createArticle(type, amount);
    }

    @GET
    public List<Tea> getAll() {
        return teaService.getAll();
    }

    @GET
    @Path("/{id}")
    public Tea getById(Long id) {
        Tea tea = teaService.getById(id);
        if (tea == null) {
            throw new NotFoundException();
        }
        return tea;
    }

    @PUT
    public Tea updateArticle(Tea tea) {
        return teaService.updateArticle(tea);
    }

    @DELETE
    public void deleteArticle(Long id) {
        teaService.deleteArticle(id);
    }
}

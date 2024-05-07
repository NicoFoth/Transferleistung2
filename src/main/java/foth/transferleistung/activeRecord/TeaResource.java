package foth.transferleistung.activeRecord;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/tea")
public class TeaResource {

    @Inject
    TeaService teaService;

    @POST
    public Long createOrder(TeaOrderDTO teaOrderDTO) {
        return teaService.createOrder(teaOrderDTO);
    }

    @GET
    public List<TeaOrder> getAll() {
        return teaService.getAll();
    }

    @GET
    @Path("/{id}")
    public TeaOrder getById(Long id) {
        TeaOrder teaOrder = teaService.getById(id);
        if (teaOrder == null) {
            throw new NotFoundException();
        }
        return teaOrder;
    }

    @PUT
    public TeaOrder updateOrder(TeaOrder teaOrder) {
        return teaService.updateOrder(teaOrder);
    }

    @DELETE
    public void deleteOrder(Long id) {
        teaService.deleteOrder(id);
    }
}

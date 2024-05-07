package foth.transferleistung.activeRecord;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class TeaService {

    @Transactional
    public Long createOrder(TeaOrderDTO teaOrderDTO) {
        TeaOrder order = new TeaOrder();
        order.type = teaOrderDTO.type();
        order.amount = teaOrderDTO.amount();
        order.persist();
        return order.id;
    }

    public TeaOrder getById(Long id) {
        return TeaOrder.findById(id);
    }

    public List<TeaOrder> getAll() {
        return TeaOrder.listAll();
    }

    @Transactional
    public TeaOrder updateOrder(TeaOrder teaOrder) {
        TeaOrder order = TeaOrder.findById(teaOrder.id);
        order.amount = teaOrder.amount;
        order.type = teaOrder.type;
        return order;
    }

    @Transactional
    public void deleteOrder(Long id) {
        TeaOrder order = TeaOrder.findById(id);
        if (order == null) {
            throw new NotFoundException();
        }
        order.delete();
    }
}

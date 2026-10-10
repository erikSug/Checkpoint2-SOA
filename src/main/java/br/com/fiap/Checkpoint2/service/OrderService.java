package br.com.fiap.Checkpoint2.service;

import br.com.fiap.Checkpoint2.model.orderModel;
import br.com.fiap.Checkpoint2.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public orderModel createOrder(orderModel order){
        return orderRepository.save(order);
    }
    public List<orderModel> readAllOrders(){
        return orderRepository.findAll();
    }
    public orderModel readOrderById(long id){
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado!"));
    }

    public orderModel updateOrder(long id, orderModel order) {
        return orderRepository.findById(id).map(existingOrder -> {
            existingOrder.setClientName(order.getClientName());
            existingOrder.setTotalValue(order.getTotalValue());

            return orderRepository.save(existingOrder);
        }).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado!"));
    }
    public void deleteOrderById(long id){
        try{
            orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new EntityNotFoundException("Pedido não encontrado");
        }
    }
}

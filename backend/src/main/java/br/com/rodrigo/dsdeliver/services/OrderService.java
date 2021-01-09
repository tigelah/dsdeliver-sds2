package br.com.rodrigo.dsdeliver.services;

import br.com.rodrigo.dsdeliver.dtos.OrderDTO;
import br.com.rodrigo.dsdeliver.entities.Order;
import br.com.rodrigo.dsdeliver.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> orderList = orderRepository.findOrdersWithProducts();
        return  orderList.stream().map(OrderDTO::new).collect(Collectors.toList());
    }
}

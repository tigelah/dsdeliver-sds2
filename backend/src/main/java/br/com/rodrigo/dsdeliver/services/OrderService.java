package br.com.rodrigo.dsdeliver.services;

import br.com.rodrigo.dsdeliver.dtos.OrderDTO;
import br.com.rodrigo.dsdeliver.entities.Order;
import br.com.rodrigo.dsdeliver.entities.OrderStatus;
import br.com.rodrigo.dsdeliver.repositories.OrderRepository;
import br.com.rodrigo.dsdeliver.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> orderList = orderRepository.findOrdersWithProducts();
        return  orderList.stream().map(OrderDTO::new).collect(Collectors.toList());
    }
    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);

        dto.getProducts()
                .stream()
                .map(p -> productRepository.getOne(p.getId()))
                .forEachOrdered(product ->
                        order.getProducts()
                                .add(product));
        orderRepository.save(order);
        return new OrderDTO(order);
    }

}

package br.com.rodrigo.dsdeliver.resources;

import br.com.rodrigo.dsdeliver.dtos.OrderDTO;;
import br.com.rodrigo.dsdeliver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> dtoList = orderService.findAll();
        return ResponseEntity.ok().body(dtoList);
    }
}
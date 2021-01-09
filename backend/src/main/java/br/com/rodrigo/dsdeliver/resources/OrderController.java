package br.com.rodrigo.dsdeliver.resources;

import br.com.rodrigo.dsdeliver.dtos.OrderDTO;
import br.com.rodrigo.dsdeliver.entities.Order;
import br.com.rodrigo.dsdeliver.services.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @ApiOperation(value = "Lista de todos os Pedidos", notes = "Lista de todos os Pedidos", response = Order.class, responseContainer = "List" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pedidos Listadas com sucesso"),
            @ApiResponse(code = 401, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 403, message = "O acesso ao recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> dtoList = orderService.findAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @ApiOperation(value = "Insere um Pedido", notes = "Insere um Pedido", response = Order.class )
    @ApiResponses({
            @ApiResponse(code = 201, message = "Inclusão com sucesso de um Pedido")
    })
    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO  orderDTO){
        orderDTO = orderService.insert(orderDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(orderDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(orderDTO);
    }

    @ApiOperation(value = "Atualizar Pedido", notes = "Atualizar Pedido")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Atualização com sucesso de um Pedido")
    })
    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id){
        OrderDTO orderDTO = orderService.setDelivered(id);
        return ResponseEntity.ok().body(orderDTO);
    }
}
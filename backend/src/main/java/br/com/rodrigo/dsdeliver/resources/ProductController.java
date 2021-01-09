package br.com.rodrigo.dsdeliver.resources;

import br.com.rodrigo.dsdeliver.dtos.ProductDTO;
import br.com.rodrigo.dsdeliver.entities.Order;
import br.com.rodrigo.dsdeliver.entities.Product;
import br.com.rodrigo.dsdeliver.services.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Lista de todos os Produtos", notes = "Lista de todos os Produtos", response = Product.class, responseContainer = "List" )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Produtos Listadas com sucesso"),
            @ApiResponse(code = 401, message = "Você não está autorizado a ver o recurso"),
            @ApiResponse(code = 403, message = "O acesso ao recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> dtoList = productService.findAll();
        return ResponseEntity.ok().body(dtoList);
    }
}

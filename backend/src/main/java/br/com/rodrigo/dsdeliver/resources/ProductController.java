package br.com.rodrigo.dsdeliver.resources;

import br.com.rodrigo.dsdeliver.dtos.ProductDTO;
import br.com.rodrigo.dsdeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> dtoList = productService.findAll();
        return ResponseEntity.ok().body(dtoList);
    }
}

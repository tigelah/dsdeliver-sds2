package br.com.rodrigo.dsdeliver.repositories;

import br.com.rodrigo.dsdeliver.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByOrderByNameAsc();
}

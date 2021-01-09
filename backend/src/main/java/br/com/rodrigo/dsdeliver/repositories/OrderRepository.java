package br.com.rodrigo.dsdeliver.repositories;

import br.com.rodrigo.dsdeliver.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order,Long> {

    @Query(value = "SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products " +
            " WHERE obj.status = 0 ORDER BY obj.moment ASC")
    List<Order> findOrdersWithProducts();

}

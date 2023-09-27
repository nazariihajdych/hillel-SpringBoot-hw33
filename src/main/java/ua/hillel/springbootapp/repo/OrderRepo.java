package ua.hillel.springbootapp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.hillel.springbootapp.model.entity.Order;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {
}

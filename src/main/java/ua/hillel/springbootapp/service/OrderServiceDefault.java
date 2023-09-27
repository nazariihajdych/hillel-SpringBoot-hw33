package ua.hillel.springbootapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.hillel.springbootapp.model.entity.Order;
import ua.hillel.springbootapp.model.entity.Product;
import ua.hillel.springbootapp.repo.OrderRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceDefault implements OrderService {

    private final OrderRepo orderRepo;

    @Override
    public Order getOrderById(Integer id) {
        log.info("OrderServiceDefault getOrderById method");
        return orderRepo.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        log.info("OrderServiceDefault getAllOrders method");
        return (List<Order>) orderRepo.findAll();
    }

    @Override
    public Order addOrder(Order order) {
        log.info("addOrder counting cost of order");
        Double costOfProductsInOrder = 0D;
        for (Product p : order.getProducts()) {
            costOfProductsInOrder += p.getCost();
        }
        order.setCost(costOfProductsInOrder);
        log.info("addOrder adding user");
        return orderRepo.save(order);
    }
}

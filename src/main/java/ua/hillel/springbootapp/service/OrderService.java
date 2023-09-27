package ua.hillel.springbootapp.service;

import ua.hillel.springbootapp.model.entity.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer id);

    List<Order> getAllOrders();

    Order addOrder(Order order);
}

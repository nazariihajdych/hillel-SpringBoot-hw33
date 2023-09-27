package ua.hillel.springbootapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.hillel.springbootapp.model.entity.Order;
import ua.hillel.springbootapp.service.OrderServiceDefault;


import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderServiceDefault orderServiceDefault;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Order> getOrderById(@PathVariable Integer id){
        log.info("OrderController grtOrderById");
        if (orderServiceDefault.getOrderById(id) == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(orderServiceDefault.getOrderById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Order>> getAllOrders(){
        log.info("OrderController getAllOrders");
        return ResponseEntity.ok(orderServiceDefault.getAllOrders());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Order> saveOrder(@RequestBody Order order){
        log.info("OrderController saveOrder");
        return ResponseEntity.ok(orderServiceDefault.addOrder(order));
    }
}

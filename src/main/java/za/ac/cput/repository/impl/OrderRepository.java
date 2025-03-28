package za.ac.cput.repository.impl;

import za.ac.cput.domain.Order;
import za.ac.cput.repository.IOrderRepository;

import java.util.List;

public class OrderRepository implements IOrderRepository {

    @Override
    public Order getOrder(int orderId) {
        return null;
    }

    @Override
    public List<Order> getOrdersByCustomerId(int customerId) {
        return List.of();
    }

    @Override
    public List<Order> findByStatus(String status) {
        return List.of();
    }

    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean DeleteOrder(int orderId) {
        return false;
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Order read(String s) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }
}

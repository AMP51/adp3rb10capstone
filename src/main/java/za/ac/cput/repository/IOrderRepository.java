package za.ac.cput.repository;


import za.ac.cput.domain.Order;

import java.util.List;

public interface IOrderRepository extends IRepository<Order, String> {

    Order getOrder(int orderId);

    List<Order> getOrdersByCustomerId(int customerId);

    List<Order> findByStatus(String status);

    boolean addOrder(Order order);

    boolean updateOrder(Order order);

    boolean DeleteOrder(int orderId);;
}



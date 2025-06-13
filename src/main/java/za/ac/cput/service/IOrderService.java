package za.ac.cput.service;

import za.ac.cput.domain.Order;
import java.util.List;

public interface IOrderService extends IService<Order, String> {
    Order getOrder(int orderId);
    List<Order> getOrdersByCustomerId(int customerId);
    List<Order> findByStatus(String status);
}

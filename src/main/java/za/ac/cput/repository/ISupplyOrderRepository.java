/*
ISupplyOrderRepository.java
Author: Musa Banathi Nkosi (221744517)
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.SupplyOrder;

import java.util.List;

@Repository
public interface ISupplyOrderRepository extends JpaRepository<SupplyOrder, String> {

    // Custom query methods
    List<SupplyOrder> findByOrderStatus(String orderStatus);

    List<SupplyOrder> findByEmployeeID(String employeeID);

    List<SupplyOrder> findBySupplierID(String supplierID);

    List<SupplyOrder> findByOrderPriceBetween(double minPrice, double maxPrice);
}

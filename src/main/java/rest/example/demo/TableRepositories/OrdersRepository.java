package rest.example.demo.TableRepositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import rest.example.demo.TableModels.orders;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<orders,Long> {
    @Query("select o from orders o where o.user=?1")
    List<orders> findAllByUser(int userId);
    @Query("select o from orders o where o.user=?1")
    orders findByUser(int userId);
    @Query("select o from orders  o where o.user=?1 and  o.shipped_date=null")
    List<orders> findPendingOrders(int userId);
}

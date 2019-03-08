package rest.example.demo.TableModels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class orders implements Serializable {
    @GenericGenerator(
            name = "ordersSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "ordersSequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "ordersSequenceGenerator")
    @Column(name = "orders_id")
    private Long orders_id;

    @Column(name="order_date")
    private Date orderDate;
    @Column(name="shipped")
    private boolean shipped;
    @Column(name="shipped_date")
    private Date shipped_date;
    @OneToMany(mappedBy = "orders")
    private Set<order_details> order_details;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private users user;

    public orders(Date orderDate, boolean shipped, Date shipped_date, Set<rest.example.demo.TableModels.order_details> order_details, users user) {
        this.orderDate = orderDate;
        this.shipped = shipped;
        this.shipped_date = shipped_date;
        this.order_details = order_details;
        this.user = user;
    }

    public Long getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(Long orders_id) {
        this.orders_id = orders_id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    public Set<rest.example.demo.TableModels.order_details> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(Set<rest.example.demo.TableModels.order_details> order_details) {
        this.order_details = order_details;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }
}

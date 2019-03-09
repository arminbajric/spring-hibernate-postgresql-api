package rest.example.demo.TableModels;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_details")
public class order_details {
    @GenericGenerator(
            name = "orderDetailsSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "orderDetailsSequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "orderDetailsSequenceGenerator")
    @Column(name = "order_details_id")
    private Long order_details_id;
    @Column(name="amount")
    private double amount;
    @Column(name="order_price")
    private double order_price;
    @ManyToOne
    @JoinColumn(name = "orders_id",nullable = false)
    private orders orders;
    @ManyToOne
    @JoinColumn(name="items_id")
    private items items;

    public order_details() {
    }

    public order_details(double amount, double order_price, rest.example.demo.TableModels.orders orders, rest.example.demo.TableModels.items items) {
        this.amount = amount;
        this.order_price = order_price;
        this.orders = orders;
        this.items = items;
    }

    public Long getOrder_details_id() {
        return order_details_id;
    }

    public void setOrder_details_id(Long order_details_id) {
        this.order_details_id = order_details_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public rest.example.demo.TableModels.orders getOrders() {
        return orders;
    }

    public void setOrders(rest.example.demo.TableModels.orders orders) {
        this.orders = orders;
    }

    public rest.example.demo.TableModels.items getItems() {
        return items;
    }

    public void setItems(rest.example.demo.TableModels.items items) {
        this.items = items;
    }
}

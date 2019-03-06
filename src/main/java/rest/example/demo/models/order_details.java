package rest.example.demo.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

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

}

package rest.example.demo.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class orders {
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
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}

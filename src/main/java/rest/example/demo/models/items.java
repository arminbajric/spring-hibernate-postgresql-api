package rest.example.demo.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Data
@Entity
@Table(name = "items")
public class items {
    @GenericGenerator(
            name = "itemsSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "itemsSequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "itemsSequenceGenerator")
    @Column(name = "items_id")
    private Long items_id;

    @Column(name="item_name")
    private String item_name;

    @Column(name="item_code",unique = true)
    private Long item_code;

    @Column(name = "item_description")
    private String item_description;
    @Column(name = "item_price")
    private double item_price;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private category category;
}

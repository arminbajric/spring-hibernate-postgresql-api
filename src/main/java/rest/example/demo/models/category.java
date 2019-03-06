package rest.example.demo.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
public class category {
    @GenericGenerator(
            name = "categorySequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "categorySequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "categorySequenceGenerator")
    @Column(name = "category_id")
    private Long category_id;

    @Column(name = "category_name")
    private String category;
    @Column(name="numberOfItemsInCategory")
    private int numberOfItemsInCategory;
     @OneToMany(mappedBy = "category")
    private Set<items> items;

}

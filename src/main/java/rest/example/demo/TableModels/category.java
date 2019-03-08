package rest.example.demo.TableModels;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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
    @Column(name = "categoryId")
    private Long categoryId;

    @Column(name = "categoryName")
    private String categoryName;
    @Column(name="numberOfItemsInCategory")
    private int numberOfItemsInCategory;

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "category")
    private List<category> category;

    public Long getCategoryId() {
        return categoryId;
    }

    public category() {
    }

    public category(String categoryName, int numberOfItemsInCategory) {
        this.categoryName = categoryName;
        this.numberOfItemsInCategory = numberOfItemsInCategory;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getNumberOfItemsInCategory() {
        return numberOfItemsInCategory;
    }

    public void setNumberOfItemsInCategory(int numberOfItemsInCategory) {
        this.numberOfItemsInCategory = numberOfItemsInCategory;
    }

    public List<rest.example.demo.TableModels.category> getItems() {
        return category;
    }

    public void setItems(List<rest.example.demo.TableModels.category> categories) {
        this.category = categories;
    }
}

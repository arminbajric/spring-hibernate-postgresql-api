package rest.example.demo.TableModels;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

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
    @Column(name = "itemsId")
    private Long itemsId;

    @Column(name="itemName")
    private String itemName;

    @Column(name="itemCode",unique = true)
    private Long itemCode;

    @Column(name = "itemDescription")
    private String itemDescription;
    @Column(name = "itemPrice")
    private double itemPrice;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "categoryId",nullable = false)
    private category category;
    @OneToMany(mappedBy = "items")
    private List<order_details> order_details;

    public items() {
    }

    public rest.example.demo.TableModels.category getCategory() {
        return category;
    }

    public void setCategory(rest.example.demo.TableModels.category category) {
        this.category = category;
    }

    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public category getCategoryId() {
        return category;
    }

    public void setCategoryId(category categoryId) {
        this.category = categoryId;
    }

    public List<rest.example.demo.TableModels.order_details> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<rest.example.demo.TableModels.order_details> order_details) {
        this.order_details = order_details;
    }
}

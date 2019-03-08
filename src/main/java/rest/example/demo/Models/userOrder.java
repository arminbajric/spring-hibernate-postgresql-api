package rest.example.demo.Models;

import rest.example.demo.TableModels.order_details;
import rest.example.demo.TableModels.orders;

import java.util.List;

public class userOrder {
    private List<order_details> order_details;
    private orders orders ;

    public List<rest.example.demo.TableModels.order_details> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<rest.example.demo.TableModels.order_details> order_details) {
        this.order_details = order_details;
    }

    public rest.example.demo.TableModels.orders getOrders() {
        return orders;
    }

    public void setOrders(rest.example.demo.TableModels.orders orders) {
        this.orders = orders;
    }

    public userOrder() {
    }

    public userOrder(List<rest.example.demo.TableModels.order_details> order_details, rest.example.demo.TableModels.orders orders) {
        this.order_details = order_details;
        this.orders = orders;
    }
}

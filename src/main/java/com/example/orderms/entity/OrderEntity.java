package com.example.orderms.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Document(collection= "tb_orders")
public class OrderEntity {

    private Long orderID;

    @Indexed(name = "customer_id_index")
    private Long custumeID;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;

    private List<OrderItens> items;

    public OrderEntity(Long orderID) {
        this.orderID = orderID;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getCustumeID() {
        return custumeID;
    }

    public void setCustumeID(Long custumeID) {
        this.custumeID = custumeID;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderItens> getItems() {
        return items;
    }

    public void setItems(List<OrderItens> items) {
        this.items = items;
    }
}

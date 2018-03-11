package com.compras.flozano.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
@Entity
@Cacheable(false)
@Table(name = "\"order\"")
@NamedQueries({
        @NamedQuery(name = "Order.findByCustomerId", query = "SELECT o FROM Order o WHERE o.customerId = :customer_id")
})
public class Order implements Serializable{
    private static final long serialVersionUID = 3992734751972453486L;
    @Id
    @NotNull
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "delivery_address")
    private Integer deliveryAddress;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Integer deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}

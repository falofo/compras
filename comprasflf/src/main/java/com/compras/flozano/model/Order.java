package com.compras.flozano.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa las ordenes
 * Created by Fabiani Lozano on 10/03/2018.
 */
@Entity
@Cacheable(false)
@Table(name = "\"order\"")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Order.findByCustomerId", query = "SELECT o FROM Order o WHERE o.customerId = :customer_id AND o.creationDate BETWEEN :start_date AND :end_date")
})
public class Order implements Serializable{
    private static final long serialVersionUID = 3992734751972453486L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "order")
    private List<OrderDetail> detalle;

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

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<OrderDetail> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<OrderDetail> detalle) {
        for(OrderDetail det : detalle){
            det.setOrder(this);
        }
        this.detalle = detalle;
    }
}

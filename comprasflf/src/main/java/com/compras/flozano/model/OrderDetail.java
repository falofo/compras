package com.compras.flozano.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Clase que representa los detalles de una orden
 * Created by Fabiani Lozano on 10/03/2018.
 */
@Entity
@Table(name = "order_detail")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o")})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = -3818657259241588531L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    @JsonIgnore
    private Integer detailId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

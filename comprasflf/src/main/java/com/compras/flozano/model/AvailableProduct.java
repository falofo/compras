package com.compras.flozano.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa los productos disponibles por cliente
 * Created by Fabiani Lozano on 11/03/2018.
 */
@Entity
@Cacheable(false)
@Table(name = "available_product")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "AvailableProduct.findAll", query = "SELECT c FROM AvailableProduct c"),
        @NamedQuery(name = "AvailableProduct.findByCustomerId", query = "SELECT c FROM AvailableProduct c WHERE c.customerId = :customer_id")})
public class AvailableProduct implements Serializable{
    private static final long serialVersionUID = -1670586973340721239L;
    @Id
    @NotNull
    @Column(name = "available_id")
    private Integer availableId;
    @NotNull
    @Column(name = "customer_id")
    private Integer customerId;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Integer getAvailableId() {
        return availableId;
    }

    public void setAvailableId(Integer availableId) {
        this.availableId = availableId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

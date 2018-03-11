package com.compras.flozano.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
@Entity
@Table(name = "available_product")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "AvailableProduct.findAll", query = "SELECT p FROM AvailableProduct p")})
public class AvailableProduct implements Serializable{

    private static final long serialVersionUID = 8326540584875499133L;
    @Id
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Id
    @Basic(optional = false)
    @Column(name = "product_id")
    private String productId;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}

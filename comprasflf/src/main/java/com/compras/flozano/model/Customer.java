package com.compras.flozano.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa los clientes
 * Created by Fabiani Lozano on 10/03/2018.
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")})
public class Customer implements Serializable{
    private static final long serialVersionUID = -5464458590416257637L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    /*@JoinTable(name = "available_product", joinColumns = {
            @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")}, inverseJoinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "product_id")})
    @ManyToMany
    private List<Product> productList;*/

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }*/
}

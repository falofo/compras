package com.compras.flozano.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * Created by Fabiani Lozano on 10/03/2018.
 */
public class AbstractService {
    @Autowired
    protected EntityManager em;
}

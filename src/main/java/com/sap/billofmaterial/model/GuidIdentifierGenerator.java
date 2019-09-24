package com.sap.billofmaterial.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class GuidIdentifierGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String ts = String.valueOf(System.currentTimeMillis());
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID+ts;
    }
}

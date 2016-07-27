package com.ezdi.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.ezdi.model.CellphoneBrand;
import com.ezdi.model.CellphoneModel;
 
/**
 * This program demonstrates using Hibernate framework to manage
 * a one-to-one mapping with foreign key using annotations.
 * @author www.codejava.net
 *
 */
public class TestDatabase {
 
    public static void main(String[] args) {
         
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
         
        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
        // creates a Cellphone Model entity
        CellphoneModel cm = new CellphoneModel();
        cm.setModelName("galaxy j5");
        cm.setModelColor("black");
        cm.setModelScreenSize(5.0f);
        cm.setModelType("dual");
        cm.setModelOS("android");
        cm.setModelProcessor("2.5 GHz snapdragon");
        cm.setModelRAM(1024);
        cm.setModelInternalMemory(8000);
        cm.setModelLength(4.1f);
        cm.setModelBreadth(4.1f);
        cm.setModelThickness(0.5f);
        cm.setModelReleaseDate(new java.sql.Date(System.currentTimeMillis()));
        CellphoneBrand cb = new CellphoneBrand();
        cb.setBrandName("Samsung");
        cm.setCellphoneBrand(cb);
         
        // persists the book entity
        int cpId = (Integer) session.save(cm);
         
        // gets the book entity back
        CellphoneModel cModel = (CellphoneModel) session.get(CellphoneModel.class, cpId);
         
        CellphoneBrand cBrand = cModel.getCellphoneBrand();
        System.out.println("Cellphone's Brand Name : " + cBrand.getBrandName());
        session.getTransaction().commit();
        session.close();       
    }
}
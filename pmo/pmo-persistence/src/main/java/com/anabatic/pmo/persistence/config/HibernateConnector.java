/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anabatic.pmo.persistence.config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author chandu
 */
public class HibernateConnector {

    private static HibernateConnector me;
    private Configuration cfg;
    private SessionFactory sessionFactory;
    @Autowired
    ConfigurationDatabasePMO conf;

    private HibernateConnector() throws HibernateException {

        // build the config
        cfg = new Configuration();

        /**
         * Connection Information..
         */
        cfg.setProperty("hibernate.connection.driver_class", conf.jdbc_driver);
        cfg.setProperty("hibernate.connection.url", conf.jdbc_url);
        cfg.setProperty("hibernate.connection.username", conf.jdbc_username);
        cfg.setProperty("hibernate.connection.password", conf.jdbc_password);
//        cfg.setProperty("hibernate.show_sql", "true");

        /**
         * Mapping Resources..
         */
        //cfg.addResource("com/onlinetutorialspoint/pojo/Student.hbm.xml");

        sessionFactory = cfg.buildSessionFactory();
    }

    public static synchronized HibernateConnector getInstance() throws HibernateException {
        if (me == null) {
            me = new HibernateConnector();
        }

        return me;
    }

    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }

    private void reconnect() throws HibernateException {
        this.sessionFactory = cfg.buildSessionFactory();
    }
}

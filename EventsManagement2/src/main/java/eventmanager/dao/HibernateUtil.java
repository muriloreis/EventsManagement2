/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Murilo
 */
public class HibernateUtil {
    
   private static final SessionFactory sessionFactory = buildSessionFactory();
   private static SessionFactory buildSessionFactory(){
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Hibernate Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
   }
   
   public static SessionFactory getSessionFactory(){
       return sessionFactory;
   }
   
   /*public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException   {
       Class.forName("com.mysql.jdbc.Driver").newInstance();
       java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost","root","mysql");
       System.out.println("connectou");
   }*/
}

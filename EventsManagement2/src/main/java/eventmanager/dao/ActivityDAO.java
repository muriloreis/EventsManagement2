/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.dao;

import eventmanager.model.Activity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Murilo
 */
public class ActivityDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public void add(Activity activity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(activity);
        transaction.commit();
        session.close();
    }
    
    public void edit(Activity activity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(activity);
        transaction.commit();
        session.close();
    }
    
    public void delete(Activity activity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(activity);
        transaction.commit();
        session.close();
    }
    
    public Activity getActivityById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Activity where idatividade=:id")
                .setParameter("id", id)
                .list();
         transaction.commit();
         session.close();
        return (Activity) list.get(0);
    }
    
    public List getAllActivities(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Activity")
                .list();
        transaction.commit();
        session.close();
        return list;
    }
}

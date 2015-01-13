/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.dao;

import eventmanager.model.Event;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Murilo
 */
public class EventDAO {
    
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();;
    
   public void add(Event event){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(event);
        transaction.commit();
        session.close();
    }
    
    public void edit(Event event){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(event);
        transaction.commit();
        session.close();
    }
    
    public void delete(Event event){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(event);
        transaction.commit();
        session.close();
    }
    
    public Event getEventById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Event where id= :id")
                .setParameter("id", id)
                .list();
         transaction.commit();
         session.close();
        return (Event) list.get(0);
    }
    
    public List getEventsByString(String str){
                Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Event where nome like :str")
                .setParameter("str", str)
                .list();
         transaction.commit();
         session.close();
        return list;
    }
    
    public List getAllEvents(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Event")
                .list();
        transaction.commit();
        session.close();
        return list;
    }
}

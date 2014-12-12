/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.dao;

import eventmanager.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Murilo
 */
public class UserDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public void add(User user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
    
    public void edit(User user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }
    
    public void delete(User user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
    
    public User getUserById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from User where iduser= :id")
                .setParameter("id", id)
                .list();
        transaction.commit();
        session.close();
        return (User) list.get(0);
    }
    
    public User getUserByUsername(String username){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from User where username= :username")
                .setParameter("username", username)
                .list();
        transaction.commit();
        session.close();
        if(list.isEmpty()){
            return null;
        }
        return (User) list.get(0);
    }
    
    public List getAllUsers(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from User")
                .list();
        transaction.commit();
        session.close();
        return list;
    }
}

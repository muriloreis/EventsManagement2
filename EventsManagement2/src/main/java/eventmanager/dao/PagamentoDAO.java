/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmanager.dao;

import eventmanager.model.Event;
import eventmanager.model.Pagamento;
import eventmanager.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Murilo
 */
public class PagamentoDAO {
    
     private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public void add(Pagamento pagamento){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(pagamento);
        transaction.commit();
        session.close();
    }
    
    public void edit(Pagamento pagamento){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(pagamento);
        transaction.commit();
        session.close();
    }
    
    public void delete(Pagamento pagamento){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(pagamento);
        transaction.commit();
        session.close();
    }
    
    public Pagamento getPagamentoById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Pagamento where id= :id")
                .setParameter("id", id)
                .list();
        transaction.commit();
        session.close();
        return (Pagamento) list.get(0);
    }
    
    public List getPagamentoByUser(User user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Pagamento where cliente_iduser=:id")
                .setParameter("id", user.getIduser())
                .list();
        transaction.commit();
        session.close();
        return list;
    }
    
    public List getPagamentoByEvento(Event event){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Pagamento where recebedor_idevento=:id")
                .setParameter("id", event.getId())
                .list();
        transaction.commit();
        session.close();
        return list;
    }
    
    public List getAllPagamentos(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List list = session.createQuery("from Pagamento")
                .list();
        transaction.commit();
        session.close();
        return list;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp01practica01;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author francisco
 */
public class DaoVenta implements IDAOgeneral<Venta> {
SessionFactory sf=   HibernateUtil.getSessionFactory();
    @Override
    public boolean Save(Venta venta) {
             Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(venta);
        
        for (Detalleventa det : venta.getDetalleVenta()){
        session.save(det);
        }
        
        
        transaction.commit();
        return true;
    }

    @Override
    public boolean Edit(Venta venta) {
         Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(venta);
        transaction.commit();
        return true;
    }

    @Override
    public boolean Delete(long id) {
           Session session = sf.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Venta venta = session.get(Venta.class, id);
        session.delete(venta);
        transaction.commit();
        return true;
    }

    @Override
    public List<Venta> Findbyid(long id) {
          Session session = sf.getCurrentSession();
    Transaction transaction = null;
    List<Venta> resultList = null;

    try {
        transaction = session.beginTransaction();

        // Utilizamos una consulta HQL para buscar objetos por su identificador
        String hql = "FROM Venta WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        
        // Ejecutamos la consulta y obtenemos la lista de resultados
        resultList = query.getResultList();

        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }

    return resultList;
    }

    @Override
    public List<Venta> FindAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

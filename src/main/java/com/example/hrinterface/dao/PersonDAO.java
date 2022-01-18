package com.example.hrinterface.dao;

import com.example.hrinterface.entity.Employee;
import com.example.hrinterface.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public Person findPersonByID(int ID){
        Session session = getCurrentSession();
        Query query = session.createQuery("From Person p WHERE p.id = :ID");
        query.setParameter("ID", ID);
        Person person = (Person) query.getSingleResult();
        return person;
    }
}

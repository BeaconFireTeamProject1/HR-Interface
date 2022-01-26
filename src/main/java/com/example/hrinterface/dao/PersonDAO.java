package com.example.hrinterface.dao;

import com.example.hrinterface.entity.Employee;
import com.example.hrinterface.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class PersonDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);

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

    public void updateName(int id, String[] names){
        Session session = getCurrentSession();
        session.beginTransaction();
        Person person = findPersonByID(id);
        person.setFirstName(names[0]);
        person.setLastName(names[1]);
        session.update(person);
        session.getTransaction().commit();
    }

    public int createPerson(Person person){
        Session session = getCurrentSession();
        Serializable id = session.save(person);
        logger.info("New Person created with ID " + id);
        return (int)id;
    }

    public Person findPersonByUserID(int ID){
        Session session = getCurrentSession();
        Query query = session.createQuery("From Person p WHERE p.userID = :ID");
        query.setParameter("ID", ID);
        Person person = (Person) query.getSingleResult();
        return person;
    }
}

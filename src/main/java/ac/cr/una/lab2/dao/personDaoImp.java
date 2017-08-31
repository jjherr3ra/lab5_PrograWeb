/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.dao;

import ac.cr.una.lab2.model.Person;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MACJuanJara
 */
public class personDaoImp implements personDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void add(Person person) {
         sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public List<Person> listPeople() {
        @SuppressWarnings("unchecked")
        TypedQuery<Person> query=sessionFactory.getCurrentSession().createQuery("from Person");
        return query.getResultList();
    }
    
}

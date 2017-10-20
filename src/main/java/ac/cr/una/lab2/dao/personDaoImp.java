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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author MACJuanJara
 */
@Repository
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

    @Override
    public Person update(Long idPerson, Person person) {
        Person personUpdated = getPersonById(idPerson);

        if (personUpdated != null) {
            sessionFactory.getCurrentSession().merge(person);
        } else {
            person = null;
        }

        return person;
    }


    @Override
    public Person getPersonById(Long idPerson) {
        Person person = (Person) sessionFactory.getCurrentSession().get(Person.class, idPerson);
        return person;
    }

    @Override
    public boolean deleteById(Long idPerson) {
        boolean isDeleted = false;
        Person person = getPersonById(idPerson);

        if (person != null) {
            sessionFactory.getCurrentSession().delete(person);
            isDeleted = true;
        }

        return isDeleted;
    }

    @Override
    public Person getPersonbyName(String name) {
        Person person = (Person) sessionFactory.getCurrentSession().get(Person.class, name);
        return person;
    }

}

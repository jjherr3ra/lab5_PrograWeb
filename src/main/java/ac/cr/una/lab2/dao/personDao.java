/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.dao;

import ac.cr.una.lab2.model.Person;
import java.util.List;

/**
 *
 * @author MACJuanJara
 */
public interface personDao {
    void add(Person person);
    List<Person> listPeople();
    Person update (Long idPerson, Person person);
    Person getPersonById (Long idPerson);
    boolean deleteById (Long idPerson);
    Person getPersonbyName(String name);
    
}

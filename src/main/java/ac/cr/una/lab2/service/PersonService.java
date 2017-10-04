/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.service;

import ac.cr.una.lab2.model.Person;
import java.util.List;

/**
 *
 * @author MACJuanJara
 */
public interface PersonService {
    void add(Person person);
    List<Person> listPeople();
    Person getPersonById (Long idPerson);
    Person update (Long idPerson, Person person);
    boolean deleteById (Long idPerson);
}

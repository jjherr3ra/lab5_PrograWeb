/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funtional;

import ac.cr.una.lab2.model.PassportDetail;
import ac.cr.una.lab2.model.Person;
import ac.cr.una.lab2.service.PersonService;
import ac.cr.una.lab2.config.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.assertNotNull;



/**
 *
 * @author MACJuanJara
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSpringHibernateLab2 {
    private static AnnotationConfigApplicationContext context = null;
    private static PersonService personService = null;

    public TestSpringHibernateLab2() {

    }

    @Before
    public void setUp() throws Exception {

        context = new AnnotationConfigApplicationContext(AppConfig.class);
        personService = context.getBean(PersonService.class);
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }

    @Test
    public void test1() throws Exception {

        // Add Users
        personService.add(new Person("Juan Jara",new PassportDetail("402180615")));
        personService.add(new Person("Ana Beatriz Herrera",new PassportDetail("204210090")));
        personService.add(new Person("Daniela Jara",new PassportDetail("403450568")));
        personService.add(new Person("Luis Jara",new PassportDetail("400910678")));

       
        
        
        // Get Users
        List<Person> persons = personService.listPeople();
        for (Person person : persons) {
            System.out.println("Id = "+person.getId());
            System.out.println("First Name = "+person.getName());
            System.out.println("Passport # = "+person.getPassportno().getPassportno());
            System.out.println();

            assertNotNull(person.getId());
        }


    }
}

package ac.cr.una.lab2.controller;

import ac.cr.una.lab2.model.PassportDetail;
import ac.cr.una.lab2.model.Person;
import ac.cr.una.lab2.service.PassportDetailService;
import ac.cr.una.lab2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class WebServiceController {
    @Autowired
    PersonService personService;

    @Autowired
    PassportDetailService passportService;

    @GetMapping("/people")
    public List<Person> getPeople() {
        List<Person> listUsers = personService.listPeople();

        return  listUsers;
    }

    @GetMapping("/passports")
    public List<PassportDetail> getPassports() {
        List<PassportDetail> listPassports = passportService.listPassports();

        return  listPassports;
    }

    @GetMapping("/people/{id}")
    public ResponseEntity getPerson(@PathVariable("id") Long id) {
        Person user = personService.getPersonById(id);

        if(user == null) {
            return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }


    @GetMapping("/passports/{id}")
    public ResponseEntity getPassport(@PathVariable("id") Long id) {
        PassportDetail passport = passportService.getById(id);

        if(passport == null) {
            return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(passport, HttpStatus.OK);
    }


    @PostMapping(value = "/people")
    public ResponseEntity createPerson(@RequestBody Person person) {

        personService.add(person);

        return new ResponseEntity(person, HttpStatus.OK);
    }

    @PostMapping(value = "/passports")
    public ResponseEntity createPassport(@RequestBody PassportDetail passport) {

        passportService.add(passport);

        return new ResponseEntity(passport, HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        boolean isDeleted = personService.deleteById(id);

        if (!isDeleted) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(id, HttpStatus.OK);

    }


    @DeleteMapping("/passports/{id}")
    public ResponseEntity deletePassport(@PathVariable Long id) {
        boolean isDeleted = passportService.deleteById(id);

        if (!isDeleted) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/people/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Person person) {

        person = personService.update(id, person);

        if (null == person) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(person, HttpStatus.OK);
    }

    @PutMapping("/passports/{id}")
    public ResponseEntity updatePassport(@PathVariable Long id, @RequestBody PassportDetail passport) {

        passport = passportService.update(id, passport);

        if (null == passport) {
            return new ResponseEntity("No user found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(passport, HttpStatus.OK);
    }


}

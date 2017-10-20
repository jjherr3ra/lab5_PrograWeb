package ac.cr.una.lab2.config;

import ac.cr.una.lab2.dao.personDao;
import ac.cr.una.lab2.dao.passportDetailDao;
import ac.cr.una.lab2.model.Person;
import ac.cr.una.lab2.model.PassportDetail;
import ac.cr.una.lab2.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent>{

    private boolean alreadySetup = false;

    @Autowired
    private personDao personDao;

    @Autowired
    private passportDetailDao passportDao;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){

        Person personAdmin = personDao.getPersonbyName("admin");

        if ((!alreadySetup) && (personAdmin == null)) {

            Set<Role> rolesAdmin =  new HashSet<Role>();
            createRoleIfNotFound("ROLE_ADMIN");
            createRoleIfNotFound("ROLE_USER");

        }

    }

}

package ac.cr.una.lab2.config;

import ac.cr.una.lab2.dao.RoleDao;
import ac.cr.una.lab2.dao.personDao;
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

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent>{

    private boolean alreadySetup = false;

    @Autowired
    private personDao personDao;

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){

        Person personAdmin = personDao.getPersonbyName("admin");

        if ((!alreadySetup) && (personAdmin == null)) {

            Set<Role> adminRole =  new HashSet<Role>();
            createRoleIfNotFound("ROLE_ADMIN");
            createRoleIfNotFound("ROLE_USER");

            final Role personRole = roleDao.findByAuthority("ROLE_ADMIN");
            adminRole.add(personRole);
            final Person person = new Person();
            person.setName("Juan");
            person.setPassportno(new PassportDetail("402180615"));

            personDao.add(person);

            final Role userRole = roleDao.findByAuthority("ROLE_USER");
            Set<Role> rolesUser =  new HashSet<Role>();
            rolesUser.add(userRole);

        }

    }


    private Role createRoleIfNotFound(final String authority) {
        Role role = roleDao.findByAuthority(authority);
        if (role == null) {
            role = new Role(authority);
            roleDao.add(role);
        }
        return role;
    }

}

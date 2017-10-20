package ac.cr.una.lab2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.Authentication;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String authority;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Person> persons;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public Role(String authority, Set<Person> persons) {
        this.authority = authority;
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setUsers(Set<Person> persons) {
        this.persons = persons;
    }

}

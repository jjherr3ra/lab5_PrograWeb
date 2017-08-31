/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.model;

/**
 *
 * @author MACJuanJara
 */

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "person")
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "name")
    private String name;
    
    @JoinColumn(name = "passport_detail_id")
    @OneToOne
    private PassportDetail passportno;

    public Person(String name, PassportDetail passportno) {
        this.name = name;
        this.passportno = passportno;
    }

    public Person() {
       
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public PassportDetail getPassportno() {
        return passportno;
    }

    public void setPassportno(PassportDetail passportno) {
        this.passportno = passportno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.passportno);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.passportno, other.passportno)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Person{" + 
                "id=" + id + '\'' +
                ", name=" + name + '\'' +
                ", passport_detail="  + passportno.getPassportno() +'\'' +
                '}';
    }

}

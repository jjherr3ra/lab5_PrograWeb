/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.model;

/**
 *
 * @author MACJuanJara
" */
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "passport_detail")
public class PassportDetail {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "passportno")
    private String passportno;
   

    public PassportDetail(String passportno) {
        this.passportno = passportno;
    }

    public PassportDetail() {
       
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.passportno);
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
        final PassportDetail other = (PassportDetail) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.passportno, other.passportno)) {
            return false;
        }
        return true;
    }

  
    
    @Override
    public String toString() {
        return "PassportDetail{" + "id=" + id + ", passportno=" + passportno + '}';
    }
 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab2.dao;

import ac.cr.una.lab2.model.PassportDetail;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MACJuanJara
 */
@Repository
public class passportDetailDaoImp implements passportDetailDao{

    @Autowired
    private SessionFactory sessionFactory;

    
    @Override
    public void add(PassportDetail passport) {
        sessionFactory.getCurrentSession().save(passport);
    }

    @Override
    public List<PassportDetail> listPassports() {
        @SuppressWarnings("unchecked")
        TypedQuery<PassportDetail> query=sessionFactory.getCurrentSession().createQuery("from PassportDetail");
        return query.getResultList();
    }
    
}

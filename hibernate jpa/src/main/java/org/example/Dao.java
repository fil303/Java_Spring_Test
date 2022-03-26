package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository("Dao")
@Transactional
public class Dao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(User person) {
        hibernateTemplate.save(person);
    }

   // public User findByPrimaryKey(int id) {
       // User person = HibernateTemplate.find(User.class, id);

       // return person;
    //}

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}

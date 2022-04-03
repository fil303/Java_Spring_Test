package org.example.dao;

import org.example.model.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class empImp implements empDao{
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    @Override
    public boolean save(Employe emp) {
        this.hibernateTemplate.save(emp);
        return true;
    }
    @Transactional
    @Override
    public boolean update(Employe emp) {
        this.hibernateTemplate.update(emp);
        return true;
    }
    @Transactional
    @Override
    public boolean delete(Employe emp) {
        this.hibernateTemplate.delete(emp);
        return true;
    }

    @Override
    public Employe first(int id) {
        return hibernateTemplate.get(Employe.class, id);
    }

    @Override
    public List<Employe> get() {
        return this.hibernateTemplate.loadAll(Employe.class);
    }
}

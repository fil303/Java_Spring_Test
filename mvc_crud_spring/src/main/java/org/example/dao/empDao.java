package org.example.dao;

import org.example.model.Employe;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface empDao {
    boolean save(Employe emp);
    boolean update(Employe emp);
    boolean delete(Employe emp);
    Employe first(int id);
    List<Employe> get();
}

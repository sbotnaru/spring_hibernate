package com.endava.demo.dao;

import com.endava.demo.entity.Intern;

import java.util.List;

public interface InternDAO {
    List<Intern> findAll();

    void save(Intern intern);

    void delete(int id);

    void update(Intern intern, int id);

    Intern getObjectById(int id);

}

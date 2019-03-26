package com.endava.demo.service;

import com.endava.demo.entity.Intern;

import java.util.List;

public interface InternService {
    public List<Intern> getAllInterns();

    public void add(Intern intern);

    public void remove(int id);

    void update(Intern intern,int id);
    int getIdOfObjFromList(int id);
    Intern getObjectById(int id);

    int ObjectIdFromList(Intern intern);
}

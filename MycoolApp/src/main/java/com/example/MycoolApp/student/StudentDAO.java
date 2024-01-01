package com.example.MycoolApp.student;

import java.util.List;

public interface StudentDAO {
    void save(StudentEntity theStudent);

    StudentEntity findById(Integer id);

    List<StudentEntity> findAll();

    List<StudentEntity> findByLastName(String lastName);

    void update(StudentEntity theStudent);

    void delete(Integer id);

    int deleteAll();

}

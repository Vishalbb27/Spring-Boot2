package com.example.MycoolApp.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(StudentEntity theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public StudentEntity findById(Integer id) {
        return  entityManager.find(StudentEntity.class,id);
    }

    @Override
    public List<StudentEntity> findAll() {
        TypedQuery<StudentEntity> theQuery = entityManager.createQuery("FROM StudentEntity",StudentEntity.class);

        return theQuery.getResultList();
    }

    @Override
    public List<StudentEntity> findByLastName(String lastName) {
        //Create query
        TypedQuery<StudentEntity> theQuery = entityManager.createQuery("FROM StudentEntity WHERE lastName=:theData",StudentEntity.class); //Named Parameters

        //set query parameter
        theQuery.setParameter("theData",lastName);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional //Making updates so add this annotation
    public void update(StudentEntity theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        StudentEntity student = entityManager.find(StudentEntity.class,id);

        //delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted= entityManager.createQuery("DELETE  FROM  StudentEntity").executeUpdate();
        return numRowsDeleted;
    }
}

package com.example.repository;

import com.example.model.Feedback;
import com.example.model.Picture;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class PictureRepository implements IPictureRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean create(Picture picture) {
        entityManager.persist(picture);
        return true;
    }

    @Override
    public boolean update(Picture picture) {
        entityManager.merge(picture);
        return true;
    }

    @Override
    public Picture findById(int id) {
        return entityManager.find(Picture.class, id);
    }

    @Override
    public List<Picture> findAll() {
        return entityManager.createQuery("From Picture ").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        entityManager.remove(findById(id));
        return true;
    }
    public Picture findByToday(LocalDate today) {
        TypedQuery<Picture> query = entityManager.createQuery("SELECT p FROM Picture p WHERE p.today = :today", Picture.class);
        query.setParameter("today", today);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

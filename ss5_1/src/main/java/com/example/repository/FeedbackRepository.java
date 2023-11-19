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
public class FeedbackRepository implements IFeedbackRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Feedback findByToday(LocalDate today) {
        TypedQuery<Feedback> query = entityManager.createQuery("SELECT p FROM Feedback p WHERE p.today = :today", Feedback.class);
        query.setParameter("today", today);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean create(Feedback feedback) {
        entityManager.persist(feedback);
        return true;
    }

    @Override
    public boolean update(Feedback feedback) {
        entityManager.merge(feedback);
        return true;
    }

    @Override
    public Feedback findById(int id) {
        return entityManager.find(Feedback.class, id);
    }

    @Override
    public List<Feedback> findAll() {
        return entityManager.createQuery("From Feedback ").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        entityManager.remove(findById(id));
        return true;
    }
}

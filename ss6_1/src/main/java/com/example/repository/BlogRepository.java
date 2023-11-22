package com.example.repository;

import com.example.model.Blog;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean create(Blog blog) {
        entityManager.persist(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        entityManager.merge(blog);
        return true;
    }

    @Override
    public Blog findById(int id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public List<Blog> findAll() {
        return entityManager.createQuery("From Blog ").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        entityManager.remove(findById(id));
        return true;
    }
}

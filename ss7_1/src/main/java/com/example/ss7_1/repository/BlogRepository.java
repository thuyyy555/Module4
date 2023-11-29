package com.example.ss7_1.repository;
import com.example.ss7_1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    public List<Blog> findAllByTitleContaining(String name);
    public List<Blog> findAllByCategory_CategoryId(int id);
    @Query("From Blog p where p.title like :name")
    public List<Blog> search(@Param("name") String name);

}

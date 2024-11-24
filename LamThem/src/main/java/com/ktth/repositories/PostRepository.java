package com.ktth.repositories;

import com.ktth.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    @Query("SELECT p FROM Post p WHERE " +
            "CAST(p.id AS string) = :keyword OR " +
            "p.title LIKE %:keyword% OR " +
            "p.content LIKE %:keyword% OR " +
            "p.comment LIKE %:keyword% OR " +
            "p.author LIKE %:keyword%")
    List<Post> searchByKeyword(@Param("keyword") String keyword);
}

package com.example.rest.greeting.repository;

import com.example.rest.greeting.entity.Posts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
	//SELECT * FROM posts WHERE slug=?
	Optional<Posts> findBySlug(String slug);

	//SELECT * FROM posts WHERE title=?
    Optional<Posts> findByTitle(String title);
    
    //DELETE FROM posts WHERE title=?
    @Transactional
    void deleteByTitle(String title);
    
	//SELECT * FROM posts WHERE body LIKE %?%
    List<Posts> findAllByBodyContainsIgnoreCase(String body);

}

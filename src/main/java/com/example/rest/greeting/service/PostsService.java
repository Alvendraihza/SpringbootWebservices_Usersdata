package com.example.rest.greeting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rest.greeting.entity.Posts;
import com.example.rest.greeting.repository.PostsRepository;

@Service
public class PostsService {
	@Autowired
	private PostsRepository postRepository;
	
	public List<Posts> getPosts() {
		//SELECT * FROM posts
		return postRepository.findAll(Sort.by("slug").descending());
	}
	
	public Posts getPost(String slug) {
		if (postRepository.findBySlug(slug).isPresent()){
			return postRepository.findBySlug(slug).get();
		}
		else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Post [slug=" + slug + "] is not found!");
		}
	}
	
	public List<Posts> getPostsWithBody(String body) {
		return postRepository.findAllByBodyContainsIgnoreCase(body);
	}
	
	public Posts getPostByTitle(String title) {
		if (postRepository.findByTitle(title).isPresent()) {
			return postRepository.findByTitle(title).get();
		}
		else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Post [title=" + title + "] is not found!");
		}				
	}
	
	public Posts createPost(Posts posts) {
		Optional<Posts> postOptional = postRepository.findByTitle(posts.getTitle());
		
		if (postOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Same Title Available");
		}
		else {
			//INSERT INTO posts VALUES (posts.slug, post.title, post.body)
	        postRepository.save(posts);
	        // return postRepository.findBySlug(posts.getSlug()).get();
	        throw new ResponseStatusException(HttpStatus.OK, "Post successfully created!");
		}
	}

	public Posts editPost(Posts posts, Long id) {
		Optional<Posts> postOptional = postRepository.findById(id);
		
		if (postOptional.isPresent()) {
			postRepository.save(posts);
			// return postOptional.get();
			throw new ResponseStatusException(
				HttpStatus.OK, "Post [id=" + posts.getId() + "] successfully updated!");

		}
		else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Post [id=" + posts.getId() + "] is not found!");
		}

		// return postRepository.findById(id)
		// .map(emp -> {
		// 	emp.setSlug(posts.getSlug());
		// 	emp.setTitle(posts.getTitle());
		// 	emp.setBody(posts.getBody());
		// 	postRepository.save(posts);
		// })
		// .orElseThrow(() -> new ResponseStatusException(
		// 	HttpStatus.NOT_FOUND, "Post [id=" + posts.getId() + "] is not found!"
		// ));
	}
	
	public void deletePostById(Long id) {
		if (postRepository.findById(id).isPresent()) {
			//DELETE FROM posts WHERE id=?
			postRepository.deleteById(id);

			throw new ResponseStatusException(HttpStatus.OK, "Post [id=" + id + "] succesfully removed!");
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post [id=" + id + "] is not found!");
		}
	}
	
	public void deletePostBySlug(String slug) {
		if (postRepository.findBySlug(slug).isPresent()){
			Posts postBySlug = postRepository.findBySlug(slug).get();
			
			postRepository.deleteById(postBySlug.getId());
			
    		throw new ResponseStatusException(
    				HttpStatus.OK, "Post [slug=" + slug + "] succesfully removed!");
		}
    	else
    		throw new ResponseStatusException(
    				HttpStatus.NOT_FOUND, "Post [slug=" + slug + "] is not found!");
	}
	
	public void deletePostByTitle(String title) {
		if (postRepository.findByTitle(title).isPresent()) {
			postRepository.deleteByTitle(title);
			
			throw new ResponseStatusException(
    				HttpStatus.OK, "Post [title=" + title + "] succesfully removed!");
		}
    	else
    		throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Post [title=" + title + "] is not found!");
	}
}

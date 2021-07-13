package com.example.rest.greeting.controller;

import java.util.List;

import com.example.rest.greeting.entity.Posts;
import com.example.rest.greeting.service.PostsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostsController {

	private final PostsService postService;

	//Constructor
	public PostsController(PostsService postsService) {
		this.postService = postsService;
	}
    
    @GetMapping("/all")
    public List<Posts> getAll() {
        return postService.getPosts();
    }

    @GetMapping("/get/{slug}")
    public Posts getPost(@PathVariable final String slug){
        return postService.getPost(slug);
    }

    @GetMapping("/title/{title}")
    public Posts getPostByTitle(@PathVariable final String title){
        return postService.getPostByTitle(title);
    }

    @GetMapping("/get_by_body/{body}")
    public List<Posts> getByBody(@PathVariable final String body) {
    	return postService.getPostsWithBody(body);
    }

    @PostMapping("/create")
    // public Posts create(@RequestBody final Posts posts){
    public void create(@RequestBody final Posts posts){
    	// return postService.createPost(posts);
    	postService.createPost(posts);
    }

    @PutMapping("/edit/{id}")
    public void edit(@RequestBody final Posts posts, @PathVariable final Long id){
    	postService.editPost(posts, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable final Long id){
        postService.deletePostById(id);
    }
    
    @DeleteMapping("/delete_slug/{slug}")
    public void delete(@PathVariable final String slug){
    	postService.deletePostBySlug(slug);
    }

    @DeleteMapping("/delete_title/{title}")
    public void delete_title(@PathVariable final String title){
    	postService.deletePostByTitle(title);
    }
}

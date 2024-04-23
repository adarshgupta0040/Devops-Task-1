package com.nagarro.librest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.librest.dao.AuthorRepo;
import com.nagarro.librest.entities.Author;



@RestController
public class AuthorController {

	@Autowired
	AuthorRepo repo;
	
	@PostMapping(path="/author",consumes= {"application/json"})
	public void addAuthor(@RequestBody Author author) 
	{
		repo.save(author);
		
	}
	
	@PutMapping(path="/author",consumes= {"application/json"})
	public void saveOrUpdateAuthor(@RequestBody Author author) 
	{
		repo.save(author);
		
	}
	
	@GetMapping(path="/author")
	public List<Author> getAuthors()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/author/{name}")
	public Optional<Author> getAuthor(@PathVariable("name") String name)
	{
		return repo.findById(name);

	}
	
	@DeleteMapping("/author/{name}")
	public void deleteAuthor(@PathVariable("name") String name)
	{
		Author a=repo.getById(name);
		repo.delete(a);
		
	}
}

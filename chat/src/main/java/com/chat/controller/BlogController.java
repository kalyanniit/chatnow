package com.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.BlogDao;
import com.chat.model.Blog;

@RestController
public class BlogController {
	@Autowired
	BlogDao blogDao;
	@RequestMapping(value="/addBlog",headers="Accept=application/json",method=RequestMethod.POST)
	public void addBlog(@RequestBody Blog blog)
	{
		blogDao.addBlog(blog);
	}
	@RequestMapping(value="/viewBlogs",headers="Accept=application/json",method=RequestMethod.GET)
	public List<Blog> viewBlogs(@RequestParam("name") String name)
	{
		System.out.print("given name:"+name);
		return blogDao.viewBlogs(name);
		
		//return blogDao.viewBlogs();
	}
	@RequestMapping(value="/viewAllBlogs",headers="Accept=application/json",method=RequestMethod.GET)
	public List<Blog> viewAllBlogs()
	{
		return blogDao.viewBlogs();
	}
	@RequestMapping(value="/updateBlog",headers="Accept=application/json",method=RequestMethod.PUT)
	public void updateBlog(@RequestBody Blog blog)
	{
		System.out.println("Inside update blog");
		blogDao.updateBlog(blog);
	}
	@RequestMapping(value="/deleteBlog/{id}",headers="Accept=application/json",method=RequestMethod.DELETE)
	public void deleteJob(@PathVariable int id)
	{
		blogDao.deleteBlog(id);
	}

}

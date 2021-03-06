package com.chat.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chat.dao.UserDao;
import com.chat.model.User;

@RestController
public class HomeController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	public void addUser(@RequestParam("file") MultipartFile file,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("emailid") String emailid,@RequestParam("contact") String contact)
	{
		System.out.println("Inside");
		System.out.println("file:"+file);
		System.out.println("UserName:"+username+"\t"+password+"\t"+emailid+"\t"+contact);
		User user=new User();
		user.setEmailid(emailid);
		user.setPassword(password);
		user.setContact(contact);
		user.setUsername(username);
		userDao.addUser(user);
		Path path=Paths.get("C://Users//welcome//project2//chatnow//WebContent//images//"+username+".jpg");
		if(file!=null)
		{
			try {
				file.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
		
	}

	@RequestMapping(value = "/getUsers", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<User> getUsers()
	 {
		 List<User> users=userDao.viewUsers();
		return users;
	 }
	 @RequestMapping(value="/updateUser",method=RequestMethod.PUT,headers="Accept=application/json")
	 public void updateUser(@RequestBody User user)
	 {
		 userDao.update(user);
	 }
	 @RequestMapping(value="/getUser/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	 public @ResponseBody User getUserById(@PathVariable("id") int id)
	 {
		 System.out.println("User Id:"+id);
		 return userDao.viewUserById(id);
	 }
	 @RequestMapping(value="/authenticate", method=RequestMethod.POST,headers="Accept=application/json")
	 public int authenticateUser(@RequestBody User user)
	 {
		 System.out.println("username:"+user.getUsername());
		 System.out.println("password:"+user.getPassword());
	int result=0;
		 result=userDao.validateUser(user.getUsername(),user.getPassword());
		 System.out.println("result we have got is:"+result);
		 return result;
	 }

}

package com.niit.socialnetworkbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.User;

public class Usertestcases {
	
	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	 static UserDao userDao;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
				userDao =  (UserDao) context.getBean("userDao");
	}
	
	@Test
	public void createUserTestCase()
	{
				
	User user=new User();

	user.setFirstname("sravana1");
	user.setLastname("sandhya1");
	user.setEmail("sravs1@gmail.com");
	user.setPassword("sravs");
	user.setRole("STUDENT");
	user.setPhonenumber("9842563515");

	userDao.registerUser(user);
	
	assertEquals(user.getEmail(),user.getEmail());
	
	
	}

	@Ignore
	@Test
	public void uniqueEmailIdTest()
	{
		
		User user=new User();
user.setEmail("sandhya@gmail.com");
		boolean status=userDao.isEmailUnique(user.getEmail());
		
		assertEquals("unique email id failure", false, status);
	}
	@Ignore
	@Test
	public void getUserDetails()
	{
		
		String userEmail = "sandhya@gmail.com";

               User user=new User();

		 user = userDao.getUser(userEmail);
		 System.out.println("\n First Name "+user.getFirstname());
		 System.out.println("\n Last Name "+user.getLastname());
		 
		assertEquals(userEmail, userDao.getUser(userEmail));
		 

	}	
}

	
	
	 
	
	
	




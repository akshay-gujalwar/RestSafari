package com.in28minutes.rest.services.restfulwebservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<User>();
	private static int userCount=4;
	
	static{
		users.add(new User(1,"aksh",new Date()));
		users.add(new User(2,"aish",new Date()));
		users.add(new User(3,"viks", new Date()));
		users.add(new User(4,"ron", new Date()));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User save(User user)
	{
		if(user.getId()==null)
		{
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id)
	{
		User user = null;
		try {
			user = users.stream().filter(u->u.getId()==id).findFirst().get();
		}
		catch(Exception e)
		{
			return user;
		}
		return user;
	}
	public void exceptionCheck()
	{
		throw new UserNotFoundException("excetion checking ");
	}
	
	public User deleteUser(int id)
	{
		User user = null;
		Iterator<User> itr = users.iterator();
		while(itr.hasNext())
		{
			user = itr.next();
			if(user.getId()==id)
			{
				itr.remove();
				return user;
			}
		}
		return null;
	}
}

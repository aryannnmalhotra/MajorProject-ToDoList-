package com.ncu.validators;
import com.ncu.exceptions.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;	
 public class NameValidator
 {
 	public String userName;
 	public String password;	
 	public boolean nameValidator(String userName,String password)
 	{
		boolean res = true;
		try
		{
			EmptyUserName(userName);

		}
		catch(EmptyUserNameException e)
		{
			res = false;
            System.out.println(e.getMessage());
		}
		try
		{
			SpecialUserName(userName);

		}
		catch(SpecialCharacterUserNameException e)
		{
			res = false;
            System.out.println(e.getMessage());
		}

		try
		{
			PassLength(password);

		}
		catch(PassLengthException e)
		{
			res = false;
            System.out.println(e.getMessage());
		}
		try
		{
			SpecialCharPass(password);

		}
		catch(SpecialCharacterPassException e)
		{
			res = false;
            System.out.println(e.getMessage());
		}
		try
		{
			NumPass(password);

		}
		catch(PassNumException e)
		{
			res = false;
            System.out.println(e.getMessage());
		}
		
		try
		{
			CapPass(password);

		}
		catch(CapAlphaPassException e)
		{
			res = false;
            System.out.println(e.getMessage());
		}
			

		return res;
	}
		
	public  void EmptyUserName(String userName) throws EmptyUserNameException
	{
		if(userName=="")
			throw new EmptyUserNameException("User Name cannot be empty");
	}
	
	public  void SpecialUserName(String userName) throws SpecialCharacterUserNameException
	{	

		Pattern patternget = Pattern.compile("`~[@#$%^&(,)!*-+={}:<>?/._]");
		Matcher check = patternget.matcher(userName);
		boolean finalValue = check.find();
		if(finalValue == true)
			throw new SpecialCharacterUserNameException("Username cannot contain special character");
	}
		public  void PassLength(String password) throws PassLengthException
	{
		int passLength = 8;
		String namelength = password;
		if(namelength.length()<passLength)
			throw new PassLengthException("Password's length is less than 8 characters!");
	}

	public  void SpecialCharPass(String password) throws SpecialCharacterPassException
	{		
		Pattern patternget = Pattern.compile("`~[@#$%^&(,)!*-+={}:<>?/._]");
		Matcher check = patternget.matcher(password);
		boolean f = check.find();
		if(f == true)	
			throw new SpecialCharacterPassException("Password should contain a special character!");
	}
	public  void NumPass(String password) throws PassNumException
	{		
		Pattern patternget = Pattern.compile("1234567890");
		Matcher check = patternget.matcher(password);
		boolean v = check.find();
		if(v == true)	
			throw new PassNumException("Password should contain numbers!");
	}
	public  void CapPass(String password) throws CapAlphaPassException
	{	Pattern patternget = Pattern.compile("QWERTYUIOPASDFGHJKLZXCBVNM");
		Matcher check = patternget.matcher(password);
		boolean z = check.find();
		if(z == true)
			throw new CapAlphaPassException("Password should contain a capital letter!");
	}
			

}

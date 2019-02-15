package com.ncu.exceptions;
import java.lang.*;
public class EmptyUserNameException extends Exception
{
	public EmptyUserNameException(String s)
	{
		super(s);
	}
}
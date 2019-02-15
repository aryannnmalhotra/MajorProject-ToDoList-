package com.ncu.exceptions;
import java.lang.*;
public class SpecialCharacterUserNameException extends Exception
{
	public SpecialCharacterUserNameException(String s)
	{
		super(s);
	}
}
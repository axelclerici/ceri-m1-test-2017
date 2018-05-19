package fr.univavignon.rodeo.impl;

import fr.univavignon.rodeo.api.IAnimal;

public class Animal implements IAnimal
{
	private String name;
	private int xp;
	private boolean isBoss;
	private boolean isSecret;
	private boolean isEndangered;
	private boolean isCaught;
	
	
	public Animal(String name, int xp, boolean isBoss, boolean isEndangered, boolean isSecret)
	{
		this.name = name;
		this.xp = xp;
		this.isBoss = isBoss;
		this.isSecret = isSecret;
		this.isEndangered = isEndangered;
	}
	
	public String getName() 
	{
		return this.name;
	}

	public int getXP() 
	{
		return this.xp;
	}

	public boolean isSecret() 
	{
		return this.isSecret;
	}

	public boolean isEndangered() 
	{
		return this.isEndangered;
	}

	public boolean isBoss() 
	{
		return this.isBoss;
	}

}

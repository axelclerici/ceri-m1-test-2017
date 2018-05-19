package fr.univavignon.rodeo.impl;

import java.util.List;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;

public class Specie implements ISpecie
{
	private String name;
	private int area;
	private List<IAnimal> animals;
	
	public Specie(String name, int area, List<IAnimal> animals)
	{
		this.name = name;
		this.area = area;
		this.animals = animals;
	}
	
	
	public String getName() 
	{
		return this.name;
	}

	public int getArea() 
	{
		return this.area;
	}

	public List<IAnimal> getAnimals() 
	{
		return this.animals;
	}

}

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
	
	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<IAnimal> getAnimals() {
		// TODO Auto-generated method stub
		return null;
	}

}

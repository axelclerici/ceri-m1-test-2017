package fr.univavignon.rodeo.impl;

import java.util.List;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;

public class Environment implements IEnvironment
{
	private String name;
	private int areas;
	private List<ISpecie> species;
	
	public Environment(String name, int areas, List<ISpecie> species)
	{
		this.areas = areas;
		this.name = name;
		this.species = species;
	}
	
	public String getName() 
	{
		return this.name;
	}

	public int getAreas() 
	{
		return this.areas;
	}

	public List<ISpecie> getSpecies() 
	{
		return this.species;
	}
}

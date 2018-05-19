package fr.univavignon.rodeo.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.ISpecieTest;

public class EnvironmentTest 
{
	@Test
	public void testGetAreas()
	{
		Environment environment = new Environment("environment", 5, null);
		assertEquals(5, environment.getAreas());
	}
	
	@Test
	public void testGetSpecies()
	{
		Environment environment = new Environment("environment", 5, buildTestSpecieList());
		assertEquals(5, environment.getSpecies().size());
	}
	
	@Test
	public void testGetName()
	{
		Environment environment = new Environment("environment", 0, null);
		assertEquals("environment", environment.getName());
	}
	
	public static List<ISpecie> buildTestSpecieList()
	{
		List<ISpecie> specieList = new ArrayList<ISpecie>();
		List<IAnimal> animals = new ArrayList<IAnimal>();
		animals.add(new Animal("animal", 0, false, false, false));
		animals.add(new Animal("animal2", 0, false, false, false));
		animals.add(new Animal("animal3", 0, false, false, false));
		specieList.add(new Specie("specie", 1, animals));
		specieList.add(new Specie("specie", 1, animals));
		specieList.add(new Specie("specie", 1, animals));
		specieList.add(new Specie("specie", 1, animals));
		specieList.add(new Specie("specie", 1, animals));
		return specieList;
	}
}

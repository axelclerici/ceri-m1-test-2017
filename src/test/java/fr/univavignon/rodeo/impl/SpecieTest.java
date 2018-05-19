package fr.univavignon.rodeo.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;

public class SpecieTest
{
	public static List<IAnimal> buildAnimalList()
	{
		List<IAnimal> animals = new ArrayList<IAnimal>();
		animals.add(new Animal("animal", 0, false, false, false));
		animals.add(new Animal("animal2", 0, false, false, false));
		animals.add(new Animal("animal3", 0, false, false, false));
		return animals;
	}
	
	@Test
	public void testGetArea() 
	{
		Specie specieTest = new Specie("specie", 42, null);
		assertEquals(42, specieTest.getArea());
	}
	
	@Test
	public void testGetAnimals()
	{
		Specie specieTest = new Specie("specie", 0, buildAnimalList());
		assertEquals(5, specieTest.getAnimals().size());
	}
	
	@Test
	public void testGetName()
	{
		Specie specieTest = new Specie("specie", 0, null);
		assertEquals("specie", specieTest.getName());
	}
}

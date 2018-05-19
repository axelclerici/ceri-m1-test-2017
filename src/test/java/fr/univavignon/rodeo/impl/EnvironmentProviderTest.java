package fr.univavignon.rodeo.impl;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class EnvironmentProviderTest 
{
	@Test
	public void testAvailableEnvironments()
	{
		EnvironmentProvider provider = new EnvironmentProvider();
		assertEquals(5, provider.getAvailableEnvironments().size());
	}
	
	@Test
	public void testGetAnimals()
	{
		EnvironmentProvider provider = new EnvironmentProvider();
		File gorillaFile = new File("animal" + File.separator + "Jungle" + File.separator + "1Gorilla.txt");
		assertEquals(4, provider.getAnimals(gorillaFile).size());
	}
	
	@Test
	public void testGetSpecies()
	{
		EnvironmentProvider provider = new EnvironmentProvider();
		assertEquals(0, provider.getSpecies("Jungle", 6).size());
		assertEquals(3, provider.getSpecies("Jungle", 5).size());
	}
}

package fr.univavignon.rodeo.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;

public class AnimalTest 
{

	@Test 
	public void testXP()
	{
		Animal animal = new Animal("test", 42, false, false, false);
		assertEquals(42, animal.getXP());
	}
	
	@Test 
	public void testBoss() 
	{
		Animal bossAnimal = new Animal("test", 42, true, false, false);
		Animal regularAnimal = new Animal("test2", 42, false, false, false);
		assertEquals(true, bossAnimal.isBoss());
		assertEquals(false, regularAnimal.isBoss());
	}
	
	@Test 
	public void testEndangered() 
	{
		IAnimal endangeredAnimal = new Animal("test", 42, false, true, false);
		IAnimal regularAnimal = new Animal("test2", 42, false, false, false);
		assertEquals(true, endangeredAnimal.isEndangered());
		assertEquals(false, regularAnimal.isEndangered());
	}
	
	@Test 
	public void testSecret() 
	{
		IAnimal secretAnimal = new Animal("test", 42, false, false, true);
		IAnimal regularAnimal = new Animal("test2", 42 ,false, false, false);
		assertEquals(true, secretAnimal.isSecret());
		assertEquals(false, regularAnimal.isSecret());
	}
	
	@Test
	public void testGetName()
	{
		Animal animal = new Animal("test", 42, false, false, false);
		assertEquals("test", animal.getName());
	}
}

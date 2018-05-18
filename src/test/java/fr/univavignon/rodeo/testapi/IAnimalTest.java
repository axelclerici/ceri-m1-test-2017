package fr.univavignon.rodeo.testapi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IAnimal;

public class IAnimalTest 
{
	public static IAnimal getTestAnimal(boolean boss, boolean endangered, boolean secret) 
	{
		IAnimal animalMock = Mockito.mock(IAnimal.class);
		Mockito.when(animalMock.getXP()).thenReturn(42);
		Mockito.when(animalMock.isBoss()).thenReturn(boss);
		Mockito.when(animalMock.isEndangered()).thenReturn(endangered);
		Mockito.when(animalMock.isSecret()).thenReturn(secret);
		return animalMock;
	}
	
	@Test 
	public void testXP()
	{
		IAnimal animal = getTestAnimal(false, false, false);
		assertEquals(42,animal.getXP());
	}
	
	@Test 
	public void testBoss() 
	{
		IAnimal bossAnimal = getTestAnimal(true, false, false);
		IAnimal regularAnimal = getTestAnimal(false, false, false);
		assertEquals(true, bossAnimal.isBoss());
		assertEquals(false, regularAnimal.isBoss());
	}
	
	@Test 
	public void testEndangered() 
	{
		IAnimal endangeredAnimal = getTestAnimal(false, true, false);
		IAnimal regularAnimal = getTestAnimal(false, false, false);
		assertEquals(true, endangeredAnimal.isEndangered());
		assertEquals(false, regularAnimal.isEndangered());
	}
	
	@Test 
	public void testSecret() 
	{
		IAnimal secretAnimal = getTestAnimal(false, false, true);
		IAnimal regularAnimal = getTestAnimal(false, false, false);
		assertEquals(true, secretAnimal.isSecret());
		assertEquals(false, regularAnimal.isSecret());
	}
}

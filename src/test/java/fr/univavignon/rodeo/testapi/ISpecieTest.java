package fr.univavignon.rodeo.testapi;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.ISpecie;

public class ISpecieTest 
{
	public static ISpecie getTestSpecie()
	{
		ISpecie specieMock = Mockito.mock(ISpecie.class);
		Mockito.when(specieMock.getArea()).thenReturn(42);
		Mockito.when(specieMock.getAnimals()).thenReturn(buildTestAnimalList());
		return specieMock;
	}	
	
	@Test
	public void testArea() 
	{
		ISpecie specieTest = getTestSpecie();
		assertEquals(42, specieTest.getArea());
	}
	
	@Test
	public void testAnimals()
	{
		ISpecie specieTest = getTestSpecie();
		assertEquals(5, specieTest.getAnimals().size());
	}
	
	private static List<IAnimal> buildTestAnimalList()
	{
		List<IAnimal> animals = new ArrayList<IAnimal>();
		animals.add(IAnimalTest.getTestAnimal(false, true, false));
		animals.add(IAnimalTest.getTestAnimal(true, false, true));
		animals.add(IAnimalTest.getTestAnimal(false, true, false));
		animals.add(IAnimalTest.getTestAnimal(true, false, true));
		animals.add(IAnimalTest.getTestAnimal(false, true, false));
		return animals;
	}
}

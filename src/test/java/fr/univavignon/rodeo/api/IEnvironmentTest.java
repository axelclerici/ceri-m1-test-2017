package fr.univavignon.rodeo.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.ISpecie;

import java.util.ArrayList;
import java.util.List;

public class IEnvironmentTest 
{
	public static IEnvironment getTestEnvironment()
	{
		IEnvironment environmentMock = Mockito.mock(IEnvironment.class);
		List<ISpecie> specieList = buildTestSpecieList();
		Mockito.when(environmentMock.getAreas()).thenReturn(42);
		Mockito.when(environmentMock.getSpecies()).thenReturn(specieList);
		return environmentMock;
	}
	
	@Test
	public void testGetAreas()
	{
		IEnvironment environmentMock = getTestEnvironment();
		assertEquals(42, environmentMock.getAreas());
	}
	
	@Test
	public void testGetSpecies()
	{
		IEnvironment environmentMock = getTestEnvironment();
		assertEquals(5, environmentMock.getSpecies().size());
	}
	
	public static List<ISpecie> buildTestSpecieList()
	{
		List<ISpecie> specieList = new ArrayList<ISpecie>();
		specieList.add(ISpecieTest.getTestSpecie());
		specieList.add(ISpecieTest.getTestSpecie());
		specieList.add(ISpecieTest.getTestSpecie());
		specieList.add(ISpecieTest.getTestSpecie());
		specieList.add(ISpecieTest.getTestSpecie());
		return specieList;
	}
}

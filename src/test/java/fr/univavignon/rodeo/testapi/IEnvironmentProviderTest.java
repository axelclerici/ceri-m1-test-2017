package fr.univavignon.rodeo.testapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;


public class IEnvironmentProviderTest 
{
	public static IEnvironmentProvider getTestEnvironmentProvider()
	{
		IEnvironmentProvider environmentProviderMock = Mockito.mock(IEnvironmentProvider.class);
		IEnvironment environment = IEnvironmentTest.getTestEnvironment();
		List<String> environmentNames = buildTestEnvironmentNamesList();
		
		Mockito.when(environmentProviderMock.getAvailableEnvironments()).thenReturn(environmentNames);
		Mockito.when(environmentProviderMock.getEnvironment(null)).thenThrow(new java.lang.IllegalArgumentException());
		Mockito.when(environmentProviderMock.getEnvironment("thirdCase")).thenReturn(null);
		Mockito.when(environmentProviderMock.getEnvironment("firstCase")).thenReturn(environment);
		
		return environmentProviderMock;
	}
	
	public static List<String> buildTestEnvironmentNamesList()
	{
		List<String> environmentNamesList = new ArrayList<String>();
		environmentNamesList.add("firstCase");
		environmentNamesList.add("secondCase");
		return environmentNamesList;
	}
	
	@Test
	public void testGetAvailableEnvironments()
	{
		IEnvironmentProvider environmentProviderMock = getTestEnvironmentProvider();
		assertEquals(2, environmentProviderMock.getAvailableEnvironments().size());
		assertEquals("firstCase", environmentProviderMock.getAvailableEnvironments().get(0));
	}
	
	@Test
	public void testGetEnvironment()
	{
		IEnvironmentProvider environmentProviderMock = getTestEnvironmentProvider();
		assertTrue(environmentProviderMock.getEnvironment("firstCase") instanceof IEnvironment);
		assertEquals(null, environmentProviderMock.getEnvironment("thirdCase"));
	}
	
	@Test(expected =  java.lang.IllegalArgumentException.class)
	public void testGetEnvironmentEx()
	{
		IEnvironmentProvider environmentProviderMock = getTestEnvironmentProvider();
		environmentProviderMock.getEnvironment(null);
	}
	
	
}

package fr.univavignon.rodeo.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnvironmentProviderTest 
{
	@Test
	public void testAvailableEnvironments()
	{
		EnvironmentProvider provider = new EnvironmentProvider();
		assertEquals(5, provider.getAvailableEnvironments().size());
	}
}

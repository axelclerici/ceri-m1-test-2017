package fr.univavignon.rodeo.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.rodeo.api.IEnvironment;

public class GameStateTest 
{
	@Test
	public void testGetName()
	{
		GameState gameState = new GameState("name", 0, null, 0, null, null);
		assertEquals("name", gameState.getName());
	}
	
	@Test
	public void testCatchIsPossible()
	{
		EnvironmentProvider envProvider = new EnvironmentProvider();
		IEnvironment env = envProvider.getEnvironment("Jungle");
		GameState gameState = new GameState("name", 50, env, 5, null, null);
		assertEquals(true, gameState.catchIsPossible("Gorilla"));
		assertEquals(false, gameState.catchIsPossible("Llama"));
	}
	
	@Test
	public void testGetProgression()
	{
		GameState gameState = new GameState("name", 42, null, 0, null, null);
		assertEquals(42, gameState.getProgression());
	}
}

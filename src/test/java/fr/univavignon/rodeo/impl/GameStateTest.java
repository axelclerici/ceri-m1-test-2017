package fr.univavignon.rodeo.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameStateTest 
{
	@Test
	public void testGetName()
	{
		GameState gameState = new GameState("name", 0, null, 0, null);
		assertEquals("name", gameState.getName());
	}
}

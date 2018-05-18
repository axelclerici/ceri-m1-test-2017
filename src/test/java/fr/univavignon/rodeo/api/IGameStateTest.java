package fr.univavignon.rodeo.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;

public class IGameStateTest 
{
	public static IGameState getTestGameState()
	{
		IGameState gameStateMock = Mockito.mock(IGameState.class);
		Mockito.when(gameStateMock.getProgression()).thenReturn(42);
		Mockito.when(gameStateMock.getSpecieLevel(null)).thenThrow(new java.lang.IllegalArgumentException());
		return gameStateMock;
	}
	
	@Test(expected =  java.lang.IllegalArgumentException.class)
	public void testGetSpecieLevelNull()
	{
		final IGameState gameStateMock = getTestGameState();
		gameStateMock.getSpecieLevel(null);
	}
	
	@Test
	public void testGetProgression()
	{
		IGameState gameStateMock = getTestGameState();
		assertEquals(42, gameStateMock.getProgression());
	}
}

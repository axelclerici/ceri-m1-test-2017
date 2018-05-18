package fr.univavignon.rodeo.testapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;

public class IGameStateProviderTest 
{
	public static IGameStateProvider getTestGameStateProvider()
	{
		IGameStateProvider gameStateProviderMock = Mockito.mock(IGameStateProvider.class);
		Mockito.when(gameStateProviderMock.get("test")).thenReturn(IGameStateTest.getTestGameState());
		return gameStateProviderMock;
		
	}
	
	@Test
	public void testGet()
	{
		IGameStateProvider gameStateProviderMock = Mockito.mock(IGameStateProvider.class);
		assertEquals(gameStateProviderMock.get("test"), IGameStateTest.getTestGameState());
	}
}

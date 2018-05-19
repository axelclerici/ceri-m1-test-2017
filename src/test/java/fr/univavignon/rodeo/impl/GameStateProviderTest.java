package fr.univavignon.rodeo.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IGameState;

public class GameStateProviderTest 
{
	@Test
	public void testGetGS()
	{
		GameStateProvider provider = new GameStateProvider();
		GameState gs = (GameState) provider.get("TestGameState");
		assertEquals("TestGameState", gs.getName());
		assertEquals(99, gs.getProgression());
		assertEquals(5, gs.currentArea);
		assertEquals("Tundra", gs.currentEnvironment.getName());
		assertEquals(0, gs.allSpecieLevels.get("Emu"));
		assertEquals("BossTrich", gs.caughtAnimals.get(0).getName());
	}
	
	@Test
	public void testSave()
	{
		GameStateProvider provider = new GameStateProvider();
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<IAnimal> caught = new ArrayList<IAnimal>();
		caught.add(new Animal("Emu", 0, false, false, false));
		map.put("OUI", 33);
		map.put("OUI2", 66);
		map.put("OUI3", 99);
		EnvironmentProvider envProvider = new EnvironmentProvider();
		IEnvironment env = envProvider.getEnvironment("Jungle");
		GameState gameState = new GameState("name", 50, env, 5, caught, map);
		provider.save(gameState);
		
		GameState gs = (GameState) provider.get("name");
		assertEquals("name", gs.getName());
		assertEquals(50, gs.getProgression());
		assertEquals(5, gs.currentArea);
		assertEquals("Jungle", gs.currentEnvironment.getName());
		assertEquals(33, gs.allSpecieLevels.get("OUI"));
		assertEquals("Emu", gs.caughtAnimals.get(0).getName());

	}
}

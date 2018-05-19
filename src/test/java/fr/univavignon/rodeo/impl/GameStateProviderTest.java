package fr.univavignon.rodeo.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.rodeo.api.IGameState;

public class GameStateProviderTest 
{
	/*
	Map<Specie, Integer> map = new HashMap<Specie, Integer>();
	List<Animal> caught = new ArrayList<Animal>();
	caught.add(new Animal("JeanClaudeVanDamme", 600, true, false, false));
	map.put(new Specie("OUI", 0, null), 33);
	map.put(new Specie("OUI2", 0, null), 35);
	map.put(new Specie("OUI3", 0, null), 53);
	map.put(new Specie("OUI78", 0, null), 55);
	GameStateProvider provider = new GameStateProvider();
	EnvironmentProvider envProvider = new EnvironmentProvider();
	IEnvironment env = envProvider.getEnvironment("Jungle");
	GameState gameState = new GameState("name", 50, env, 5, caught, map);
	provider.save(gameState);
	System.out.println("done");
	
*/
	
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
		assertEquals("BossTrich", gs.caughtAnimals.get(0));
	}
}

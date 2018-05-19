package fr.univavignon.rodeo.impl;

import java.util.List;
import java.util.Map;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class GameState implements IGameState
{
	private String name;
	private int progression;
	private int currentArea;
	private Environment currentEnvironment;
	private List<Animal> caughtAnimals;
	private Map<Specie, SpecieLevel> allSpecieLevels;
	
	public GameState(String name, int progression, Environment environment, int area, List<Animal> caughtAnimals)
	{
		this.name = name;
		this.progression = progression;
		this.currentArea = area;
		this.currentEnvironment = environment;
		this.caughtAnimals = caughtAnimals;
	}
	
	public String getName() 
	{
		return this.getName();
	}

	// Je n'ai pas comprit comment un animal était débloqué ...
	// Je considère donc qu'un animal est débloqué quand il est capturé.
	public void exploreArea() throws IllegalStateException 
	{
		checkUnlockedAllAnimals(currentEnvironment, currentArea);
		checkNewAreaToUnlock(currentEnvironment, currentArea);
		updateArea();
	}

	public void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getProgression() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private boolean checkUnlockedAllAnimals(Environment environment, int currentArea)
	{
		return true;
	}
	
	private boolean checkNewAreaToUnlock(Environment environment, int currentArea)
	{
		return true;
	}
	
	private void updateArea()
	{
		
	}

}

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

	// Je considère que Unlocked et Caught sont la même chose.
	public void exploreArea() throws IllegalStateException 
	{
		checkUnlockedAllAnimals(currentEnvironment, currentArea);
		checkNewAreaToUnlock(currentEnvironment, currentArea);
	}

	public void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException 
	{
		if(animal != null)
		{
			if(catchIsPossible(animal))
				((Animal)animal).updateCaught();
			else
				throw new IllegalStateException();
		}
		else
			throw new IllegalArgumentException();
		
	}

	public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getProgression() 
	{
		return this.progression;
	}
	
	private boolean checkUnlockedAllAnimals(Environment environment, int currentArea)
	{
		return true;
	}
	
	private boolean checkNewAreaToUnlock(Environment environment, int currentArea)
	{
		return true;
	}
	
	private boolean catchIsPossible(IAnimal animal)
	{
		boolean possible = false;
		EnvironmentProvider envProvider = new EnvironmentProvider();
		String environmentName = currentEnvironment.getName();
		List<ISpecie> species = envProvider.getSpecies(environmentName, currentArea);
		for(ISpecie specie : species)
		{
			for(IAnimal a : specie.getAnimals())
			{
				if(a.getName().equals(animal.getName()))
					possible = true;
			}
		}
		return possible;
	}

}

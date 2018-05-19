package fr.univavignon.rodeo.impl;

import java.util.List;
import java.util.Map;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class GameState implements IGameState
{
	private String name;
	private int progression;
	public int currentArea;
	public IEnvironment currentEnvironment;
	public List<Animal> caughtAnimals;
	public Map<Specie, Integer> allSpecieLevels;
	
	public GameState(String name, int progression, IEnvironment environment, int area, List<Animal> caughtAnimals, Map<Specie, Integer> allSpecieLevels)
	{
		this.name = name;
		this.progression = progression;
		this.currentArea = area;
		this.currentEnvironment = environment;
		this.caughtAnimals = caughtAnimals;
		this.allSpecieLevels = allSpecieLevels;
	}
	
	public String getName() 
	{
		return this.name;
	}

	
	public void exploreArea() throws IllegalStateException 
	{/*
		checkUnlockedAllAnimals(currentEnvironment, currentArea);
		checkNewAreaToUnlock(currentEnvironment, currentArea);*/
	}

	public void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException 
	{
		if(animal != null)
		{
			if(catchIsPossible(animal.getName()))
				((Animal)animal).updateCaught();
			else
				throw new IllegalStateException();
		}
		else
			throw new IllegalArgumentException();
		
	}

	public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	public int getProgression() 
	{
		return this.progression;
	}
	
	public boolean catchIsPossible(String animalName)
	{
		boolean possible = false;
		EnvironmentProvider envProvider = new EnvironmentProvider();
		String environmentName = currentEnvironment.getName();
		List<ISpecie> species = envProvider.getSpecies(environmentName, currentArea);
		for(ISpecie specie : species)
		{
			for(IAnimal a : specie.getAnimals())
			{
				if(a.getName().equals(animalName))
					possible = true;
			}
		}
		return possible;
	}

}

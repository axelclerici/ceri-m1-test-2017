package fr.univavignon.rodeo.impl;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.ISpecie;
import fr.univavignon.rodeo.api.SpecieLevel;

public class GameState implements IGameState
{
	private String name;
	private int progression;
	
	public GameState(String name, int progression)
	{
		this.name = name;
		this.progression = progression;
	}
	
	
	public String getName() 
	{
		return this.getName();
	}

	public void exploreArea() throws IllegalStateException {
		// TODO Auto-generated method stub
		
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

}

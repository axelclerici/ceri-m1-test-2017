package fr.univavignon.rodeo.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IGameState;
import fr.univavignon.rodeo.api.IGameStateProvider;

public class GameStateProvider implements IGameStateProvider
{

	public void save(IGameState gameState) 
	{
		GameState gs = (GameState) gameState;
		try 
		{
			PrintWriter writer = new PrintWriter(gs.getName() + ".txt", "UTF-8");
			writer.println(gs.getName());
			writer.println(gs.getProgression());
			writer.println(gs.currentArea);
			writer.println(gs.currentEnvironment.getName());
			writer.println(" ");
			
			for(String specie : gs.allSpecieLevels.keySet())
			{
				writer.println(specie + " " + gs.allSpecieLevels.get(specie));
			}
			writer.println("");
			
			for(IAnimal animal : gs.caughtAnimals)
			{
				writer.println(animal.getName());
			}
			
			writer.close();
		} 
		catch (FileNotFoundException e) {} 
		catch (UnsupportedEncodingException e) {}
	}

	public IGameState get(String name) throws IllegalArgumentException 
	{
		GameState gs = null;
		try 
		{
			BufferedReader b = new BufferedReader(new FileReader(name + ".txt"));
			String gsName = b.readLine();
			int gsProgression = Integer.parseInt(b.readLine());
			int gsCurrentArea = Integer.parseInt(b.readLine());
			String environmentName = b.readLine();
			EnvironmentProvider envProvider = new EnvironmentProvider();
			IEnvironment gsEnv = envProvider.getEnvironment(environmentName);
			b.readLine();
			
			String readLine = "";
			Map<String, Integer> gsLevels = new HashMap<String, Integer>();
			while((readLine = b.readLine()) != null) 
			{
				if(readLine.equals(""))
					break;
				
				String[] content = readLine.split(" ");
				String specieName = content[0];
				int specieXP = Integer.parseInt(content[1]);
				gsLevels.put(specieName, specieXP);
			}
			List<IAnimal> animalsCaught = new ArrayList<IAnimal>();
			while((readLine = b.readLine()) != null) 
			{
				String animalName = readLine;
				animalsCaught.add(envProvider.getAnimal(animalName));
			}
			gs = new GameState(gsName, gsProgression, gsEnv, gsCurrentArea, animalsCaught, gsLevels);
		} 
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
		return gs;
	}
}

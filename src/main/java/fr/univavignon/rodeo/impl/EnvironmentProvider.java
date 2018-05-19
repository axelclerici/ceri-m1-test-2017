package fr.univavignon.rodeo.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.IAnimal;
import fr.univavignon.rodeo.api.IEnvironment;
import fr.univavignon.rodeo.api.IEnvironmentProvider;
import fr.univavignon.rodeo.api.ISpecie;

public class EnvironmentProvider implements IEnvironmentProvider
{

	public List<String> getAvailableEnvironments() 
	{
		List<String> nameList = new ArrayList<String>();
		File animalsFolder = new File("animals");
		for(File subFolder : animalsFolder.listFiles())
		{
			nameList.add(subFolder.getName());
		}
		return nameList;
	}
	
	public List<ISpecie> getSpecies(String environment, int areas)
	{
		List<ISpecie> specieList = new ArrayList<ISpecie>();
		File environmentFolder = new File("animals" + File.separator + environment);
		for(File specieFile : environmentFolder.listFiles())
		{
			String fileName = specieFile.getName();
			int length = fileName.length();
			// On retire l'extension .txt du fichier
			String specieName = fileName.substring(1, length - 4);
			int area = Integer.parseInt(fileName.substring(0, 1));
			if(area <= areas)
			{
				List<IAnimal> animals = getAnimals(specieFile);
				specieList.add(new Specie(specieName, area, animals));
			}
		}
		return specieList;
	}

	public List<IAnimal> getAnimals(File specieFile) 
	{
		List<IAnimal> animals = new ArrayList<IAnimal>();
		try 
		{
			BufferedReader b = new BufferedReader(new FileReader(specieFile));
			String readLine = "";
			while ((readLine = b.readLine()) != null) 
			{
				String[] content = readLine.split(" ");
				String animalName = content[0];
				boolean isBoss = false;
				boolean isEndangered = false;
				boolean isSecret = false;
				if(content[1].equals("Boss"))
					isBoss = true;
				else if(content[1].equals("Endangered"))
					isEndangered = true;
				else if(content[1].equals("Secret"))
					isSecret = true;
				int xp = Integer.parseInt(content[2]);
				animals.add(new Animal(animalName, xp, isBoss, isEndangered, isSecret));
			}
			
		} catch (IOException e) {}
		
		return animals;
	}


	public IEnvironment getEnvironment(String name) throws IllegalArgumentException 
	{
		//TODO lire le nombre d'areas available dans le fichier save
		int areas = 5;
		if(name != null)
			return new Environment(name, areas, getSpecies(name, areas));
		else
		{
			throw new IllegalArgumentException();
		}
	}
}

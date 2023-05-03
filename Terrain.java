package com.etudiant;

public class Terrain implements IImposable
{
	public static enum typeTerrain
	{
		AGRICOLE, CONSTRUCTIBLE
	}
	
	public typeTerrain type;
	private float surface;
	
	public Terrain(typeTerrain type, float surface) {
		this.type = type;
		this.surface = surface;
	}

	@Override
	public float calculerImpot()
	{
		switch(type)
		{
		case AGRICOLE:
			return 0.1f * surface;
		case CONSTRUCTIBLE:
			return 0.5f * surface;
		default:
			throw new IllegalArgumentException("Type de terrain inconnu");
				
		}
	}
	
}

package com.etudiant;

public class Automobile implements IImposable
{
	
	//--------------------------------------- Attributs --------------------------------------------------------------//
	
	public static enum puissanceFiscale
		{
		PUISSANCE7, PUISSANCE14, PUISSANCE_AUTRE;
		}
	
	private puissanceFiscale puissance;
	
	public Automobile(puissanceFiscale puissance)
	{
		this.puissance = puissance;
	}
	
	@Override
	public float calculerImpot() {
		switch(puissance)
		{
		case PUISSANCE7:
			return 200;
		case PUISSANCE14:
			return 500;
		case PUISSANCE_AUTRE:
			return 1000;
		default:
			throw new IllegalArgumentException("Puissance fiscale inconnue");
		}
	}
	
}

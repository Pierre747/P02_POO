package com.etudiant;

public class Achat implements IImposable
{

	//--------------------------------------- Attributs --------------------------------------------------------------//
	
	public static enum TVA
	{
		TVA0, TVA2, TVA5, TVA20
	}
	
	private float prixHT;
	private TVA typeTVA;
	
	
	//--------------------------------------- Constructeurs -----------------------------------------------------------//
	
	
	public Achat(float prixHT, TVA typeTVA) {
		this.prixHT = prixHT;
		this.typeTVA = typeTVA;
	}


	@Override
	public float calculerImpot()
	{
		float taux;
		
		switch(typeTVA)
		{
		case TVA0:
			taux = 0;
			break;
		case TVA2:
			taux = 0.2F;
			break;
		case TVA5:
			taux = 0.55F;
			break;
		case TVA20:
			taux = 0.20F;
			break;
			default:
				throw new RuntimeException("Type de TVA non traité");
				
		}
		
		return prixHT = taux;
	}
	
}

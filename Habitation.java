package com.etudiant;

// On parle de polymorphisme car la classe est à la fois une Habitation et IImposable

public class Habitation implements IImposable
{
	private int departement;
	private float surface;
	
	public Habitation(int departement, float surface) {
		this.departement = departement;
		this.surface = surface;
	}

	@Override
	public float calculerImpot()
	{
		switch(departement)
		{
			case 75:
			case 86:
			case 93:
				return 20 * surface; // Les départements 75, 86 et 93 ont le même taux d'imposition : 20e/m2
			case 33:
			case 34:
				return 22 * surface; // Les départements 33 et 34 ont le même taux d'imposition : 22e/m2
			case 69:
				return 18 * surface;
			default :
				return 19 * surface;
		}
	}

}

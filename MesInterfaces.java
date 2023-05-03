package com.etudiant;

interface IImposable // I pour interface + I pour imposable
{
	public float calculerImpot();
	
	// A partir de Java 8, on peut déclarer des méthodes avec une implémentation par défaut en lui donnant le mot clef : default.
	public default String getAdresseImposable() 
	{
		return "La Tour Eiffel, Paris";
	}
	
	public default String getAdresseCentreImpot()
	{
		return "Centre des impôts de Paris, rue de Rivoli, 75001 Paris";
	}
	
} // Fin IImposable


// Cette interface est appliquée à toutes les classes auxquelles on peut calculer un périmètre
interface IMesurable
{
	double calculerPerimetre();
}


// Cette interface est appliquée à toutes les classes qui ont des angles géométriques

// Les figures IInscriptibles ont des angles. Cette interface doit donc imposer une méthode 
// capable de retourner le nombre d'angles des figures géométriques concernées. Mais ces 
// figures sont à la fois IMesurable... Donc tout ce qui est IInscriptible est aussi IMesurable
// L'interface IInscriptible peut donc hériter de IMesurable.
interface IInscriptible extends IMesurable
{
	int calculerNbAngles();
}


//Cette interface est appliquée à toutes les classes qui ont des courbes circulaires
interface ITrajectoireCirculaire
{
	double calculerForceCentrifuge(double m, double v); // m = masse de l'objet, du véhicule + v = vitesse
}


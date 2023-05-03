package com.etudiant;

import java.awt.Color;

abstract class FigureGeometrique
{
	// Poposer une méthode toString() capable d'afficher :
	// - Le nom de la classe
	// - L'aire de la figure géométrique
	
	@Override
	public String toString()
	{
		return getClass().getName() + ", aire : " + calculerAire();
	}

	// Je ne peux pas préciser le corps de la méthode calculerAire() car je ne sais pas encore
	// de quelle figure géométrique il s'agira (point, rectangle, triangle, cercle, etc...)
	// Pour cela, je vais déclarer cette méthode abstraite car elle n'est pas concrète.
	
	public abstract double calculerAire();
	
	// Une classe qui contient une ou plusieurs méthodes abstraites doit être déclarée abstraite, ell aussi.
	// Remarque: On peut déclarer une classe abstraite même si elle ne contient aucune méthode abstraite.
	
	// IMPORTANT: Une classe abstraite ne peut pas être instanciée donc elle ne peut pas générer des objets.
	// Son rôle est d'être un cadre, une superclasse, pour les classes concrètes héritées.
	
}// Fin de classe FigureGeometrique



// Sous classer la classe abstraiteFigureGeometrique pour obtenir des classes concrètes qui sont instanciables

class MonPoint extends FigureGeometrique
{
	// Je dois proposer un corps pour la méthode héritée abstraite calculerAire()
	@Override
	public double calculerAire()
	{
		return 0;
	}
	
}

class MonRectangle extends FigureGeometrique implements IInscriptible
{
	public double l, h;
	
	
	public MonRectangle(double l, double h)
	{
		this.l = l;
		this.h = h;
	}


	@Override
	public double calculerAire()
	{
		
		return l * h;
	}

	@Override
	public double calculerPerimetre() {
		return 2 * (l + h);
	}

	@Override
	public int calculerNbAngles() {
		return 4;
	}
	
}

class MonCarre extends MonRectangle
{

	public MonCarre(double c)
	{
		super(c, c);
	}
}

// En Java, une classe peut hériter d'une seule classe mais elle peut en implémenter plusieurs.

class MonCercle extends FigureGeometrique implements IMesurable, ITrajectoireCirculaire
{
	private double rayon;
	
	public MonCercle(double rayon)
	{
		this.rayon = rayon;
	}

	@Override
	public double calculerAire()
	{
		return Math.PI * Math.pow(rayon, 2);
	}

	@Override
	public double calculerPerimetre()
	{
		return 2 * Math.PI * rayon;
	}

	@Override
	public double calculerForceCentrifuge(double m, double v)
	{
		return m * (v * v) / rayon ;
	}
}

class MonDisque extends MonCercle
{
	Color couleur;
	
	public MonDisque(double rayon, Color couleur)
	{
		super(rayon);
		this.couleur = couleur;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", couleur R=" + couleur.getRed() + ", couleur V=" + couleur.getGreen() + ", couleur B=" + couleur.getBlue();
		
	}
	
}

class MonTriangle extends FigureGeometrique implements IInscriptible
{
	private double a, b, c;
	
	public MonTriangle(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double calculerAire()
	{
		double p = (a + b + c) * 0.5; // Formule de Héron
		return Math.sqrt(p * (p-a) * (p-b) * (p-c));
	}

	@Override
	public double calculerPerimetre()
	{
		return a + b + c;
	}

	@Override
	public int calculerNbAngles() {
		return 3;
	}
}
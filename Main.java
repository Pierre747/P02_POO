package com.etudiant;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import javax.swing.colorchooser.ColorChooserComponentFactory;

public class Main {

	public static void main(String[] args) 
	{
		// Une instance d'une classe peut être obtenue à l'aide de son constructeur.
		// Chaque classe possède un constructor par défaut, ce dernier n'a pas d'arguments.
		
		// Si un constructeur personnalisé a été défini, le constructeur par défaut n'existe plus.
		// Toutefois si on a besoin d'un constructeur sans argument on peut le créer. Pour l'instant, ce n'est pas le cas.
//		Personne p0 = new Personne();
//		System.out.println(p0.toString());
		
		// Depuis la nouvelle définition en private du constructeur, je ne peux plus créer une instance de Commun.
//		Commun c = new Commun();
//		System.out.println(c.toString());
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=- Création d'une personne -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		Personne maPersonne = new Personne("Chirac", "Jacques", Personne.MR);
		System.out.println(maPersonne);
		
		// =============================================================================================================//
		
		try
		{
			// Pour protéger ma saisie de civilite, on va gérer de l'encapsulation poiur éviter que le chiffre diffère de 0, 1 ou 2
			Personne personneProbleme1 = new Personne("Marie", "Durand", 100);
			System.out.println(personneProbleme1);
		}
		catch(IllegalArgumentException ex)
		{
			System.out.println("La création de la personneProbleme1 a échoué");
			System.out.println("Le message de l'execption est : " + ex.getMessage());
		}
		
		// =============================================================================================================//
		
//		Personne personneProbleme = new Personne("Marie", "Select * From Salaires Where Societe=M2I and salaire > 2000", Personne.MELLE); // Exception in thread "main" java.lang.IllegalArgumentException: Le nom Marie est erroné
		
		try
		{
			Personne personneProbleme2 = new Personne("Marie", "Martin", Personne.MME, 50); // Exception in thread "main" java.lang.IllegalArgumentException: La langue 50 est erronée
		} 
		catch(IllegalArgumentException ex)
		{
			System.out.println("La création de la personneProbleme2 a échoué");
			System.out.println("Le message de l'exception est : " + ex.getMessage());
		}
		
		// =============================================================================================================//
		
		Personne p1 = new Personne("Schmidt", "Helmut", Personne.MR, Commun.DE);
		System.out.println(p1);
		System.out.println();
		
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=- Try Catch Exceptions =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		
		
		// Je veux désormais afficher le prénom de p1.
		// Il me faut donc donner des accesseurs à la classe Personne. Getters / Setters
		try
		{
			System.out.println(p1.getNom());
		}
		catch(RuntimeException ex)
		{
			System.out.println("Cette opération n'est pas autorisée");
			System.out.println("Le message de l'exception est : " + ex.getMessage());
		}
		
		// on teste la modification du nom :
		
		p1.setNom("Merkel");
		System.out.println(p1);
		System.out.println();
		
		try
		{
			// On teste un nom qui ne contient pas le nombre de caractères supportés
			p1.setNom("asdjkfhajksldhfljkasdhfkljasdhfasjdhfjlaksdfhasdlfjkha");
			System.out.println(p1);
		}
		catch(RuntimeException ex)
		{
			System.out.println("Cette opération n'est pas autorisée");
			System.out.println("Le message de l'exception est : " + ex.getMessage());
		}
		
		// =============================================================================================================//
		
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=- Modification d'une Personne -=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// Test de la méthode de modification d'une personne :
		
		p1.modifierPersonne("Angela", Personne.MME);
		System.out.println("Suite à la modification par la méthode modifierPersonne : " + p1);
		System.out.println();
		
		p1.modifierPersonne("Casta", "Laetitia", Personne.MELLE);
		System.out.println("Nouvelle modification de p1 : " + p1);
		System.out.println();
		
		// Pour tester notre méthode override finalize(), on va créer un certain nombre de personnes sans stocker leurs adresses 
		// dans des variables. Ainsi, les personnes créees ne seront pas accessibles donc elles occupent inutilement la mémoire.
		// Conséquence : A un moment donné, Java appellera le garbage collector qui va détruire ces instances et avant de les détruire,
		// il appellera la méthode finalize()
		
		// On crée de nouvelles personnes en masse :
//		for(int i = 0; i < 50000; i++)
//		{
//			new Personne("N" + i, "P" + i, Personne.MR);
//		}
//		
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-= Création d'Employés =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// =============================================================================================================//
		
		
		Employe e1 = new Employe("Macron", "Emmanuel", Personne.MR, 10000F, "Elysée", Employe.ServicesV1.DIRECTION);
		System.out.println(e1.getDetails());
		System.out.println();
		
		// =============================================================================================================//
		
		Employe e2 = new Employe("Royal", "Ségolène", Personne.MME, 10000F, "Escroc", Employe.ServicesV1.RELATION_CLIENT);
		System.out.println(e2.getDetails());
		System.out.println();
		
		// =============================================================================================================//
		
		Employe e3 = new Employe("Laguiller", "Arlette", Personne.MME, 2000F, "Force Ouvrière", Employe.ServicesV1.SAV);
		System.out.println(e3.getDetails());
		System.out.println();
		
		// =============================================================================================================//
		
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-= Personnes =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		p1.quiSuisJe();
		p1.afficherTaille(1.86);
		System.out.println();
		
		e1.quiSuisJe();
		e1.afficherTaille(1.55);
		System.out.println();
		
		Personne p = e1;
		System.out.println(p);
		p.quiSuisJe();
		// On observe que malgré le fait d'avoir mis l'employé dans une variable de type Personne,
		// il reste quand même un Employe. La bonne méthode quiSuisJe à utiliser est décidée lors du Runtime (exécution).
		// Le lien entre l'instance et la bonne méthode est dynamique et retardée car il est fait très tard, 
		//au moment de l'exécution et non pas à la compilation.
		
		// Au contraire, le lien entre la méthode afficherTaille() - qui n'est pas overridée - est fait au moment de la compilation : lien static.
		// Le compilateur fait le lien entre une personne et la méthode afficherTaille() de la classe Personne.
		p.afficherTaille(1.90);
		
		
		// =============================================================================================================//
		
				System.out.println();
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Achats =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.println();
				
				
				System.out.println();
				System.out.println("Travail disponible dans le Main");
				System.out.println();
				
		
		Achat monAchat = new Achat(200F, Achat.TVA.TVA20);
		
		Vector<Object> registre = new Vector<>();
		
		registre.add(maPersonne);
		registre.add(p1);
		registre.add(monAchat);
		registre.add(e1);
		registre.add(e2);
		
		
		// =============================================================================================================//
		
		
		// TODO: Créer les classes IImposables Automobile, Habitation et Terrain.
		// Créer une instance de chaque et la déposer dans le registre.
				
		// AUTO :
		Automobile auto = new Automobile(Automobile.puissanceFiscale.PUISSANCE14);
		registre.add(auto);
		
		// HABITATION :
		Habitation habitation = new Habitation(86, 40);
		registre.add(habitation);
		
		// TERRAIN :
		Terrain terrain = new Terrain(Terrain.typeTerrain.AGRICOLE, 10000);
		registre.add(terrain);
		
		
		// =============================================================================================================//
		
		
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=- FiguresGeometriques -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		
		// On ne peut pas instancier la classe FigureGeometrique car elle est abstraite
//		FigureGeometrique fg = new FigureGeometrique();
		
		MonPoint mp = new MonPoint();
		registre.add(mp);
		
	
		System.out.println("Mon point a une " + mp);
		System.out.println();
		
		
		MonRectangle rectangle = new MonRectangle(3, 5);
		registre.add(rectangle);
		
		System.out.println("Mon rectangle a une " + rectangle);
		System.out.println();
		
		MonCarre carre = new MonCarre(3);
		registre.add(carre);
		
		System.out.println("Mon carré a une " + carre);
		System.out.println();
		
		MonCercle cercle = new MonCercle(1);
		registre.add(cercle);
		
		System.out.println("Mon cercle a une " + cercle);
		System.out.println();
		
		MonDisque disque = new MonDisque(2, new Color(255, 0, 0));
		registre.add(disque);
		
		System.out.println("Mon cercle a une " + disque);
		System.out.println();
		
		MonTriangle triangle = new MonTriangle(3, 4, 5);
		registre.add(triangle);
		
		System.out.println("Mon triangle a une " + triangle);
		System.out.println();
		
		
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=- Utilisation des classes abstraites =-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// Quelle est la longueur totale de tous les objets du registre ?
		
		// Pour répondre à cette question, je dois :
		// 1 - Parcourir le registre et trouver les objets IMesurable
		// 2 - Leur demander de calculer leur périmètre
		// 3 - Faire la somme de tous ces périmètres et l'afficher après
		
		
		// Étape 1 :
		
		double longueurTotale = 0;
		
		for(Object o : registre)
		{
			if(o instanceof IMesurable)
			{
				longueurTotale += ((IMesurable) o).calculerPerimetre();
			}
		}
		
		System.out.println("La longueur totale de tous les objets du registre est de : " + longueurTotale + " m");
		
		
		// TODO: Combien de personnes embauchées a-t'on dans le registre ?
		// L'opération consiste à substituer le nombre d'employés au nombre total de Personnes
		
		
		// On commence par chercher le nombre total de Personnes
		
		int nbPersonnes = 0;
		
		for(Object o : registre)
		{
			if(o instanceof Personne)
			{
				nbPersonnes++;
			}
		}
		
		// Désormais, on cherche le nombre total d'employés
		
		int nbEmploye = 0;
		
		for(Object o : registre)
		{
			if(o instanceof Employe)
			{
				nbEmploye++;
			}
		}
		
		System.out.println();
		System.out.println("Nombre de personnes non embauchées : " + (nbPersonnes - nbEmploye));
		System.out.println();
		
		
		// TODO: Calculer la surface totale de tous les objets du registre
		
		int surfaceTotale = 0;
		
		for(Object o : registre)
		{
			if(o instanceof FigureGeometrique)
			{
				surfaceTotale += ((FigureGeometrique) o).calculerAire();
			}
		}
		
		System.out.println("Surface totale des objets du registre : " + surfaceTotale + " m2");
		System.out.println();
		
		
		// TODO: Calculer la longueur moyenne des objets du registre
		
		int objectTotal = 0;
		
		for(Object o : registre)
		{
			if(o instanceof IMesurable)
			{
				objectTotal++;
			}
		}
		
		System.out.println("La longueur moyenne des objets du registre : " + (longueurTotale / objectTotal ) + " m");
		System.out.println();
		
		
		// TODO: Calculer le nombre total d'angles présents dans le registre
		
		int nombreTotalAngles = 0;
		
		for(Object o : registre)
		{
			if(o instanceof IInscriptible)
			{
				nombreTotalAngles += ((IInscriptible) o).calculerNbAngles();
			}
		}
		
		System.out.println("Le nombre total d'angles des objets du registre : " + nombreTotalAngles + " angles");
		System.out.println();
		
		
		// TODO: Calculer la recette du FISC
		
		int recetteTotale = 0;
		
		for(Object o : registre)
		{
			if(o instanceof IImposable)
			{
				recetteTotale += ((IImposable) o).calculerImpot();
			}
		}
		
		System.out.println("La recette totale du FISC est de : " + recetteTotale + " euros");
		System.out.println();
		
		// TODO: Quelle est la force centrifuge ressentie sur chaque objet du registre par un véhicule de 100kg qui roule à 36km/h.
		
		
		double vitesse = 36000/3600;
		
		double masse = 100;
		
		
		for(Object o : registre)
		{
			if(o instanceof ITrajectoireCirculaire)
			{
				System.out.println("Force centrifuge : " + ((ITrajectoireCirculaire)o).calculerForceCentrifuge(masse, vitesse) + " N");
				System.out.println();
			}
		}
		
		// Afficher les adresses de l'imposable et du centre d'impôts pour l'employé e1
		
		System.out.println("L'adresse de l'imposable est : " + e1.getAdresseImposable() + ", adresse du centre des impôts : " + e1.getAdresseCentreImpot());
		
		
		System.out.println();
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=- Charger une classe à la volée -=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		
		// On va désormais charger une classe à la volée et créer une instance à partir de cette classe.
		
		// On peut le faire en utilisant le constructeur sans les arguments de la classe.
		// Il va donc falloir créer un constructeur sans paramètres.
		
		// Disons que j'ai besoin de la classe Employe chargée à la volée pour créer une ou plusieurs instances de cette classe.
		
		System.out.println("Chargement d'une classe à la volée en précisant son nom au moment de l'exécution");
		
		// 1 - Je définis le nom
		
		String nom_classe_a_charger = "com.etudiant.Employe";
		
		// 2 - je vais charger la classe :
		
		try {
			
			Class<?> classeChargee = Class.forName(nom_classe_a_charger);
			
			// 3 - Je dois créer une instance de cette classe
			
			// VERSION 1 :
			
			// Si on a des constructeurs sans paramètres pour les classes Employe et Personne, on peut écire cela : Object o = classeChargee.getDeclaredConstructor().newInstance();
			// On le surround d'un try catch :
			
			try {
				Object o = classeChargee.getDeclaredConstructor().newInstance();
				
				// On va donc peupler l'objet créé après l'avoir transtypé
				
				Employe e = (Employe)o;
				
				// J'injecte les valeurs
				e.setNom("Dujardin");
				e.setPrenom("Cécile");
				e.setCivilite(Personne.MELLE);
				
				// Désormais le profil employé
				e.setSalaire(2222);
				e.setSociete("M2i");
				e.setService(Employe.ServicesV1.SAV);
				
				// On l'affiche
				
				System.out.println("Employé chargé à la volée VERSION 1 : " + e);
				
				} catch (Exception ex) {
				System.out.println("Le chargement de la classe " + nom_classe_a_charger + " a échoué \n à cause de " + ex.getMessage());
				System.exit(65);
				
			} // Fin try catch V1
			
			
			
			// -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= //
			
			
			// VERSION 2 :
			
			// On utilise maintenant le constructeur avec les paramètres de l'employé.
			
			// On commence par créer un tableau des types d'arguments à passer :
			
			Class[] tbArgs = new Class[6];
			
			tbArgs[0] = String.class; // Le premier argument du constructeur Employe correspond à une string : nom
			tbArgs[1] = String.class; // prenom
			tbArgs[2] = int.class; // civilité
			tbArgs[3] = float.class; // salaire
			tbArgs[4] = String.class; // société
			tbArgs[5] = Employe.ServicesV1.class; // service
			
			Object oo = classeChargee.getDeclaredConstructor(tbArgs).newInstance("Duciel", "Irène", Personne.MME, 1111, "IBFormation", Employe.ServicesV1.COMMERCIAL);
			
			System.out.println("Employé chargé à la volé VERSION 2 : " + oo);
			
		} catch (Exception ex) {
			System.out.println("Le chargement de la classe " + nom_classe_a_charger + " a échoué \n car : " + ex.getMessage());
			System.exit(65);
		}
		
		
		
		
		
	} // Fin du Main

	
	
} // Fin de la classe

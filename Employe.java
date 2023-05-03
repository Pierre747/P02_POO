package com.etudiant;


// Hérité de la classe Personne pour obtenir la sous classe Employe

public class Employe extends Personne implements IImposable
{
	
	//--------------------------------------- Attributs --------------------------------------------------------------//
	
	// L'employé est une Personne plus spécialisée qui, en plus d'une Personne, a un salire, une société et un département de travail.

	private float salaire;
	private String societe;
	private ServicesV1 service; // Une énumération définit un type de données (tout comme les classes et les interfaces)
	
	// Définition d'une énumération : Elle définie un type (String, float, etc...). Elle contiendra les services qui existent dans une société.
	public static enum ServicesV1
	{
		DIRECTION, COMMERCIAL, RELATION_CLIENT, SAV
	}
	
	//--------------------------------------- Constructeurs --------------------------------------------------------------//

	public Employe(String nom, String prenom, int civilite, float salaire, String societe, ServicesV1 service) {
		super(nom, prenom, civilite); // Le mot clef super appelle le constructeur de la superclasse Personne
		this.salaire = salaire;
		this.societe = societe;
		this.service = service;
	}
	
	// On va créer un constructeur sans arguments nécessaire pour la solution VERSION 1 de chargement à la volée => Main => Charger une classe à la volée
	
	public Employe()
	{
			
	}
		
	
	//--------------------------------------- Getters and Setters --------------------------------------------------------------//

	// Pour obtenir les Getters and Setters de façon automatique, on fait:
	// clicl droit sur un bout de page libre puis => Source => Generate Getters and Setters ... => Select All => Generate

	public float getSalaire() {
		return salaire;
	}



	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}



	public String getSociete() {
		return societe;
	}



	public void setSociete(String societe) {
		this.societe = societe;
	}



	public ServicesV1 getService() {
		return service;
	}



	public void setService(ServicesV1 service) {
		this.service = service;
	}
	
	// Lors de l'exécution, on constate que seulement les informations contenues dans la classe Personne sont affichées.
	// Effectivement, Employe hérite de Personne, donc de toString() de Personne entre autres choses.
	// Si on veut aussi afficher les champs plus spécialisés de la classe Employe, comme le salaire, la societe et le service,
	// il faut ovverrider la méthode toString().
	
	
	// Comme le toString() de Personne a été factorisé(il contient deux parties : getClass().getName() et getDetails()).
	// Nous n'avons donc pas besoin de tout ré écrire, il nous suffit de définir une nouvelle méthode getDetails qui utilise l'ancienne
	// et qui qjoute ce qu'il manque.
	
	protected String getDetails()
	{
		// return super.getDetails() + ", salaire " + salaire + "€, société : " + societe + ", service : " + service; // V1
		// Comme pour le constructeur, j'utilise le super pour surcharger la méthode
		return super.getDetails() + ", salaire " + salaire + "€, société : " + societe + ", service : " + getServiceTexte(); // V2
	}
	
	// Si on veut remplacer l'item de l'énumération avec un texte plus humain, on peut définir trois types d'énumérations :
	// Ici, on va utiliser un tableau avec ce que l'on veut afficher et passer par ce tableau pour chercher l'item voulut.
	
	private String[] tbServices = 
		{
			"Direction",
			"Service commercial",
			"Service client",
			"Service après-vente"
			
		};
	// Méthode utilitaire qui va trouver le texte du service :
	private String getServiceTexte()
	{
		return tbServices[service.ordinal()];
	}
	
	
	// On va overrider la méthode quiSuisJe()
	@Override
	public void quiSuisJe()
	{
		System.out.println("Je suis un employé.");
	}
	
	// INFO: L'annotation @Override est pour l'instant optionnelle mais hautement recommandée.
	
	// Je ne peux pas Overrider cette méthode afficherTaille car dans la classe de base, sa signature est différente:
	// on a un paramètre double alors qu'ici on a un paramètre String
	// La réécriture est impossible, il s'agit donc d'une nouvelle méthode

	public void afficherTaille(String msg)
	{
		System.out.println("L'employé mesure " + msg);
	}

	@Override
	public float calculerImpot()
	{
		
		float revenu = salaire * 12;
		if(revenu < 10000)
		{
			return 0;
		} else if(revenu < 25000)
		{
			return (salaire - 10000) * 0.1F; // Je mets le F majuscule pour le transformer en float
		} else
		{
			return (25000 - 10000) * 0.1F + (revenu - 25000) * 0.4F;
		}
	}
	
	// L'interface IImposable impose aussi deux méthodes ayant un corps par défaut : getAdresseImposable() et getAdresseCentreImpot().
	// Modifions getAdresseImposable :
	
	@Override
	public String getAdresseImposable() 
	{
		return "Adresse Inconnue";
	}
}

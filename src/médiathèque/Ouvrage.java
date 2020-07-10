package médiathèque;

public class Ouvrage implements IOuvrage{
	private TypeOuvrage type; 
	private String libelle;
	private String auteur;
	private String titre;
	private String identifiant;
	private boolean disponible; 
	private String dateDeSortie;
	private String dateDeRetour;
	private int nbOuvrage=0;
	
		
	public Ouvrage( String auteur, String titre, String identifiant, boolean disponible,
			String dateDeSortie, String dateDeRetour) {
	
		this.auteur = auteur;
		this.titre = titre;
		this.identifiant = identifiant;
		this.disponible = disponible;
		this.dateDeSortie = dateDeSortie;
		this.dateDeRetour = dateDeRetour;
		this.libelle="Ouvrage";
		this.nbOuvrage=getNbOuvrage()+1; 
		
	}
	
	
	public TypeOuvrage getType() {
		return type;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getDateDeSortie() {
		return dateDeSortie;
	}
	public void setDateDeSortie(String dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}
	public String getDateDeRetour() {
		return dateDeRetour;
	}
	public void setDateDeRetour(String dateDeRetour) {
		this.dateDeRetour = dateDeRetour;
	}
	
	@Override
	public void afficheOuvrage() {
		System.out.println("\t|Titre         : "+this.getTitre());
		System.out.println("\t|Auteur        : "+this.getAuteur());
		System.out.println("\t|Identifiant   : "+this.getIdentifiant());
		System.out.println("\t|Disponible    : "+this.isDisponible());
		System.out.println("\t|Date de Sortie: "+this.getDateDeSortie());
		System.out.println("\t|Date de retour: "+this.dateDeRetour+"\n");
		
	}


	public String getLibelle() {
		return libelle;
	}


	public int getNbOuvrage() {
		return nbOuvrage;
	}



	
	
	
	

}

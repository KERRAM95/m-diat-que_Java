package médiathèque;

public class CD extends Ouvrage implements IOuvrage {

	public CD(String auteur, String titre, String identifiant, boolean disponible, String dateDeSortie,
			String dateDeRetour) {
		super(auteur, titre, identifiant, disponible, dateDeSortie, dateDeRetour);
		this.type=TypeOuvrage.CD; 
		nb_CD=getNb_CD()+1;
	}

	private TypeOuvrage type; 
	private int nb_CD=0;



	public TypeOuvrage getType() {
		return type;
	}
	public String getLibelle() {
		return "Compact Disc";
	}
	public int getNb_CD() {
		return nb_CD;
	}
	@Override
	public void afficheOuvrage() { 
	    System.out.println("\t*************Ouvrage("+getLibelle()+")****************\n");
		System.out.println("\t|Titre         : "+this.getTitre());
		System.out.println("\t|Auteur        : "+this.getAuteur());
		System.out.println("\t|Identifiant   : "+this.getIdentifiant());
		System.out.println("\t|Disponible    : "+this.isDisponible());
		System.out.println("\t|Date de Sortie: "+this.getDateDeSortie());
		System.out.println("\t|Date de retour: "+this.getDateDeRetour()+"\n");


	}





}

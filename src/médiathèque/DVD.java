package médiathèque;

public class DVD extends Ouvrage implements IOuvrage {
	
	private TypeOuvrage type;
    private int nb_DVD=0; 
	public DVD(String auteur, String titre, String identifiant, boolean disponible, String dateDeSortie,
			String dateDeRetour) {
		super(auteur, titre, identifiant, disponible, dateDeSortie, dateDeRetour);
		this.type=TypeOuvrage.DVD; 
		nb_DVD = getNb_DVD() + 1; 
	}

	public TypeOuvrage getType() {
		return type;
	}
	public String getLibelle() {
		return "Digital Video Disc";
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

	public int getNb_DVD() {
		return nb_DVD;
	}



	

}

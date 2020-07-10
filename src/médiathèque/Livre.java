package médiathèque;

public class Livre extends Ouvrage implements IOuvrage {
    
	private TypeOuvrage type; 
	private int nb_Livre=0;
	public Livre(String auteur, String titre, String identifiant, boolean disponible,
			String dateDeSortie, String dateDeRetour) {
		super(auteur, titre, identifiant, disponible, dateDeSortie, dateDeRetour);
		this.type=TypeOuvrage.Livre; 
		this.nb_Livre=getNb_Livre()+1; 
	}
	
	public TypeOuvrage getType() {
		return type;
	}

	public String getLibelle() {
		return "Livre";
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

	public int getNb_Livre() {
		return nb_Livre;
	}







	

}

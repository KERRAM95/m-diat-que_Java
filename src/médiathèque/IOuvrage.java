package m�diath�que;

public interface IOuvrage {
    String getLibelle();
	String getAuteur();
    String getTitre();
	String getIdentifiant();
	boolean isDisponible();
	String getDateDeSortie();
	String getDateDeRetour();
	void afficheOuvrage();
	TypeOuvrage getType(); 

}
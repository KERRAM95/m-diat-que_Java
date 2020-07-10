/*
 * 
 * 
 * Master 2 TTT 
 * Université Gustave Eiffel
 * @author  KERRAM Mourad, Moussa guachari, KONE ABAUBACAR, MAISSA AZABI
 * @date 15/03/2020
 * 
 * 
 * */



package médiathèque;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mediatheque {

	public static void main(String[] args) {


		ArrayList<IOuvrage>ouvrages=new ArrayList<>(); 
		@SuppressWarnings("resource")
		Scanner scanne= new Scanner(System.in);
		
		Mediatheque.bienvenueMassage();//Affichage de message de bienvenue
		try {
			if(!ReadWriteFile.fileisempty()) {
				try {
					ouvrages=ReadWriteFile.loadLibrery();
					System.err.println("\tCharegement de la médiathèque avec "+ouvrages.size()+" ouvrages\n");
				} catch (IOException e) {
					System.err.println("Fichier de source introuvable: "+e );
				}
			}
		} catch (IOException e) {
			System.err.println("Fichier de source introuvable: "+e );

		}


		
		exit_1er_while:
			while(true) {
				Mediatheque.menu();	//Affichage de message de bienvenue	
				exit_deuxiem_while:
					while(true) {
						if(scanne.hasNextInt()) {
							int i = scanne.nextInt();// le choix de l'option
							scanne.nextLine();
							if(i==2) {
								/*si la médiathèque ne contient pas d'ouvrage*/
								if(ouvrages.size()==0) {System.out.println("\tMédiathèque vide !\n");
								//scanne.nextLine();
								continue exit_1er_while;
								}
								/*parcourir la médiathèque et affchage des ouvrages*/
								else {
									int j=0; 
									String press="";
									System.out.println("\tLa médiathèque contient "+ouvrages.size()+" ouvrages.\n"); //ouvrages.size() return nombre d'ouvrages dans la médiathèque 
									for(IOuvrage o:ouvrages) {

										o.afficheOuvrage();

										j++;
										if(j!=ouvrages.size()) {

											System.out.println("\t[Entrée] pour l'ouvrage suivant, autre touche et entrée pour quiter.\n");	
											press=scanne.nextLine();
											if(press.length()!=0) {
												System.out.println("\tJe sors ! \n");
												continue exit_1er_while; }
										}
										else
										{
											System.out.println("\t[Entrée] pour quiter.\n");
											scanne.nextLine();
											continue exit_1er_while;
										}


									}//fin de la boucle foreach

								}//fin de else 


							}//fin de if 

							/*la saisir d'un ouvrage*/
							else if(i==1) {
								Mediatheque.saisirMenu();//	
								exit_saisir_while:
									while(true) {
										if(scanne.hasNextInt()) {
											/*****Declaration des variabes*********/
											String auteur=null;
											String titre=null;
											String identifiant=null;
											boolean disponible=false; 
											String dateDeSortie=null;
											String dateDeRetour=null;
											/*************************************/
											int index=scanne.nextInt();
											scanne.nextLine();
											if(index==1) {

												System.out.println("\tPour abandonner la saisir, saisissez un champ vide");
												/*Saisir un titre*/
												System.out.println("\tQuel est le titre de ce Livre ?");
												titre=scanne.nextLine();
												if(titre.length()>0&&titre.isBlank()) {
													System.err.println("\tCréation abandonné!\n");	
													continue exit_1er_while;} 

												/*Saisir un auteur*/
												System.out.println("\tQuel est l'auteur de ce Livre ?");
												auteur=scanne.nextLine();
												if(auteur.length()>0&&auteur.isBlank()) {
													System.err.println("\tCréation abandonné!\n");	
													continue exit_1er_while;}

												/*Saisir un identifaint*/
												System.out.println("\tQuel est l'identifiant de ce Livre ?");
												identifiant=scanne.nextLine();
												if(identifiant.length()>0&&identifiant.isBlank()) {
													System.err.println("\tCréation abandonné!\n");	
													continue exit_1er_while;} 

												/*Saisir une disponiblité de Livre*/
												System.out.println("\t le Livre est-il disponible? oui/non");
												boolean isValid=false;
												do{

													String disp=scanne.nextLine().toLowerCase();
													if(disp.length()>0&&disp.isBlank()) {
														System.err.println("\tCréation abandonné!\n");	
														continue exit_1er_while;}
													if(disp.contentEquals("oui")) {disponible=true; isValid=false;break;}
													if(disp.contentEquals("non")){disponible=false; isValid=false;break;}
													System.out.println("\t Veuillez saisir oui ou non :");
													isValid=true;

												}while(isValid);//fin de while

												/*Saisir la date de sortie*/
												System.out.println("\tQuel est la date de sortie de ce Livre ?");
												boolean isValidDateSortie=false;
												do{

													String date=scanne.nextLine();
													if(date.length()>0&&date.isBlank()) {
														System.err.println("\tCréation abandonné!\n");	
														continue exit_1er_while;}

													if(ReadWriteFile.estValidDateSortie(date)) {dateDeSortie=date; isValid=false;break;}
													System.out.println("\t Veuillez saisir une date correcte [dd/mm/yyyy] :");
													isValidDateSortie=true;

												}while(isValidDateSortie);//fin de while

												/*Saisir la date de reteur*/
												System.out.println("\tQuel est la date de retour de ce Livre ?");
												boolean isValidDateReteur=false;
												do{

													String date=scanne.nextLine();
													if(date.length()>0&&date.isBlank()) {
														System.err.println("\tCréation abandonné!\n");	
														continue exit_1er_while;}

													if(ReadWriteFile.estValidDateSortie(date)) {dateDeRetour=date; isValid=false;break;}
													System.out.println("\t Veuillez saisir une date correcte [dd/mm/yyyy] :");
													isValidDateReteur=true;

												}while(isValidDateReteur);//fin de while

												IOuvrage livre=new Livre(auteur,titre,identifiant,disponible,dateDeSortie,dateDeRetour);
												ouvrages.add(livre);
												System.out.println("\tSaisie du livre terminée.");
												continue exit_1er_while;


											}//fin de saisir Livre
											else if(index==2) {

												System.out.println("\tPour abandonner la saisir, saisissez un champ vide");
												/*Saisir un titre*/
												System.out.println("\tQuel est le titre de ce CD ?");
												titre=scanne.nextLine();
												if(titre.length()>0&&titre.isBlank()) {
													System.err.println("\tCréation abandonné!\n");	
													continue exit_1er_while;} 

												/*Saisir un auteur*/
												System.out.println("\tQuel est l'auteur de ce CD ?");
												auteur=scanne.nextLine();
												if(auteur.length()>0&&auteur.isBlank()) {
													System.err.println("\tCréation abandonné!\n");	
													continue exit_1er_while;}

												/*Saisir un identifaint*/
												System.out.println("\tQuel est l'identifiant de ce CD ?");
												identifiant=scanne.nextLine();
												if(identifiant.length()>0&&identifiant.isBlank()) {
													System.err.println("\tCréation abandonné!\n");	
													continue exit_1er_while;} 

												/*Saisir une disponiblité de CD*/
												System.out.println("\t le CD est-il disponible? oui/non");
												boolean isValid=false;
												do{
													/*Vérification de la validité de saisir*/
													String disp=scanne.nextLine().toLowerCase();
													if(disp.length()>0&&disp.isBlank()) {
														System.err.println("\tCréation abandonné!\n");	
														continue exit_1er_while;}
													if(disp.contentEquals("oui")) {disponible=true; isValid=false;break;}
													if(disp.contentEquals("non")){disponible=false; isValid=false;break;}
													System.out.println("\t Veuillez saisir oui ou non :");
													isValid=true;

												}while(isValid);//fin de while

												/*Saisir la date de sortie*/
												System.out.println("\tQuel est la date de sortie de ce CD ?");
												boolean isValidDateSortie=false;
												do{
													/*Vérification la validité de date sortie */
													String date=scanne.nextLine();
													if(date.length()>0&&date.isBlank()) {
														System.err.println("\tCréation abandonné!\n");	
														continue exit_1er_while;}

													if(ReadWriteFile.estValidDateSortie(date)) {dateDeSortie=date; isValid=false;break;}
													System.out.println("\t Veuillez saisir une date correcte [dd/mm/yyyy] :");
													isValidDateSortie=true;

												}while(isValidDateSortie);//fin de while

												/*Saisir la date de reteur*/
												System.out.println("\tQuel est la date de retour de ce CD ?");
												boolean isValidDateReteur=false;
												do{
                                                   /*Vérification de date de retour*/
													String date=scanne.nextLine();
													if(date.length()>0&&date.isBlank()) {
														System.err.println("\tCréation abandonné!\n");	
														continue exit_1er_while;}

													if(ReadWriteFile.estValidDateSortie(date)) {dateDeRetour=date; isValid=false;break;}
													System.out.println("\t Veuillez saisir une date correcte [dd/mm/yyyy] :");
													isValidDateReteur=true;

												}while(isValidDateReteur);//fin de while

												IOuvrage cd=new CD(auteur,titre,identifiant,disponible,dateDeSortie,dateDeRetour);
												ouvrages.add(cd);
												System.out.println("\tSaisie du CD terminée.");
												continue exit_1er_while;
											}//fin de saisir de CD
											else if(index==3) {
												System.out.println("\tPour abandonner la saisir, saisissez un champ vide");
												/*Saisir un titre*/
												System.out.println("\tQuel est le titre de ce DVD ?");
												titre=scanne.nextLine();
												if(titre.length()>0&&titre.isBlank()) {
													System.err.println("\tCréation abandonné!\n");	
													continue exit_1er_while;} 

												/*Saisir un auteur*/
												System.out.println("\tQuel est l'auteur de ce DVD ?");
												auteur=scanne.nextLine();
												if(auteur.length()>0&&auteur.isBlank()) {
													System.err.println("\tCréation abandonné!\n");	
													continue exit_1er_while;}

												/*Saisir un identifaint*/
												System.out.println("\tQuel est l'identifiant de ce DVD ?");
												identifiant=scanne.nextLine();
												if(identifiant.length()>0&&identifiant.isBlank()) {
													System.err.println("\tCréation abandonné!\n");	
													continue exit_1er_while;} 

												/*Saisir une disponiblité de DVD*/
												System.out.println("\t le DVD est-il disponible? oui/non");
												boolean isValid=false;
												do{

													String disp=scanne.nextLine().toLowerCase();
													if(disp.length()>0&&disp.isBlank()) {
														System.err.println("\tCréation abandonné!\n");	
														continue exit_1er_while;}
													if(disp.contentEquals("oui")) {disponible=true; isValid=false;break;}
													if(disp.contentEquals("non")){disponible=false; isValid=false;break;}
													System.out.println("\t Veuillez saisir oui ou non :");
													isValid=true;

												}while(isValid);//fin de while

												/*Saisir la date de sortie*/
												System.out.println("\tQuel est la date de sortie de ce DVD ?");
												boolean isValidDateSortie=false;
												do{

													String date=scanne.nextLine();
													if(date.length()>0&&date.isBlank()) {
														System.err.println("\tCréation abandonné!\n");	
														continue exit_1er_while;}

													if(ReadWriteFile.estValidDateSortie(date)) {dateDeSortie=date; isValid=false;break;}
													System.out.println("\t Veuillez saisir une date correcte [dd/mm/yyyy] :");
													isValidDateSortie=true;

												}while(isValidDateSortie);//fin de while

												/*Saisir la date de reteur*/
												System.out.println("\tQuel est la date de retour de ce DVD ?");
												boolean isValidDateReteur=false;
												do{

													String date=scanne.nextLine();
													if(date.length()>0&&date.isBlank()) {
														System.err.println("\tCréation abandonné!\n");	
														continue exit_1er_while;}

													if(ReadWriteFile.estValidDateSortie(date)) {dateDeRetour=date; isValid=false;break;}
													System.out.println("\t Veuillez saisir une date correcte [dd/mm/yyyy] :");
													isValidDateReteur=true;

												}while(isValidDateReteur);//fin de while
												/*Création un nouveau objet DVD*/
												IOuvrage dvd=new DVD(auteur,titre,identifiant,disponible,dateDeSortie,dateDeRetour);
												ouvrages.add(dvd); //ajouter dans la liste d'ouvrages
												System.out.println("\tSaisie du livre terminée.");
												continue exit_1er_while;
											}//fin de saisir de DVD
											
											else  {
												System.out.println("\tSaisissez 1,2 ou 3: ");
												scanne.nextLine(); //vider le reste de la ligne
												continue exit_saisir_while; 
										
											}
										
											
										}//fin de if
										else {
											System.out.println("\tSaisissez 1,2 ou 3: ");
											scanne.nextLine(); //vider le reste de la ligne
											continue exit_saisir_while; 

										}//fin else

									}//fin de while

							}//fin de else if
							else if(i==3) {

								System.out.println("\tSauvegarde de la médiathèque avec "+ouvrages.size()+" ouvrages réalisée");
								System.out.println("\n\tAu revoir et à bientôt");
								try {
									ReadWriteFile.saveLibrery(ouvrages);
								} catch (IOException e) {
									System.err.println("Fichier de source introuvable: "+e );
								}
								System.exit(-1);


							}
							else { System.out.println("\tSaisissez 1,2 ou 3: ");
							scanne.nextLine(); //vider le reste de la ligne
							continue exit_deuxiem_while; 
							}//fin de else


						}//fin de 2eme while
						else { System.out.println("\tSaisissez 1,2 ou 3: ");
						scanne.nextLine(); //vider le reste de la ligne
						continue exit_deuxiem_while; 
						}//fin de else

					}//fin_de_1er_condition

			}//fin_de_permier_while












	}



	public static void bienvenueMassage() {

		System.out.println("\t******************************************");
		System.out.println("\t*    Bienvenue dans la mediatheque       *");
		System.out.println("\t*            De votre Ville              *");
		System.out.println("\t******************************************\n");

	}

	public static void menu() {
		System.out.println("\n\tMerci de faire un choix entre:");
		System.out.println("\t[1] - Entrer un nouvel ouvrage");
		System.out.println("\t[2] - Affiche les ouvrages de la médiathèque");
		System.out.println("\t[3] - Sortir de la médiathèque");
		System.out.println("\n\tVotre choix (Entrez 1, 2 ou 3 puis entrée) ?");
	}
	public static void saisirMenu(){

		System.out.println("\tQuel ouvrage souhaitz vous entrez ?");
		System.out.println("\t[1] - Livre");
		System.out.println("\t[2] - CD");
		System.out.println("\t[3] - DVD");
		System.out.println("\n\tVotre choix entre 1 et 3 : ");



	}





}

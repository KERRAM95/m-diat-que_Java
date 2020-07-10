package médiathèque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;





public class ReadWriteFile {

	private final static String filename="C:\\Users\\merad\\eclipse-workspace\\Médiathèque\\src\\Donnees\\Collection.txt";
	 
	
	
	

	public static ArrayList<IOuvrage> loadLibrery()throws IOException{
        Path p= Paths.get(filename);
		try(BufferedReader read =Files.newBufferedReader(p, StandardCharsets.UTF_8)){ 
			 
			ArrayList<IOuvrage> ouvrage =new ArrayList<>(); 
			String[] args; 
			for(String line=read.readLine(); line!=null; line=read.readLine()) {
				args=line.trim().split(";");
			    switch(args[0]) {
			    
			    case "Livre": ouvrage.add(new Livre(args[0],args[1],args[2],Boolean.parseBoolean(args[3]),args[4],args[5]));
				break; 
			    case "DVD": ouvrage.add(new DVD(args[0],args[1],args[2],Boolean.parseBoolean(args[3]),args[4],args[5]));
				break;
			    case "CD": ouvrage.add(new CD(args[0],args[1],args[2],Boolean.parseBoolean(args[3]),args[4],args[5]));
				break;
				default: 
			    } 	      
		}
		
			return ouvrage; 
		}		
	}

	public static void saveLibrery(ArrayList<IOuvrage> ouvrages)throws IOException {

		Path p= Paths.get(filename);
		String line=null; 
		try(BufferedWriter read =Files.newBufferedWriter(p, StandardCharsets.UTF_8) ){ 
			for(IOuvrage s:ouvrages) {
				line=s.getType()+";"+s.getAuteur()+";"+s.getTitre()+";"+s.isDisponible()+";";
				line=line+s.getDateDeSortie()+";"+s.getDateDeRetour(); 
				read.write(line);
				read.newLine();

			}
			read.flush();
			read.close();
			return; 
		}	

	}
	
	/*verification si le fichier de stockage est vide*/
	public static boolean fileisempty() throws IOException {
		Path p= Paths.get(filename);
		try(BufferedReader read = Files.newBufferedReader(p, StandardCharsets.UTF_8) ){ 
			
		if(read.readLine()!=null) { return false;} 
              
			
		}
		
		return true;
			 
		}

		
	@SuppressWarnings("deprecation")
	public static boolean estValidDateSortie(String inDate) {
		Date date =new Date();  
		/* verfication si la date saisi est valide*/
		if(!estValidDate(inDate)) return false; 
		/*verfication si cette n'est pas la date d'aujourd'hui*/
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		String date1=dateFormat.format(date); 
		//System.err.print(date1+" "+inDate+" "+date1==inDate);
		if(dateFormat.format(date).equals(inDate)) return false;   
		
		  return true; 
		
		
		
	}
	
	
	  public static boolean estValidDate(String inDate) {
		  
		  
		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    dateFormat.setLenient(false);
		   
		    try { 
		    	dateFormat.parse(inDate);
		    	  String[] Date=inDate.split("/"); 
				  int year= Integer.parseInt(Date[2]);
				  int month= Integer.parseInt(Date[1]);
				  int day= Integer.parseInt(Date[0]);
		    if(ReadWriteFile.anneeBissextil(year)==false&&month==2&&day==29&&day>30) return false;
		    } catch (ParseException e) {
		      return false;
		    }
		    return true;
		    
		  }
	  
	  public static boolean anneeBissextil(int year) {
		  if(year % 4 ==0 && year % 100 != 0){
			   //c'est bissextile
			  return true;
			}else if(year % 400 == 0){
			   //c'est bissextile
				return true; 
			}else {
			 // c'est pas bissextile
				return false; 
			}
		  
	  }
	  
	  
	 
		
		
	
		
	






}

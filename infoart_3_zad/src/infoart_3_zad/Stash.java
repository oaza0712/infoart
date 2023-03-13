package infoart_3_zad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

public class Stash {
	
	private String idArticle;
	private String idStore;
	private String quantity;
	
	
	public Stash(String idArticle, String idStore, String quantity) {
		super();
		this.idArticle = idArticle;
		this.idStore = idStore;
		this.quantity = quantity;
	}


	public String getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}


	public String getIdStore() {
		return idStore;
	}


	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public static ArrayList<Stash> parseFile(String pathName){
		 
  	    ArrayList<Stash> stash = new ArrayList<Stash>();

	        try {
	        	
	        	FileInputStream file = new FileInputStream(pathName);
	        	InputStreamReader input = new InputStreamReader(file, Charset.forName("windows-1250"));
	        	BufferedReader reader = new BufferedReader(input);
	        	
	        	
	        	while(reader.ready()) {
	        		 
	        	     String line = reader.readLine();
	        	     
	        	     String separatedLine[] = line.split("\\|");
	        	     
	        	     String id_article = separatedLine[0];
	        	     String id_store = separatedLine[1];
	        	     String quantity = separatedLine[2];
	        	     
	        	     Stash stashItem = new Stash(id_article, id_store, quantity);
	        	     stash.add(stashItem);
	        	     
	        	     System.out.println(line);
	        	}
	        	
	        	reader.close();  
	        	input.close();
	        	
	        	
	        } catch(IOException e) {
	              e.printStackTrace();
	        }
	        
     	return stash;


	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idArticle, idStore, quantity);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stash other = (Stash) obj;
		return Objects.equals(idArticle, other.idArticle) && Objects.equals(idStore, other.idStore)
				&& Objects.equals(quantity, other.quantity);
	}


	@Override
	public String toString() {
		return "Stash [idArticle=" + idArticle + ", idStore=" + idStore + ", quantity=" + quantity + "]";
	}
	
	


}

package infoart_3_zad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

public class Stash {
	
	private String id_article;
	private String id_store;
	private float quantity;
	
	
	public Stash(String id_article, String id_store, float quantity) {
		super();
		this.id_article = id_article;
		this.id_store = id_store;
		this.quantity = quantity;
	}


	public String getId_article() {
		return id_article;
	}


	public void setId_article(String id_article) {
		this.id_article = id_article;
	}


	public String getId_store() {
		return id_store;
	}


	public void setId_store(String id_store) {
		this.id_store = id_store;
	}


	public float getQuantity() {
		return quantity;
	}


	public void setQuantity(float quantity) {
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
	        	     String quantity = separatedLine[2].replaceAll(",", ".");;
	        	     

	        	     stash.add(new Stash(id_article, id_store, Float.parseFloat(quantity)));
	        	     
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
		return Objects.hash(id_article, id_store, quantity);
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
		return Objects.equals(id_article, other.id_article) && Objects.equals(id_store, other.id_store)
				&& Float.floatToIntBits(quantity) == Float.floatToIntBits(other.quantity);
	}


	@Override
	public String toString() {
		return "Stash [id_article=" + id_article + ", id_store=" + id_store + ", quantity=" + quantity + "]";
	}
	
	


}

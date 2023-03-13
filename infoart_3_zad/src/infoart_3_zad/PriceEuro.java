package infoart_3_zad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

public class PriceEuro {
	
	private String idArticle;
	private String priceEuro;
	
	
	public PriceEuro(String idArticle, String priceEuro) {
		super();
		this.idArticle = idArticle;
		this.priceEuro = priceEuro;
	}


	public String getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}


	public String getPriceEuro() {
		return priceEuro;
	}


	public void setPriceEuro(String priceEuro) {
		this.priceEuro = priceEuro;
	}

	public static ArrayList<PriceEuro> parseFile(String pathName){
		 
  	    ArrayList<PriceEuro> pricesEuro = new ArrayList<PriceEuro>();

	        try {
	        	
	        	FileInputStream file = new FileInputStream(pathName);
	        	InputStreamReader input = new InputStreamReader(file, Charset.forName("windows-1250"));
	        	BufferedReader reader = new BufferedReader(input);
	        	
	        	
	        	while(reader.ready()) {
	        		 
	        	     String line = reader.readLine();
	        	     
	        	     String separatedLine[] = line.split("\\|");
	        	     
	        	     String id = separatedLine[0];
	        	     String priceEuro = separatedLine[1];
	        	     

	        	     pricesEuro.add(new PriceEuro(id, priceEuro));
	        	     
	        	     System.out.println(line);
	        	}
	        	
	        	reader.close();  
	        	input.close();
	        	
	        	
	        } catch(IOException e) {
	              e.printStackTrace();
	        }
	        
     	return pricesEuro;


	}
	

	@Override
	public int hashCode() {
		return Objects.hash(idArticle, priceEuro);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceEuro other = (PriceEuro) obj;
		return Objects.equals(idArticle, other.idArticle)
				&& Objects.equals(priceEuro, other.priceEuro);
	}


	@Override
	public String toString() {
		return "PriceEuro [article_id=" + idArticle + ", priceEuro=" + priceEuro + "]";
	}
}

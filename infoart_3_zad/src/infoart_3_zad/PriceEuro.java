package infoart_3_zad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

public class PriceEuro {
	
	private String article_id;
	private float priceEuro;
	
	
	public PriceEuro(String article_id, float priceEuro) {
		super();
		this.article_id = article_id;
		this.priceEuro = priceEuro;
	}


	public String getArticle_id() {
		return article_id;
	}


	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}


	public float getPriceEuro() {
		return priceEuro;
	}


	public void setPriceEuro(float priceEuro) {
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
	        	     String priceEuro = separatedLine[1].replaceAll(",", ".");;
	        	     

	        	     pricesEuro.add(new PriceEuro(id, Float.parseFloat(priceEuro)));
	        	     
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
		return Objects.hash(article_id, priceEuro);
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
		return Objects.equals(article_id, other.article_id)
				&& Float.floatToIntBits(priceEuro) == Float.floatToIntBits(other.priceEuro);
	}


	@Override
	public String toString() {
		return "PriceEuro [article_id=" + article_id + ", priceEuro=" + priceEuro + "]";
	}
}

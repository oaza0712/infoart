package infoart_3_zad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

public class Store {
	
	private String id;
	private String name;
	
	
	public Store(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public static ArrayList<Store> parseFile(String pathName){
		 
  	    ArrayList<Store> stores = new ArrayList<Store>();

	        try {
	        	
	        	FileInputStream file = new FileInputStream(pathName);
	        	InputStreamReader input = new InputStreamReader(file, Charset.forName("windows-1250"));
	        	BufferedReader reader = new BufferedReader(input);
	        	
	        	
	        	while(reader.ready()) {
	        		 
	        	     String line = reader.readLine();
	        	     
	        	     String separatedLine[] = line.split("\\|");
	        	     
	        	     String id = separatedLine[0];
	        	     String name = separatedLine[1];
	        	     

	        	     stores.add(new Store(id, name));
	        	     
	        	     System.out.println(line);
	        	}
	        	
	        	reader.close();  
	        	input.close();
	        	
	        	
	        } catch(IOException e) {
	              e.printStackTrace();
	        }
     	return stores;


	    }
	 


	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	
}

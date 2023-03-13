package infoart_3_zad;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Objects;

public class Article {
	private String id;
	private String name;
	private String measuringUnit;
	
	public Article(String id, String name, String measuringUnit) {
		super();
		this.id = id;
		this.name = name;
		this.measuringUnit = measuringUnit;
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
	public String getMeasuringUnit() {
		return measuringUnit;
	}
	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}
	
	 public static ArrayList<Article> parseFile(String pathName){
		 
  	    ArrayList<Article> articles = new ArrayList<Article>();

	        try {
	        	
	        	FileInputStream file = new FileInputStream(pathName);
	        	InputStreamReader input = new InputStreamReader(file, Charset.forName("windows-1250"));
	        	BufferedReader reader = new BufferedReader(input);
	        	
	        	
	        	while(reader.ready()) {
	        		 
	        	     String line = reader.readLine();
	        	     
	        	     String separatedLine[] = line.split("\\|");
	        	     
	        	     String id = separatedLine[0];
	        	     String name = separatedLine[1];
	        	     String measuringUnit = separatedLine[2];

	        	     articles.add(new Article(id, name, measuringUnit));
	        	}
	        	
	        	reader.close();  
	        	input.close();
	        	
	        	
	        } catch(IOException e) {
	              e.printStackTrace();
	        }
	        
     	return articles;


	    }
	 
	
	@Override
	public String toString() {
		return "Article [id=" + id + " name=" + name + " measuringUnit=" + measuringUnit + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(measuringUnit, name, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(measuringUnit, other.measuringUnit)
				&& Objects.equals(name, other.name) && Objects.equals(id, other.id);
	}
	
}

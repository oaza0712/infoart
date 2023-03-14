package infoart_3_zad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Objects;

public class StashValueOutput {
	
	private ArrayList<StashValue> StashValue;
	
	

	public StashValueOutput(ArrayList<infoart_3_zad.StashValue> stashValue) {
		super();
		StashValue = stashValue;
	}



	public ArrayList<StashValue> getStashValue() {
		return StashValue;
	}



	public void setStashValue(ArrayList<StashValue> stashValue) {
		StashValue = stashValue;
	}


	public void formatNumbers(){
		
		ArrayList<StashValue> stashValue = this.getStashValue();
		
		stashValue.forEach(item -> {
				
			item.setValueStashEuro(item.addThousandsSeparator('.',item.getValueStashEuro()));

			item.setValueDiffCurrency(item.addThousandsSeparator('.',item.getValueDiffCurrency()));
			
			item.setNumberOfArticles(item.addThousandsSeparator('.',item.getNumberOfArticles()));
			
		});
				 
	}
	
	public static String formatOutput(StashValue item, String dellimiter, String newLine) {
		
		return item.getId() + dellimiter + item.getName() + dellimiter +item.getValueStashEuro() + dellimiter
			 		+ item.getValueDiffCurrency() + dellimiter + item.getNumberOfArticles() + newLine; 
			
	}
	
	public void createStashValueFile() {
		
		 try {
		      File articleStashFile = new File("./output/vrijednost zalihe - PM.txt");
		      if (articleStashFile.createNewFile()) {
		        System.out.println("File created: " + articleStashFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 
	}
	
	
	public void fillStashValueFile(ArrayList<StashValue> articleStash, String dellimiter, String newLine) {
		
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
				    new FileOutputStream("./output/vrijednost zalihe - PM.txt"), "UTF-8"));
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(StashValue item: articleStash) {
			String line = StashValueOutput.formatOutput(item,dellimiter,newLine);
		try {
			writer.write(line);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		}
	    try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
           
		
	} 
	
    
	
	@Override
	public int hashCode() {
		return Objects.hash(StashValue);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StashValueOutput other = (StashValueOutput) obj;
		return Objects.equals(StashValue, other.StashValue);
	}



	@Override
	public String toString() {
		return "StashValueOutput [StashValue=" + StashValue + "]";
	}


}

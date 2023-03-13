package infoart_3_zad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Objects;

public class ArticleStashOutput {
	
	private ArrayList<ArticleStash> articleStash;

	public ArticleStashOutput(ArrayList<ArticleStash> articleStash) {
		super();
		this.articleStash = articleStash;
	}
	
	public ArrayList<ArticleStash> getArticleStash() {
		return articleStash;
	}

	public void setArticleStash(ArrayList<ArticleStash> articleStash) {
		this.articleStash = articleStash;
	}
	
	public void formatNumbers(){
		
		ArrayList<ArticleStash> articleStash = this.getArticleStash();
		
		articleStash.forEach(item -> {
				
			item.setPriceEuro(item.addThousandsSeparator('.',item.getPriceEuro()));

			item.setQuantityAllStores(item.addThousandsSeparator('.',item.getQuantityAllStores()));
			
			item.setValueAllStoresEuro(item.addThousandsSeparator('.',item.getValueAllStoresEuro()));
			
			item.setValueAllStoresDiffCurrency(item.addThousandsSeparator('.',item.getValueAllStoresDiffCurrency()));
			
			item.setNumberOfStoresWithArticle(item.addThousandsSeparator('.',item.getNumberOfStoresWithArticle()));
		});
				 
	}
	
	public static String formatOutput(ArticleStash item, String dellimiter, String newLine) {
		
		return item.getId() + dellimiter + item.getName() + dellimiter +item.getPriceEuro() + dellimiter
			 		+ item.getQuantityAllStores() + dellimiter + item.getMeasuringUnit() + dellimiter
			 		+ item.getValueAllStoresEuro() + dellimiter + item.getValueAllStoresDiffCurrency() + dellimiter
			 		+ item.getNumberOfStoresWithArticle() + newLine; 
			
	}
	
	public void createArticleStashFile() {
		
		 try {
		      File articleStashFile = new File("./output/vrijednost zalihe - artikli.txt");
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
	
	
	public void fillArticleStashFile(ArrayList<ArticleStash> articleStash, String dellimiter, String newLine) {
		
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
				    new FileOutputStream("./output/vrijednost zalihe - artikli.txt"), "UTF-8"));
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(ArticleStash item: articleStash) {
			String line = ArticleStashOutput.formatOutput(item,dellimiter,newLine);
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
		return Objects.hash(articleStash);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleStashOutput other = (ArticleStashOutput) obj;
		return Objects.equals(articleStash, other.articleStash);
	}
	
	

	@Override
	public String toString() {
		
		return "ArticleStashOutput [articleStash=" + articleStash.toString() + "]";
	}

	

	

}

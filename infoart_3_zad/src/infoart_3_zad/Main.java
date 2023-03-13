package infoart_3_zad;


import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Article> articles = Article.parseFile("./input/artikli.txt");
		ArrayList<Store> stores = Store.parseFile("./input/pm.txt");
		ArrayList<PriceEuro> pricesEuro = PriceEuro.parseFile("./input/cjenik.txt");
		ArrayList<Stash> stash = Stash.parseFile("./input/stanja.txt");
		
		float[] quantityAllStores = new float[articles.size()];
		float[] valueAllStoresEuro = new float[articles.size()];
		int[] numberOfStoresWithArticle = new int[articles.size()];

		int counter = 0;
		
		  for (Article article : articles)
	      { 		      
			  float quantity = 0;
			  float valueInEuro = 0;
			  int numberOfStores = 0;
			  
			  //calculating number of articles in all stores
			  //counting in how many stores article is available in
			  for(Stash articleStash: stash){ 
				   
				   if(article.getId().equals(articleStash.getId_article())) {
					   if(articleStash.getQuantity() != 0) {
						   numberOfStores++;
						   quantity += articleStash.getQuantity();
					   }
				   }
			  }
			  numberOfStoresWithArticle[counter] = numberOfStores;
			  quantityAllStores[counter] = quantity;

			  //calculating worth of an article in all stores in Euro
			  for(PriceEuro priceEuro: pricesEuro){ 
				   
				   if(article.getId().equals(priceEuro.getArticle_id())) {
						  valueInEuro = quantity * priceEuro.getPriceEuro();
				   }
			  }
			  			  
			  valueAllStoresEuro[counter] = valueInEuro;
			  
			  //calculating worth of an article in all stores in wanted currency
			  
			  counter++;
			  
	      }
		  
		  
		 
			  
		  
		  
		
	}
	
	
	

}

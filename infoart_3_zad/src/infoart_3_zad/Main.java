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
		
		
		
		  for (Stash str : stash)
	      { 		      
	           System.out.println(str.toString()); 		
	      }
		
	}
	
	
	

}

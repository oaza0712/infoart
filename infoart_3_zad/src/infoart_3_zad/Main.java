package infoart_3_zad;


import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		
		String wantedCurrency = args[0];
		float conversionRate = 1;
		
		//calculating conversion rate with public API
		String response = sendHTTPRequest.sendGETRequest();
		  
		  //spliting response by rows
		  String conversionRates[] = response.split("\n");
		  
		  //gores through each row
		  for(int i = 1; i < conversionRates.length; i++) {
			  
			  String[] line = conversionRates[i].split(" ");
			  
			  int flag = 0;
			  
			  if(line[0].equals(wantedCurrency)) {
				  
				  for(int j = 2; j < line.length ; j++) {

					  if (!line[j].isEmpty()) {
						  flag++;
					  }
					  
					  if (flag == 2){ 
			      		conversionRate = (Float.parseFloat(line[j].replaceAll(",", ".")));
			      		break;
					  }
					  
				  }  
      		}
			  
		  }

		//storing data from input into objects
		ArrayList<Article> articles = Article.parseFile("./input/artikli.txt");
		ArrayList<Store> stores = Store.parseFile("./input/pm.txt");
		ArrayList<PriceEuro> pricesEuro = PriceEuro.parseFile("./input/cjenik.txt");
		ArrayList<Stash> stash = Stash.parseFile("./input/stanja.txt");
		
		//making list with objects that store all information needed to make output files
		ArrayList<ArticleStash> articleStash = ArticleStash.makeArticleStashObject(articles, stores, pricesEuro, stash, conversionRate);
		ArrayList<StashValue> stashValue = StashValue.makeStashValueObject(articles, stores, pricesEuro, stash, conversionRate);

		//sorting lists by articleId or storeId
		Collections.sort(articleStash, new Comparator<ArticleStash>() {
		    @Override
		    public int compare(ArticleStash o1, ArticleStash o2) {
		        return o1.getId().compareTo(o2.getId());
		    }
		});
		
		
		Collections.sort(stashValue, new Comparator<StashValue>() {
		    @Override
		    public int compare(StashValue o1, StashValue o2) {
		        return o1.getId().compareTo(o2.getId());
		    }
		});
		
		 for(int i = 0; i < 5; i++) {
	        	System.out.println(stashValue.get(i));
	        }
		 
        //formatting numbers - adding thousands separator
		ArticleStashOutput articleStashFormated = new ArticleStashOutput(articleStash);
		articleStashFormated.formatNumbers();
		
		StashValueOutput stashValueFormated = new StashValueOutput(stashValue);
		stashValueFormated.formatNumbers();
		
		for(int i = 0; i < 5; i++) {
        	System.out.println(stashValueFormated.getStashValue().get(i));
        }
		
		//making output files
		articleStashFormated.createArticleStashFile();
		stashValueFormated.createStashValueFile();
		
		//writing in output files
		String dellimiter = "\t";
		String newLine = "\n";
		
		articleStashFormated.fillArticleStashFile(articleStashFormated.getArticleStash(), dellimiter, newLine);
		stashValueFormated.fillStashValueFile(stashValueFormated.getStashValue(), dellimiter, newLine);
	}
	
	
	

}

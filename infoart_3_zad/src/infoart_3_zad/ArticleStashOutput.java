package infoart_3_zad;

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
	
	public void format(){
		
		ArrayList<ArticleStash> articleStash = this.getArticleStash();
		
		articleStash.forEach(item -> {
				
			item.setPriceEuro(item.addThousandsSeparator('.',item.getPriceEuro()));

			item.setQuantityAllStores(item.addThousandsSeparator('.',item.getQuantityAllStores()));
			
			item.setValueAllStoresEuro(item.addThousandsSeparator('.',item.getValueAllStoresEuro()));
			
			item.setValueAllStoresDiffCurrency(item.addThousandsSeparator('.',item.getValueAllStoresDiffCurrency()));
			
			item.setNumberOfStoresWithArticle(item.addThousandsSeparator('.',item.getNumberOfStoresWithArticle()));
		
		});
		
		
		//articleStash ArticleStash.sortByArticleId(articleStash);
		 
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

package infoart_3_zad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ArticleStash {
	
	private String id;
	private String name;
	private String priceEuro;
	private String quantityAllStores;
	private String measuringUnit;
	private String valueAllStoresEuro;
	private String valueAllStoresDiffCurrency;
	private String numberOfStoresWithArticle;
	
	
	
	public ArticleStash(String id, String name, String priceEuro, String quantityAllStores, String measuringUnit,
			String valueAllStoresEuro, String valueAllStoresDiffCurrency, String numberOfStoresWithArticle) {
		super();
		this.id = id;
		this.name = name;
		this.priceEuro = priceEuro;
		this.quantityAllStores = quantityAllStores;
		this.measuringUnit = measuringUnit;
		this.valueAllStoresEuro = valueAllStoresEuro;
		this.valueAllStoresDiffCurrency = valueAllStoresDiffCurrency;
		this.numberOfStoresWithArticle = numberOfStoresWithArticle;
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



	public String getPriceEuro() {
		return priceEuro;
	}



	public void setPriceEuro(String priceEuro) {
		this.priceEuro = priceEuro;
	}



	public String getQuantityAllStores() {
		return quantityAllStores;
	}



	public void setQuantityAllStores(String quantityAllStores) {

		this.quantityAllStores = quantityAllStores;
	}



	public String getMeasuringUnit() {
		return measuringUnit;
	}



	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}



	public String getValueAllStoresEuro() {
		return valueAllStoresEuro;
	}



	public void setValueAllStoresEuro(String valueAllStoresEuro) {
		this.valueAllStoresEuro = valueAllStoresEuro;
	}



	public String getValueAllStoresDiffCurrency() {
		return valueAllStoresDiffCurrency;
	}



	public void setValueAllStoresDiffCurrency(String valueAllStoresDiffCurrency) {
		this.valueAllStoresDiffCurrency = valueAllStoresDiffCurrency;
	}



	public String getNumberOfStoresWithArticle() {
		return numberOfStoresWithArticle;
	}



	public void setNumberOfStoresWithArticle(String numberOfStoresWithArticle) {
		this.numberOfStoresWithArticle = numberOfStoresWithArticle;
	}

	
	public static ArrayList<ArticleStash> makeArticleStashObject(
	ArrayList<Article> articles,
	ArrayList<Store> stores,
	ArrayList<PriceEuro> pricesEuro,
	ArrayList<Stash> stash,
	float conversionRate) 
	{
		
		 ArrayList<ArticleStash> articleStashList = new ArrayList<ArticleStash>();
		 
		 for (Article article : articles)
	     { 		
			 
			  float quantity = 0;
			  float valueInEuro = 0;
			  float priceInEuro = 0;
			  int numberOfStores = 0;
			  float valueAllStoresCurrency = 0;
			  
			  //calculating number of articles in all stores
			  //counting in how many stores article is available in
			  for(Stash articleStash: stash){ 
				   
				   if(article.getId().equals(articleStash.getIdArticle())) {
					   if(articleStash.getQuantity() != "0") {
						  
						   numberOfStores++;
						   quantity += Float.parseFloat(articleStash.getQuantity().replace(",", "."));
					   }
				   }
			  }
			 

			  //calculating worth of an article in all stores in Euro
			  for(PriceEuro priceEuro: pricesEuro){ 
				   
				   if(article.getId().equals(priceEuro.getIdArticle())) {
					 
					   valueInEuro = quantity * Float.parseFloat(priceEuro.getPriceEuro().replace(",", "."));
					   priceInEuro = Float.parseFloat(priceEuro.getPriceEuro().replace(",", "."));
				   }
			  }
			  			  
			 
			  //calculating worth of an article in all stores in wanted currency
			  valueAllStoresCurrency = valueInEuro * conversionRate;
			  
			  ArticleStash articleStash= new ArticleStash(article.getId(), article.getName(),(String.valueOf(priceInEuro)).replace(".", ","), String.valueOf(quantity).replace(".", ","), article.getMeasuringUnit(), String.valueOf(valueInEuro).replace(".", ","), String.valueOf(valueAllStoresCurrency).replace(".", ","), String.valueOf(numberOfStores).replace(".", ","));
			  articleStashList.add(articleStash);
			  }
	      
		  
		return articleStashList;
	}

    
	public String addThousandsSeparator(char thousandsSeparator, String numberToFormat) {
				
		String[] number = numberToFormat.split(",");
		String intNumber = number[0];
		String decimalPart = "";
		String finalNumber = intNumber;
		
		
		if(intNumber.length() >= 4) {
		for(int j = intNumber.length() - 1 - 2; j >= 1; j-=3){
			
			intNumber = intNumber.substring(0, j) 
                    + thousandsSeparator 
                    + intNumber.substring(j,intNumber.length());

		 }}
		
		if(number.length > 1) {
			decimalPart = number[1];
			finalNumber = intNumber + "," + decimalPart;
		}
		return finalNumber;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, measuringUnit, name, numberOfStoresWithArticle, priceEuro, quantityAllStores,
				valueAllStoresDiffCurrency, valueAllStoresEuro);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleStash other = (ArticleStash) obj;
		return Objects.equals(id, other.id) && Objects.equals(measuringUnit, other.measuringUnit)
				&& Objects.equals(name, other.name)
				&& Objects.equals(numberOfStoresWithArticle, other.numberOfStoresWithArticle)
				&& Objects.equals(priceEuro, other.priceEuro)
				&& Objects.equals(quantityAllStores, other.quantityAllStores)
				&& Objects.equals(valueAllStoresDiffCurrency, other.valueAllStoresDiffCurrency)
				&& Objects.equals(valueAllStoresEuro, other.valueAllStoresEuro);
	}

	

	@Override
	public String toString() {
		return "ArticleStash [id=" + id + " name=" + name + " priceEuro=" + priceEuro + " quantityAllStores="
				+ quantityAllStores + " measuringUnit=" + measuringUnit + " valueAllStoresEuro=" + valueAllStoresEuro
				+ " valueAllStoresDiffCurrency=" + valueAllStoresDiffCurrency + " numberOfStoresWithArticle="
				+ numberOfStoresWithArticle + "]";
	}
	
	
	
	

	
	
	

}

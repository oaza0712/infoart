package infoart_3_zad;

import java.util.ArrayList;
import java.util.Objects;

public class StashValue {
	
	private String id;
	private String name;
	private String valueStashEuro;
	private String valueDiffCurrency;
	private String numberOfArticles;
	
	
	public StashValue(String id, String name, String valueStashEuro, String valueDiffCurrency,
			String numberOfArticles) {
		super();
		this.id = id;
		this.name = name;
		this.valueStashEuro = valueStashEuro;
		this.valueDiffCurrency = valueDiffCurrency;
		this.numberOfArticles = numberOfArticles;
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


	public String getValueStashEuro() {
		return valueStashEuro;
	}


	public void setValueStashEuro(String valueStashEuro) {
		this.valueStashEuro = valueStashEuro;
	}


	public String getValueDiffCurrency() {
		return valueDiffCurrency;
	}


	public void setValueDiffCurrency(String valueDiffCurrency) {
		this.valueDiffCurrency = valueDiffCurrency;
	}


	public String getNumberOfArticles() {
		return numberOfArticles;
	}


	public void setNumberOfArticles(String numberOfArticles) {
		this.numberOfArticles = numberOfArticles;
	}

	public static ArrayList<StashValue> makeStashValueObject(
			ArrayList<Article> articles,
			ArrayList<Store> stores,
			ArrayList<PriceEuro> pricesEuro,
			ArrayList<Stash> stash,
			float conversionRate) 
			{
				
				 ArrayList<StashValue> stashValueList = new ArrayList<StashValue>();
				 
				 for (Store store : stores)
			     { 		
					 
					  float valueInEuro = 0;
					  float numberOfAllArticles = 0;
					  float numberOfArticle = 0;
					  float valueAllStoresCurrency = 0;
					  
					  //calculating number of all articles in each store 
					  for(Stash articleStash: stash){ 
						   
						   if(store.getId().equals(articleStash.getIdStore())) {
							   if(articleStash.getQuantity() != "0") {
								   
								   numberOfArticle = Float.parseFloat(articleStash.getQuantity().replace(",", "."));
								   numberOfAllArticles += numberOfArticle;
								   
								   //calculating value of all articles in for each store in euro
								   for(PriceEuro priceEuro: pricesEuro){ 
									   if(articleStash.getIdArticle().equals(priceEuro.getIdArticle())) {
			
										   valueInEuro += numberOfArticle * Float.parseFloat(priceEuro.getPriceEuro().replace(",", "."));
									   }
								   }
							   }
						   }
					  }
					 
		 
					  valueAllStoresCurrency = valueInEuro * conversionRate;
					  
					  StashValue stashValue = new StashValue(store.getId(), 
							  				  				 store.getName(),
							  				  				 String.valueOf(valueInEuro).replace(".", ","), 
							  				  				 String.valueOf(valueAllStoresCurrency).replace(".", ","), 
							                  				 String.valueOf(numberOfAllArticles).replace(".", ","));
					  stashValueList.add(stashValue);
					 }
			      
				  
				return stashValueList;
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
		return Objects.hash(id, name, numberOfArticles, valueDiffCurrency, valueStashEuro);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StashValue other = (StashValue) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(numberOfArticles, other.numberOfArticles)
				&& Objects.equals(valueDiffCurrency, other.valueDiffCurrency)
				&& Objects.equals(valueStashEuro, other.valueStashEuro);
	}


	@Override
	public String toString() {
		return "StashValue [id=" + id + ", name=" + name + ", valueStashEuro=" + valueStashEuro + ", valueDiffCurrency="
				+ valueDiffCurrency + ", numberOfArticles=" + numberOfArticles + "]";
	}
	
	
}

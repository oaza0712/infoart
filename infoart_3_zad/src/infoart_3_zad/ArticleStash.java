package infoart_3_zad;

import java.util.Objects;

public class ArticleStash {
	
	private String id;
	private String name;
	private float priceEuro;
	private int quantityAllStores;
	private String measuringUnit;
	private float valueAllStoresEuro;
	private float valueAllStoresDiffCurrency;
	private int numberOfStoresWithArticle;
	
	
	
	public ArticleStash(String id, String name, float priceEuro, int quantityAllStores, String measuringUnit,
			float valueAllStoresEuro, float valueAllStoresDiffCurrency, int numberOfStoresWithArticle) {
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



	public float getPriceEuro() {
		return priceEuro;
	}



	public void setPriceEuro(float priceEuro) {
		this.priceEuro = priceEuro;
	}



	public int getQuantityAllStores() {
		return quantityAllStores;
	}



	public void setQuantityAllStores(int quantityAllStores) {
		this.quantityAllStores = quantityAllStores;
	}



	public String getMeasuringUnit() {
		return measuringUnit;
	}



	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}



	public float getValueAllStoresEuro() {
		return valueAllStoresEuro;
	}



	public void setValueAllStoresEuro(float valueAllStoresEuro) {
		this.valueAllStoresEuro = valueAllStoresEuro;
	}



	public float getValueAllStoresDiffCurrency() {
		return valueAllStoresDiffCurrency;
	}



	public void setValueAllStoresDiffCurrency(float valueAllStoresDiffCurrency) {
		this.valueAllStoresDiffCurrency = valueAllStoresDiffCurrency;
	}



	public int getNumberOfStoresWithArticle() {
		return numberOfStoresWithArticle;
	}



	public void setNumberOfStoresWithArticle(int numberOfStoresWithArticle) {
		this.numberOfStoresWithArticle = numberOfStoresWithArticle;
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
				&& Objects.equals(name, other.name) && numberOfStoresWithArticle == other.numberOfStoresWithArticle
				&& Float.floatToIntBits(priceEuro) == Float.floatToIntBits(other.priceEuro)
				&& quantityAllStores == other.quantityAllStores
				&& Float.floatToIntBits(valueAllStoresDiffCurrency) == Float
						.floatToIntBits(other.valueAllStoresDiffCurrency)
				&& Float.floatToIntBits(valueAllStoresEuro) == Float.floatToIntBits(other.valueAllStoresEuro);
	}



	@Override
	public String toString() {
		return "ArticleStash [id=" + id + ", name=" + name + ", priceEuro=" + priceEuro + ", quantityAllStores="
				+ quantityAllStores + ", measuringUnit=" + measuringUnit + ", valueAllStoresEuro=" + valueAllStoresEuro
				+ ", valueAllStoresDiffCurrency=" + valueAllStoresDiffCurrency + ", numberOfStoresWithArticle="
				+ numberOfStoresWithArticle + "]";
	}
	

	
	
	

}

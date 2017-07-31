package ua.model.view;

import java.math.BigDecimal;
import java.util.List;

public class MealView {

	private Integer id;
	
	private String title;
	
	private String description;
	
	private BigDecimal price;
	
	private String photoUrl;
	
	private int version;
	
	private String coisine;
	
	private int weight;
	
	private List<String> ingredients;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return description;
	}

	public void setDescribe(String describe) {
		this.description = describe;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCoisine() {
		return coisine;
	}

	public void setCoisine(String coisine) {
		this.coisine = coisine;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}

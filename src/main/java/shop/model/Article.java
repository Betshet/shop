package shop.model;

public class Article {
	
	private int id;
	private String name;
	private float price;
	private String desc;
	private int stock;
	
	public Article(int id, String name, float price, String desc, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;	
		this.desc = desc;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}

	public int getStock() {
		return stock;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}

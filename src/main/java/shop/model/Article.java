package shop.model;
/**
 * Class Article
 * An article.
 */
public class Article {
	/**
	 * Private attribute id
	 * Unique iditifier of the object.
	 */
	private int id;
	/**
	 * Private attribute name
	 * Name of the article.
	 */
	private String name;
	/**
	 * Private attribute price
	 * Price of the article.
	 */
	private float price;
	/**
	 * Private attribute desc
	 * Description of the article.
	 */
	private String desc;
	/**
	 * Private attribute stock
	 * Stock of the article.
	 */
	private int stock;
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param price
	 * @param desc
	 * @param stock
	 */
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

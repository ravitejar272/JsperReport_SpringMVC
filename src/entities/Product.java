package entities;

public class Product {
	private String id;
	private String name;
	private int quarity;
	private double price;

	public Product() {
	}

	public Product(String id, String name, int quarity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quarity = quarity;
		this.price = price;
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

	public int getQuarity() {
		return quarity;
	}

	public void setQuarity(int quarity) {
		this.quarity = quarity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

package com.code.techmart.model;

public class Product {
	private int id;
	private String model;
	private String name;
	private boolean display;
	private String type;
	private double price;
	private String image;
	
	public Product() {
	}

	public Product(int id, String model, String name, boolean display, String type, double price, String image) {
		super();
		this.id = id;
		this.model = model;
		this.name = name;
		this.display = display;
		this.type = type;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}


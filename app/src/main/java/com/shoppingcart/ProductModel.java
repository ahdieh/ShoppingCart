package com.shoppingcart;

public class ProductModel {

	private String imageUrl;
	private String productName;
	private String productDesc;
	private int productPrice;

	public ProductModel(String imageUrl, String productName, String productDesc, int productPrice) {
		this.imageUrl = imageUrl;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;


	}

	public String getProductImage() {
		return imageUrl;
	}

	public String getProductName() {

		return productName;
	}

	public String getProductDesc() {

		return productDesc;
	}

	public int getProductPrice() {

		return productPrice;

	}



}

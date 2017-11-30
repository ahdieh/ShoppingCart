package com.shoppingcart;


import java.util.ArrayList;

public class CartModel {
	private ArrayList<ProductModel> cartProducts = new ArrayList<ProductModel>();


	public ProductModel getProducts(int Position) {

		return cartProducts.get(Position);
	}

	public void setProducts(ProductModel products) {

		cartProducts.add(products);

	}

	public int getCartSize() {

		return cartProducts.size();

	}

	public boolean checkProductInCart(ProductModel product) {

		return cartProducts.contains(product);

	}
}

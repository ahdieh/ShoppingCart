package com.shoppingcart;


import android.app.Application;

import java.util.ArrayList;

public class Products extends Application{

	private ArrayList<ProductModel> myProducts = new ArrayList<ProductModel>();
	private  CartModel myCart = new CartModel();


	public ProductModel getProducts(int position) {

		return myProducts.get(position);
	}

	public void setProducts(ProductModel products) {

		myProducts.add(products);

	}

	public CartModel getCart() {

		return myCart;

	}

	public int getProductsArraylistSize() {

		return myProducts.size();
	}


	@Override
	public void onCreate() {
		super.onCreate();
	}
}

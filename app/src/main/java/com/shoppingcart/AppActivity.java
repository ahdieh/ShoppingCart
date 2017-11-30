package com.shoppingcart;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.ActionBar.LayoutParams;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class AppActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appactivity);

		final LinearLayout layout = (LinearLayout) findViewById(R.id.linearProduct);
		final Button checkout = (Button) findViewById(R.id.checkoutButton);


		final Products products = (Products) getApplicationContext();

		ProductModel productObject1 = new ProductModel("https://i5.walmartimages.ca/images/Large/534/1_1/999999-622356545341_1.jpg","Ninja 1200 watts Auto-iQ Blender", "Ninja Blender 1200 with Auto-iQ Technology", 79);
		products.setProducts(productObject1);

		ProductModel productObject2 = new ProductModel("https://i5.walmartimages.ca/images/Large/125/946/999999-69055125946.jpg","Oral-B Genius Rechargeable Toothbrush", "Oral-B Genius 8000 Electric Rechargeable Toothbrush Powered by Braun", 135);
		products.setProducts(productObject2);

		int ProductsSize = products.getProductsArraylistSize();


		// create the layout params that will be used to define how your
		// button will be displayed
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		/******** Dynamically create view elements - Start **********/

		for (int j = 0; j < ProductsSize; j++) {

			// Get probuct data from product data arraylist
			String pName = products.getProducts(j).getProductName();
			int pPrice = products.getProducts(j).getProductPrice();

			// Create LinearLayout to view elemnts
			LinearLayout ll = new LinearLayout(this);
			ll.setOrientation(LinearLayout.VERTICAL);

			ImageView productView = new ImageView(this);

			Uri uri = Uri.parse(products.getProducts(j).getProductImage());
			Glide.with(AppActivity.this)
					.load(uri)
					.into(productView);

			productView.setMaxHeight(2);
			productView.setMaxWidth(2);
			ll.addView(productView);

			TextView product = new TextView(this);
			product.setText(" " + pName + "    ");

			//Add textView to LinearLayout
			ll.addView(product);

			TextView tPrice = new TextView(this);
			tPrice.setText("  $" + pPrice + "     ");

			//Add textView to LinearLayout
			ll.addView(tPrice);

			final Button btn = new Button(this);
			btn.setId(j + 1);
			btn.setText("Add To Cart");

			// set the layoutParams on the button
			btn.setLayoutParams(params);

			final int index = j;

			//Create click listener for dynamically created button
			btn.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {

					//Clicked button index
					Log.i("TAG", "index :" + index);

					// Get product instance for index
					ProductModel tempProductObject = products.getProducts(index);

					//Check Product already exist in Cart or Not
					if (!products.getCart().checkProductInCart(tempProductObject)) {
						btn.setText("Added");

						// Product not Exist in cart so add product to
						// Cart product arraylist
						products.getCart().setProducts(tempProductObject);

						Toast.makeText(getApplicationContext(), "Now Cart size: " + products.getCart().getCartSize(),
								Toast.LENGTH_LONG).show();
					} else {
						// Cart product arraylist contains Product
						Toast.makeText(getApplicationContext(), "Product " + (index + 1) + " already added in cart.",
								Toast.LENGTH_LONG).show();
					}
				}
			});


			//Add button to LinearLayout
			ll.addView(btn);

			//Add LinearLayout to XML layout
			layout.addView(ll);
		}


			/******** Dynamically create view elements - End **********/

			checkout.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {

					Intent i = new Intent(getBaseContext(), CartActivity.class);
					startActivity(i);
				}
			});

	}

}

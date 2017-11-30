package com.shoppingcart;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class CartActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content);

		TextView showCartContent    = (TextView) findViewById(R.id.showCart);
		final Button paymentButton 		= (Button) findViewById(R.id.paymentButton);

		//Get Global Controller Class object (see application tag in AndroidManifest.xml)
		final Products products = (Products) getApplicationContext();

		// Get Cart Size
		final int cartSize = products.getCart().getCartSize();

		String showString = "";
		int price = 0;

/******** Show Cart Products on screen - Start ********/

		if(cartSize >0)
		{

			for(int i=0;i<cartSize;i++)
			{
				//Get product details
				String pImageUrl = products.getCart().getProducts(i).getProductImage();
				String pName 	= products.getCart().getProducts(i).getProductName();
				int pPrice   	= products.getCart().getProducts(i).getProductPrice();
				String pDisc   	= products.getCart().getProducts(i).getProductDesc();

				showString += "\n\nProduct Name : "+pName+"\n"+
						"Price : "+pPrice+"\n"+
						"Discription : "+pDisc+""+
						"\n -----------------------------------";

				price = price + pPrice;

			}
		}
		else showString = "\n\nShopping cart is empty.\n\n";

		showString = showString + "\n" + "TOTAL =  $" + price;
		showCartContent.setText(showString);

/******** Show Cart Products on screen - End ********/

		paymentButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
//				String url = "https://www.computerhope.com/jargon/m/example.mp3"; // your URL here

				 // might take long! (for buffering, etc)

				if(cartSize >0)
				{
					Intent i = new Intent(getBaseContext(), CartShow.class);
					startActivity(i);
				}
				else
					Toast.makeText(getApplicationContext(),
							"Shopping cart is empty.",
							Toast.LENGTH_LONG).show();
			}
		});

	}

	@Override
	protected void onDestroy() {

		super.onDestroy();

	}
}

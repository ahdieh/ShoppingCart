package com.shoppingcart;


import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class CartShow extends Activity{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cart);
		String url = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-13.mp3"; // your URL here

		final MediaPlayer mediaPlayer = new MediaPlayer();
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		try {
			mediaPlayer.setDataSource(url);
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		TextView showCartContent    = (TextView) findViewById(R.id.cart);

		//Get Global Controller Class object (see application tag in AndroidManifest.xml)
		final Products products = (Products) getApplicationContext();

		int cartSize = products.getCart().getCartSize();

		String showString = "";

       // Show Cart Products on screen

		for(int i=0;i<cartSize;i++)
		{
			//Get product details
			String pName 	= products.getCart().getProducts(i).getProductName();
			int pPrice   	= products.getCart().getProducts(i).getProductPrice();
			String pDisc   	= products.getCart().getProducts(i).getProductDesc();

			showString += "\n\nProduct Name : "+pName+"\n"+
					"Price : "+pPrice+"\n"+
					"Discription : "+pDisc+""+
					"\n -----------------------------------";
		}


		showCartContent.setText(showString);

		final Button stopMusic 		= (Button) findViewById(R.id.stopMusic);
		stopMusic.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mediaPlayer.stop();

			}
		});

	}
}

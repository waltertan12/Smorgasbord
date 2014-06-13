package com.waltertan12.bracket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Setup extends Activity implements OnClickListener{

	int numberOfRest;
	public boolean randomize;
	TextView tvNumberOfRest;

	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup);
		
		Button bSelectType = (Button) findViewById(R.id.continueButton);
		bSelectType.setOnClickListener(this);
		
		ImageView ivRight = (ImageView) findViewById(R.id.ivRight);
		ImageView ivLeft = (ImageView) findViewById(R.id.ivLeft);
		ivRight.setOnClickListener(this);
		ivLeft.setOnClickListener(this);
		
		tvNumberOfRest = (TextView) findViewById(R.id.tvNumberOfRests);
		
		numberOfRest = 4;
		tvNumberOfRest.setText(String.valueOf(numberOfRest));
	}

	public void startRestaurantSetup(){
		Bundle b = new Bundle();
		Intent intent = new Intent(this, AddRestaurantsActivity.class);
						
		b.putInt("Number of Restaurants", numberOfRest);
		intent.putExtras(b);
		startActivity(intent);
	}
	
	public void onClick(View v) {
		switch(v.getId()){ 
		
			case R.id.continueButton:
				Bundle b = new Bundle();
				Intent intent = new Intent(this, AddRestaurantsActivity.class);
								
				b.putInt("Number of Restaurants", numberOfRest);
				intent.putExtras(b);
				startActivity(intent);
			break;
			
			case R.id.ivRight:
				if (numberOfRest < 64){
						numberOfRest *=2;
						tvNumberOfRest.setText(String.valueOf(numberOfRest));
				}
			break;
			
			case R.id.ivLeft:
				if (numberOfRest > 2){
						numberOfRest /=2;
						tvNumberOfRest.setText(String.valueOf(numberOfRest));
				}
			break;
				
			
		}
	}

}

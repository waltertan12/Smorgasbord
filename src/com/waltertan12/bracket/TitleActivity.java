package com.waltertan12.bracket;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.waltertan12.bracket.AddRestaurantsActivity;


public class TitleActivity extends Activity {
	
	public List<String> restaurantList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title);
	}
	
	public void addRestaurants(View v) {
		// Launch the Activity using the intent
		Intent myIntent = new Intent(this,Setup.class);
		startActivity(myIntent);
	}
	
	
}

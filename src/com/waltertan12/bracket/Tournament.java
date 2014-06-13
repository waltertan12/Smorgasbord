package com.waltertan12.bracket;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tournament extends Activity {

	ArrayList<Restaurant> arrayListRestaurant;
	ArrayList<Match> matches;
	ListView lvTournament;
	ArrayAdapter<Restaurant> arrayAdapter;
	int numberOfRestaurants; //Number of restaurants still in contention
	
	
	public Tournament() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tournament);
		
		lvTournament = (ListView) findViewById(R.id.lvTournaments);
		
		matches = new ArrayList<Match>();
		
		arrayListRestaurant = getIntent().getParcelableArrayListExtra("Restaurants");
		arrayAdapter = new ArrayAdapter<Restaurant>(this,R.layout.activity_tournament,/*R.layout.activity_addrestaurants, R.id.tvNumberOfRests,*/arrayListRestaurant);
		lvTournament.setAdapter(arrayAdapter);
	}
	
	public int getRestaurantsLeft(){
		int count = 0;
		for(int i = 0; i < arrayListRestaurant.size(); i++){
			if(!arrayListRestaurant.get(i).isEliminated()){
				count++;
			}
		}
		return count;
	}

}

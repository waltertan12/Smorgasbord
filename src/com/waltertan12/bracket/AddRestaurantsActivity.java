package com.waltertan12.bracket;

import java.util.ArrayList;
import com.waltertan12.bracket.AddRestaurantDialogFragment.MyDialogListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class AddRestaurantsActivity extends Activity implements MyDialogListener{
	private ListView restList;
	public ArrayList<String> restaurantList;
	public ArrayList<Restaurant> arrayListRestaurant;
	public ArrayAdapter<String> arrayAdapter;
	public int numberOfRests;
	public boolean randomize; // randomize the seeding of restaurants in bracket
	//public List<Restaurant> restaurantList;
	//public ArrayAdapter<Restaurant> arrayAdapter;
	
	private static final String RESTAURANT_LIST_KEY = "Restaurant List Key";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//If saved instance state, go to it
		if(savedInstanceState != null){
			Log.i("IMPORTANT","savedInstanceState was not null");
			restaurantList = savedInstanceState.getStringArrayList(RESTAURANT_LIST_KEY);
		}
		else{
			Log.i("IMPORTANT","savedInstanceState was null");
			restaurantList = new ArrayList<String>();
			arrayListRestaurant = new ArrayList<Restaurant>();
		}
		//Get number of teams and randomization from previous Activity
		Bundle passedOn =  getIntent().getExtras();
		if (passedOn!= null){
			Log.i("IMPROATNAT ALSO","passedon is not null");
			numberOfRests = passedOn.getInt("Number of Restaurants");
			//randomize = passedon.getBoolean("randomize");
		}
		
		setContentView(R.layout.activity_addrestaurants);

		
		for(int i=0; i < numberOfRests; i++){
			String name = "Restaurant" + " " + String.valueOf(i + 1);
			arrayListRestaurant.add(new Restaurant(name)); 
			restaurantList.add(name);
			Log.i("IMPORTANT SHIT",name);
		}	
		
		//Setup the ListView with text from the ArrayList
		restList = (ListView) findViewById(R.id.lvRestaurants);
		arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,/*R.layout.activity_addrestaurants, R.id.tvNumberOfRests,*/restaurantList);
		restList.setAdapter(arrayAdapter);
		restList.setOnItemClickListener(mMessageClickedHandler);	
		
		
	}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState){
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putStringArrayList(RESTAURANT_LIST_KEY, restaurantList);
		
	}
	
	public void onClick(View v) {
		switch(v.getId()){ 
		
			case R.id.continueButtonAddRestaurant:
				startTournament();
			break;
		}
	}
	
	//This is old stuff. Wanted a dialog box to add restaurants. I just auto-generate them now.
	/*
	public void onPause(){
		super.onPause();
	    //ArrayList<String> saved = restaurantList; // fetch the data
	    //SharedPreferences prefs =PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    //SharedPreferences.Editor edit = prefs.edit();
	    //edit.putStringSet("SAVEDATA", new HashSet<String>(saved));
	    //edit.commit();
		Log.i("IMPORTANT","onPause()");
		
	}
	
	@Override
	public void onResume(){
		super.onResume();
	    //ArrayList<String> retrieved = new ArrayList<String> (PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getStringSet("SAVEDATA", new HashSet<String>()));
	    //restaurantList = retrieved;
	    
		//restList = (ListView) findViewById(R.id.listView1);
		//arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_addrestaurants, R.id.tvNumberOfRests,restaurantList);
		//restList.setAdapter(arrayAdapter);
		//arrayAdapter.notifyDataSetChanged();
		//restList.setOnItemClickListener(mMessageClickedHandler);
		
		Log.i("IMPORTANT","onResume()");
	}*/
	
	/*
	public void addRestaurantz(View v){
		DialogFragment newFrag = new AddRestaurantDialogFragment();
		newFrag.show(getFragmentManager(), "Add Restaurant");
	}
	
	//Add the plus icon in the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_restaurant_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    //Dialog Box to add restaurant
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	switch (item.getItemId()){
    		case R.id.action_add_restaurant:
    			new AddRestaurantDialogFragment().show(getFragmentManager(), "NoticeDialogFragment");
    			
    	}
    	return false;
    }
*/
	
    //Helper to change restaurant list
	private OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
	        changeRestaurant(position);
	    }
	};
    
    
	
	//Change restaurant name when tapping list
	public void changeRestaurant(final int i){

		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Change Restaurant");

		// Set an EditText view to get user input 
		final EditText input = new EditText(this);
		input.setText(restaurantList.get(i));
		alert.setView(input);

		alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				restaurantList.set(i, input.getText().toString());
				arrayAdapter.notifyDataSetChanged();
			  }
			});

			alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			  public void onClick(DialogInterface dialog, int whichButton) {
			    dialog.cancel();
			  }
			});
		
		alert.show();
		
		
	}
    
	@Override
	public void onReturnValue(String rest){
		//restaurantList.add(rest.getName());
		restaurantList.add(rest);
		arrayAdapter.notifyDataSetChanged();
	}
	
	private void startTournament() {
		// TODO Auto-generated method stub
		/* Pass restaurants onto the next activity and begin the tournament
		 */
		Bundle b = new Bundle();
		Intent intent = new Intent(this, Tournament.class);

		//b.putBoolean("randomize", randomize);
		intent.putParcelableArrayListExtra("Restaurants", arrayListRestaurant);
		intent.putParcelableArrayListExtra("Matches", new ArrayList<Match>());
		//intent.putExtras(b); 
		startActivity(intent);
	}


}

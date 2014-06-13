package com.waltertan12.bracket;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

public class AddRestaurantDialogFragment extends DialogFragment{
	
	public interface MyDialogListener{
		//public void onReturnValue(Restaurant rest);
		public void onReturnValue(String rest);
	}
	
	private Restaurant restaurant;
	
	public AddRestaurantDialogFragment(Restaurant restaurant){
		this.restaurant = restaurant;
	}
	
	public AddRestaurantDialogFragment() {
		// TODO Auto-generated constructor stub
	}
	
	public Dialog onCreateDialog(Bundle savedInstanceState){
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		
		builder.setTitle("Add Restaurant");
		
		final EditText input = new EditText(getActivity());
		//final EditText input = (EditText) findViewById(R.id.restaurant_name);
		
		builder.setView(input).setPositiveButton("OK", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//TextView tv = (TextView) view.findViewById(R.id.restaurant_name);

				String rName = input.getText().toString();
				//Restaurant restaurant = new Restaurant(rName,"");
				
				MyDialogListener activity = (MyDialogListener) getActivity();
				//activity.onReturnValue(restaurant);
				activity.onReturnValue(rName);
			}
		})
		.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				AddRestaurantDialogFragment.this.getDialog().cancel();
			}
		});
		return builder.create();
	}
	
}

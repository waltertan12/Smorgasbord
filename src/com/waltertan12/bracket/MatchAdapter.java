package com.waltertan12.bracket;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class MatchAdapter extends BaseAdapter{

	private ArrayList data; //ArrayList with info from current match
	Context c;
	
	public MatchAdapter(ArrayList data, Context c){
		this.data = data;
		this.c = c;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null){
			LayoutInflater vi = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.match_list,null);
		}
		
		TextView matchRestaurantOne = (TextView) convertView.findViewById(R.id.matchRestaurantOne);
		TextView matchRestaurantTwo = (TextView) convertView.findViewById(R.id.matchRestaurantTwo);
		
		Match match = (Match) data.get(position);
		
		matchRestaurantOne.setText(match.getRestaurantOne());
		matchRestaurantTwo.setText(match.getRestaurantTwo());
		
		return null;
	}

}

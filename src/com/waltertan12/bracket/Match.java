package com.waltertan12.bracket;

import android.os.Parcel;
import android.os.Parcelable;


public class Match implements Parcelable{
	
    public int id;
    public Restaurant winner;
    public Restaurant restaurant1;
    public Restaurant restaurant2;
    
    public Match(Parcel in){
		
	}
    
	public Match(Restaurant restaurant1, Restaurant restaurant2) {
		this.restaurant1 = restaurant1;
		this.restaurant2 = restaurant2;
	}
	
	public String getRestaurantOne(){
		return restaurant1.getName();
	}
	
	public String getRestaurantTwo(){
		return restaurant2.getName();
	}
	
	public void setWinner(Restaurant restaurant){
		this.winner = restaurant;
	}
	
    @Override
    public String toString()
    {
        return String.format("%s: %s vs %s", restaurantName(restaurant1), restaurantName(restaurant2)).trim();
    }

    private String restaurantName(Restaurant restaurant){
    	return restaurant.getName();
    }
    
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub

	}
	
	public static final Parcelable.Creator<Match> CREATOR = new Parcelable.Creator<Match>() {

		public Match createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new Match(source);
		}

		public Match[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Match[size];
		}
	
	
	};

}

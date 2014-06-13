package com.waltertan12.bracket;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurant implements Parcelable{

	private String name;
	private int seed;
	private String cuisine;
	private boolean eliminated = false;
	
	public Restaurant(Parcel in){
		String[] tmpS = new String[2];
		in.readStringArray(tmpS);
		this.name = tmpS[0];
		this.cuisine = tmpS[1];
		this.eliminated = in.readByte() == 1;
		this.seed = in.readInt();
	}
	
	public Restaurant(String name, String cuisine){
		this.name = name;
		this.cuisine = cuisine;
	}
	public Restaurant(String name){
		this.name = name;
	}
	
	public Restaurant() {
	}
	
	public boolean isEliminated(){
		return eliminated;
	}
	
	public String getName(){
		return name;
	}
	
	public int getSeed(){
		return seed;
	}
	
	public String getCuisine(){
		return cuisine;
	}
	
	public void setSeed(int seed){
		this.seed = seed;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		String[] tmpS = new String [2];
		tmpS[0] = name;
		tmpS[1] = cuisine;
		
		dest.writeStringArray(tmpS);
		dest.writeInt(seed);
		dest.writeByte((byte) (this.eliminated ? 1:0));
	}
	
	public static final Parcelable.Creator<Restaurant> CREATOR = new Parcelable.Creator<Restaurant>() {

		public Restaurant createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new Restaurant(source);
		}

		public Restaurant[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Restaurant[size];
		}
	
	
	};
	
	

}

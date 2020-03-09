package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.*;

public class MapOperations {

//	Map<String,TouristPlace> linkedHashMap=new LinkedHashMap<String,TouristPlace>();
//	Map<String,TouristPlace> treeMap=new TreeMap<String,TouristPlace>();
	Map<String,TouristPlace> hashMap;
	ArrayList<TouristPlace> l=new ArrayList<>();
	public List<TouristPlace> add(TouristPlace places){
		l.add(places);
		System.out.println(l);
		return l;
	
	}
	public Map<String,TouristPlace> sortRandomly(Map<String,TouristPlace> places){
		places=new HashMap<String,TouristPlace>();
		return places;
	}
	public Map<String,TouristPlace> sortInEntryOrder(Map<String,TouristPlace> places){
		places = new LinkedHashMap<String,TouristPlace>();
		return places;
	}
	public Map<String,TouristPlace> sortAlphabetically(Map<String,TouristPlace> places){
		places = new TreeMap<String,TouristPlace>();
		return places;
	}
	public Object reset(Map<String,TouristPlace> places) {
		places.clear();
		return places;
	}
	
	public Object remove(TouristPlace places) {
		hashMap.remove(places.getName());
		hashMap.remove(places.getRank());
		hashMap.remove(places.getDestination());
		return places;
		
		
	}
	
}
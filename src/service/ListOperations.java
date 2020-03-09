package service;
import model.*;
//import java.io.IOException;
import java.util.*;
public class ListOperations{
	ArrayList<TouristPlace> l=new ArrayList<>();
	public List<TouristPlace> add(TouristPlace places){
		
		l.add(places);
		System.out.println(l);
		return l;
	
		
	}
	public List<TouristPlace> remove(TouristPlace places){
		l.remove(places);
		return l;
	}
	public Object sortByDestination(List<TouristPlace> places) {
		Comparator<TouristPlace> place = new Comparator<TouristPlace>() {
			public int compare(TouristPlace o1, TouristPlace o2) {
				return o1.getDestination().compareTo(o2.getDestination());
			}
			
		};
	return place;
		
	}
	
	
//	public Object sortByRank(List<TouristPlace> places) {
//		Collections.sort(places.get(2), Comparator.naturalOrder());
//		return places;
//	
//	}
	
	public Object sortByRank(List<TouristPlace> places) {
		Comparator<TouristPlace> place = new Comparator<TouristPlace>() {
			public int compare(TouristPlace o1, TouristPlace o2) {
				return o1.getRank().compareTo(o2.getRank());
			}
			
		};
	return place;
	}
	
	public Object reset(List<TouristPlace> places) {
		places.clear();
		return places;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public Object sortByDestination(List<TouristPlace> places) {
//		
//		String place;
//		
//		place=l.get(1).getDestination();
//		return place;
//		
//	}
//	public Object sortByRank(List<TouristPlace> places) {
//		String place;
//		
//		place=l.get(2).getDestination();
//		return place;
//	}
}
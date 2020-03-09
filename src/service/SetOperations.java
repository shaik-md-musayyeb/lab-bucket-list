package service;
import model.*;
import java.util.HashSet;
//import java.util.Set;
import java.util.TreeSet;

public class SetOperations {
//	Set<TouristPlace> ss=new HashSet<TouristPlace>();
	HashSet<TouristPlace> ss;
	TreeSet<TouristPlace> ts;
	public HashSet<TouristPlace> add(TouristPlace places){
		ss=new HashSet<TouristPlace>();
		ss.add(places);
		return ss;
		
	}
	public HashSet<TouristPlace> remove(TouristPlace places){
		ss.remove(places);
		return ss;
	}
	public Object sortByDestination(HashSet<TouristPlace> places) {
		ts=new TreeSet<TouristPlace>((p1, p2) -> {
			return p1.getDestination().compareTo(p2.getDestination());
		});
			
		return ts;
	}
	public Object sortByRank(HashSet<TouristPlace> places) {
		ts=new TreeSet<TouristPlace>((p1,p2)-> p1.getRank().compareTo(p2.getRank()));
		return ts;
	}
	public Object reset(HashSet<TouristPlace> places) {
		ss.clear();
		return ss;
	}
}
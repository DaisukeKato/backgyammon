package domain;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

//import service.TipPositionLatticeOverFlow;

public class TipPositionLattice {
	
	public Map<Short, List<Short>> map;
	
	public TipPositionLattice(){
		this.map = new TreeMap<Short, List<Short>>();
	}
	
	public void push(short position, short color) throws TipPositionLatticeOverFlow, IllegalArgumentException{
		if(position < 1||position > 24){
			throw new IllegalArgumentException("TipPositionLattice.pushの第１引数は1から24までの整数でなければなりません");
		}
		if(color != 1 && color != 2){
			throw new IllegalArgumentException("TipPositionLattice.pushの第２引数は1または2でなければなりません");
		}
		
		if(!this.map.isEmpty()){
			if(this.map.containsKey(position)){
				if(this.map.get(position).size() > 5){
					throw new TipPositionLatticeOverFlow();
				}
			}
		}
		
		if(this.map.isEmpty()||!this.map.containsKey(position)){
			List<Short> eachTurfObject = new LinkedList<Short>();
			eachTurfObject.add(color);
			this.map.put(position, eachTurfObject);
		}else{
			List<Short> eachTurfObject = this.map.get(position);
			eachTurfObject.add(color);
			this.map.put(position, eachTurfObject);
		}
	}
	
	void pop(short position, short color) throws TipNotExist{
		if(color != 1 && color != 2){
			throw new IllegalArgumentException("TipPositionLattice.pushの第２引数は1または2でなければなりません");
		}
		
		List<Short> mapList = this.map.get(position);
		
		if(!mapList.contains(color)){
			throw new TipNotExist();
		}
		
		for(ListIterator<Short> i = mapList.listIterator(mapList.size()); i.hasPrevious();){
			if(i.previous() == color){
				i.remove();
				break;
			}
		}
	}
	
	

}

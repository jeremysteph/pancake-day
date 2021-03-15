package cs520.hw6.part1;

import java.util.ArrayList;

public class SharedResults {

	private ArrayList<Integer>results;
	
	public SharedResults(){
		results = new ArrayList<Integer>();
	}

	public synchronized void addToResults(int x){
		results.add(x);
		
		
		System.out.println(Thread.currentThread().getName() + " is adding " + x + 
				", \n Cumulative Results are " + results);
	}
	public synchronized int getResults(){
		int sum=0;
		for (int i=0;i<results.size();i++){
			sum += results.get(i); 
		}
		return sum;
	}
}

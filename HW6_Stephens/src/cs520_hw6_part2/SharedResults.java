package cs520_hw6_part2;

import java.util.ArrayList;

public class SharedResults {

	private ArrayList<Integer>results;
	
	public SharedResults(){
		results = new ArrayList<Integer>();
	}

	public synchronized void addToResults(int x, int turn){
		results.add(x);
		
		try {
			if (turn ==0){
				System.out.println("Calling Thread's Turn " +turn);
			
			System.out.println("WhoseTurn 0 ... Wait");
			wait();
		}
			if (turn ==1){
				System.out.println("Calling Thread's Turn " +turn);
			
			System.out.println("WhoseTurn 0 ... Wait");
			wait();

			}	
			}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " is adding " + x +				", \n Cumulative Results are " + results);
	}
	public synchronized int getResults(){
	int sum=0;
		for (int i=0;i<results.size();i++){
		sum += results.get(i); 
	}
		return sum;
	}
}

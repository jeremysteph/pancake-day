package cs520_hw6_part2;

public class LongTask extends Thread{
	private SharedResults sharedData;
	private int start;
	private int end;
	private int turn;
	public LongTask(SharedResults sharedData, int start, int end, int turn){
		super("Thread_"+start+"_"+end);
		
		this.sharedData = sharedData;
		this.start = start;
		this.end = end;
		this.turn = turn;
			
	}

	public void run(){
		int result =0;
		for(int i=start; i<=end; i++){
			 result +=i;
			 try{
				 Thread.sleep((long) (Math.random()*10000));
			 }catch(InterruptedException e){
		e.printStackTrace();
		}
		
	}
	sharedData.addToResults(result, turn);
}
	}
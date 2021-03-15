package cs520.hw6.part1;

public class LongTask extends Thread{
	private SharedResults sharedData;
	private int start;
	private int end;
	
	public LongTask(SharedResults sharedData, int start, int end){
		super("Thread_"+start+"_"+end);
		
		this.sharedData = sharedData;
		this.start = start;
		this.end = end;
			
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
	sharedData.addToResults(result);
}
	}
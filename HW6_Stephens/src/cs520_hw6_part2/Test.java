package cs520_hw6_part2;

public class Test {
public static void main(String[] args){
SharedResults sharedData = new SharedResults();
LongTask[] thread =new LongTask[5];
int[] start ={1,101,201,301,401};

int[] end ={100,200,300,400,500};
int turn =0;

for(int i =0; i<thread.length;i++){
	turn = (int) (Math.random()*4+0);
	thread[i] = new LongTask(sharedData,start[i],end[i],turn);
	thread[i].start();
}

for(int j=0; j<thread.length;j++){
	try{
		thread[j].join();
	}catch(InterruptedException e){
		System.out.println(e.getMessage());
	}
}
System.out.println("Final result: " +sharedData.getResults());
}

}


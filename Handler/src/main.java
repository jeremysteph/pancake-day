import com.leapmotion.*;
import com.leapmotion.leap.*;
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  // Create a sample listener and assign it to a controller to receive events
	    AppListener listener = new AppListener();
	    Controller controller = new Controller(listener);

	    // Keep this process running until Enter is pressed
	    System.out.println("Press Enter to quit...");
	    try {
	System.in.read();
	} catch (IOException e) {

	}

	    //The controller must be disposed of before the listener
	    controller = null;
	  }
	}

}

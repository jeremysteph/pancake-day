import com.leapmotion.*;
import com.leapmotion.leap.*;

public class AppListener extends Listener {

	 public void onInit(Controller controller) {
		    System.out.println("Initialized");
		  }

		  public void onConnect(Controller controller) {
		    System.out.println("Connected");
		  }

		  public void onDisconnect(Controller controller) {
		    System.out.println("Disconnected");
		  }

		  public void onFrame(Controller controller) {
		    // Get the most recent frame and report some basic information
		    Frame frame = controller.frame();
		    HandArray hands = frame.hands();
		    long numHands = hands.size();
		    System.out.println("Frame id: " + frame.id()
		                     + ", timestamp: " + frame.timestamp()
		                     + ", hands: " + numHands);

		    if (numHands >= 1) {
		      // Get the first hand
		      Hand hand = hands.get(0);

		      // Check if the hand has any fingers
		      FingerArray fingers = hand.fingers();
		      long numFingers = fingers.size();
		      if (numFingers >= 1) {
		        // Calculate the hand's average finger tip position
		        Vector pos = new Vector(0, 0, 0);
		        for (int i = 0; i < numFingers; ++i) {
		          Finger finger = fingers.get(i);
		          Ray tip = finger.tip();
		          pos.setX(pos.getX() + tip.getPosition().getX());
		          pos.setY(pos.getY() + tip.getPosition().getY());
		          pos.setZ(pos.getZ() + tip.getPosition().getZ());
		        }
		        pos = new Vector(pos.getX()/numFingers, pos.getY()/numFingers, pos.getZ()/numFingers);
		        System.out.println("Hand has " + numFingers + " fingers with average tip position"
		                         + " (" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")");
		      }

		      // Check if the hand has a palm
		      Ray palmRay = hand.palm();
		      if (palmRay != null) {
		        // Get the palm position and wrist direction
		        Vector palm = palmRay.getPosition();
		        Vector wrist = palmRay.getDirection();
		        String direction = "";
		        if (wrist.getX() > 0)
		          direction = "left";
		        else
		          direction = "right";
		        System.out.println("Hand is pointing to the " + direction + " with palm position"
		                         + " (" + palm.getX() + ", " + palm.getY() + ", " + palm.getZ() + ")");
		      }
		    }
		  }
		}


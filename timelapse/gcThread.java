package timelapse;

import java.util.TimerTask;



public class gcThread extends Thread {
	static TimerTask task;
public static TimerTask timer() {
	 
		
 return task = new TimerTask() {

	
		public  void run() {
	
				
			
			
			

				
					System.gc();
					
		}
	};



}
}



	    
	

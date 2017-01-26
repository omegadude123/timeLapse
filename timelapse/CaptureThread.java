package timelapse;

import java.util.TimerTask;

import com.github.sarxos.webcam.Webcam;

public class CaptureThread extends Thread {
	static TimerTask task;
public static TimerTask timer(Webcam webcam) {
	 
		
 return task = new TimerTask() {
	 public  void run() {
	
				
			
			
			

				while(Main.shouldRun) {
					
						
					
					try {
						sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//startTime = System.nanoTime();
					System.arraycopy(Main.k, 0, Main.k, 1, Main.k.length-1);
					Main.k[0] =webcam.getImage();
				//	System.gc();
					System.out.println("TOOK A PIC " + webcam.getFPS());
				
				
				}
					

					//endTime = System.nanoTime();
					// gui.fps(1000/((endTime-startTime)/1000000));

				
				}
				
				//webcam.close();
		};
	}



}



	    
	

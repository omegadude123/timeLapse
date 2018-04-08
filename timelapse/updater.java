package timelapse;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class updater extends Thread {
	private int i = Main.k.length - 1;

	private volatile static long startTime;
	private volatile static long endTime;
	
	public updater() throws InterruptedException{
		this.run();
	}

	public void run() {
		gui.main();
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		
		while (Main.shouldRun) {

			if (Main.k[i] != null) {
				gui.updateImage(Main.k[i]);
				gui.fps((long) i);
			} else {
				i = Main.k.length - 1;
			}

			i--;
			if (i < 0) {
				i = Main.k.length - 1;
			}
		} 
		this.stop();
	}

	

	public static Mat bufferedImageToMat(BufferedImage bi) {
		Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
		byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
		mat.put(0, 0, data);
		return mat;
	}
}

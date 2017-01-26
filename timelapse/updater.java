package timelapse;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.crypto.Mac;
import javax.imageio.ImageIO;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class updater extends Thread {
	private int i = Main.k.length-1;
	Webcam j;

	private volatile static long startTime;
	private volatile static long endTime;

	public updater(Webcam k) {
		this.j = k;
	}

	public void run() {
		gui.main();
		try {
			this.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (Main.shouldRun) {
			try {
				sleep(2);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			if (Main.k[i] != null) {
				gui.updateImage(Main.k[i]);
				gui.fps((long) i);
			}
			else{i=Main.k.length-1;};

			i--;
			if (i <0) {
				i = Main.k.length-1;
			}
		}
	}

	public static Mat bufferedImageToMat(BufferedImage bi) {
		Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
		byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
		mat.put(0, 0, data);
		return mat;
	}
}

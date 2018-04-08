package timelapse;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;

public class Main {
	public static BufferedImage[] k = new BufferedImage[200];
	public static boolean shouldRun = true;

	public static void main(String[] args) throws IOException, InterruptedException {

		
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			VideoCapture webcam = new VideoCapture(0);
			// System.out.println(Webcam.getDriver());

			webcam.open(0);
			Timer timer = new Timer();
			TimerTask capt = CaptureThread.timer(webcam);
			timer.schedule(capt, 255);// 45000
			Thread emriver = new updater();
			emriver.start();

		

		// System.arraycopy(Emriver.images, 0, k, 1, Emriver.images.length-1);
		System.out.println("potato");
		// TimerTask gc = gcThread.timer();
		// timer.schedule(gc, 20000, 15000);// 45000

	}
}

// System.arraycopy(Emriver.images, 0, k, 1, Emriver.images.length-1);

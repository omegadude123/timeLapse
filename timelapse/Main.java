package timelapse;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class Main {
	public static BufferedImage[] k = new BufferedImage[200];
	static boolean shouldRun = true;

	public static void main(String[] args) throws IOException, InterruptedException {
		Webcam webcam = Webcam.getDefault();

		final Dimension[] nonStandardResolutions = new Dimension[] { WebcamResolution.HD720.getSize(),
				WebcamResolution.VGA.getSize(), new Dimension(2000, 1000), new Dimension(1, 1), };
		webcam.setCustomViewSizes(nonStandardResolutions);
		webcam.setViewSize( new Dimension(640, 480));
		// System.out.println(Webcam.getDriver());

		webcam.open();
		Timer timer = new Timer();
		TimerTask capt = CaptureThread.timer(webcam);
		timer.schedule(capt, 0);// 45000
		Thread emriver = (new updater(webcam));

		emriver.start();
		
		// System.arraycopy(Emriver.images, 0, k, 1, Emriver.images.length-1);
		System.out.println("potato");
		TimerTask gc = gcThread.timer();
		timer.schedule(gc, 20000, 15000);// 45000

	

		
		

	}
}

// System.arraycopy(Emriver.images, 0, k, 1, Emriver.images.length-1);

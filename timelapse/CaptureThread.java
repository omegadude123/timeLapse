package timelapse;

import java.util.TimerTask;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class CaptureThread extends Thread {
	static TimerTask task;

	public static TimerTask timer(final VideoCapture webcam) throws InterruptedException{

		return task = new TimerTask() {
			public void run() {

				while (Main.shouldRun) {
					Mat image = new Mat(640, 640, CvType.CV_8UC3);
					webcam.retrieve(image);
					Main.k[0] = imageProccessing.proccess(image);

					// startTime = System.nanoTime();
					System.arraycopy(Main.k, 0, Main.k, 1, Main.k.length - 1);

					// System.gc();
					System.out.println("TOOK A PIC ");

				}
this.cancel();
				// endTime = System.nanoTime();
				// gui.fps(1000/((endTime-startTime)/1000000));

			}

			// webcam.close();
		};
	}

}

package timelapse;

import java.awt.image.BufferedImage;
import org.opencv.core.Mat;

public class imageProccessing {
	static BufferedImage out;

	public static BufferedImage proccess(Mat mat) {

		MatToBufferedImage(mat);
		return out;
	}

	private static boolean MatToBufferedImage(Mat matrix) {

		int cols = matrix.cols();
		int rows = matrix.rows();
		int elemSize = (int) matrix.elemSize();
		byte[] data = new byte[cols * rows * elemSize];
		matrix.get(0, 0, data);
		out = new BufferedImage(cols, rows, BufferedImage.TYPE_3BYTE_BGR);
		out.getRaster().setDataElements(0, 0, cols, rows, data);

		return true; // Successful
	}

}

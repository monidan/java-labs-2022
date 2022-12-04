package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;

public class ShopComponent extends JComponent {

	private final String imageURL = "icon.png";
	private final URL image = getClass().getResource(imageURL);


	public ShopComponent() throws IOException {

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D) g.create();
		BufferedImage bfImage = null;
		Image scaledImage = null;
		try {
			bfImage = ImageIO.read(image);
			scaledImage = bfImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		graphics.drawImage(scaledImage, 0, 0, this);
		graphics.dispose();
	}
}

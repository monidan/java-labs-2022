package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.Objects;

public class ShopComponent extends JComponent {

	private final String imageURL = "icon.png";
	private final String newImageURL = "icon-2.png";
	private final URL image = getClass().getResource(imageURL);

	JPopupMenu contextMenu = new JPopupMenu();
	Image scaledImage = null;

	public ShopComponent() throws IOException {
		JMenuItem edit = new JMenuItem("Змінити");
		JMenuItem delete = new JMenuItem("Видалити");
		JMenuItem addBoarder = new JMenuItem("Додати рамку");

		delete.addActionListener(e -> deleteImage());
		addBoarder.addActionListener(e -> addBorder());
		edit.addActionListener(e -> changeImage());

		contextMenu.add(edit);
		contextMenu.add(delete);
		contextMenu.add(addBoarder);

		MouseListener PopupListener = new PopupListener();
		this.addMouseListener(PopupListener);
	}

	protected void deleteImage() {
		this.setVisible(false);
	}

	protected void addBorder() {
		Graphics2D graphics = (Graphics2D) this.getGraphics();
		graphics.drawLine(0, 0, 0, scaledImage.getHeight(this));
		graphics.drawLine(0, 0, scaledImage.getWidth(this), 0);
		graphics.drawLine(scaledImage.getWidth(this), 0, scaledImage.getWidth(this), scaledImage.getHeight(this));
		graphics.drawLine(0, scaledImage.getHeight(this), scaledImage.getWidth(this), scaledImage.getHeight(this));
	}

	protected void changeImage() {
		Graphics2D graphics = (Graphics2D) this.getGraphics();
		BufferedImage bfImage = null;
		Image newImage = null;

		try {
			bfImage = ImageIO.read(Objects.requireNonNull(getClass().getResource(newImageURL)));
			newImage = bfImage.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}

		graphics.drawImage(newImage, 0, 0, this.getWidth() ,this.getHeight(), this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D) g.create();
		BufferedImage bfImage = null;

		try {
			bfImage = ImageIO.read(image);
			scaledImage = bfImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		graphics.drawImage(scaledImage, 0, 0, this);
		graphics.dispose();
	}

	class PopupListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.isPopupTrigger()) {
				System.out.println("mouse was pressed");
				contextMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.isPopupTrigger()) {
				contextMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.isPopupTrigger()) {
				contextMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}
}
import views.FirstFormView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		JFrame frame = new FirstFormView("Lab 6");
		frame.setPreferredSize(new Dimension(500,500));
		frame.pack();
		frame.setVisible(true);
	}
}
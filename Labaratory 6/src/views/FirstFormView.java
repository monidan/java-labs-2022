package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class FirstFormView extends JFrame {

	private final ShopComponent shop;
	private final JTextField name;
	private final JTextField price;
	private final JTextField amount;

	public FirstFormView(String title) throws IOException {
		super(title);

		createMenu();

		JPanel root = new JPanel();
		BoxLayout rootLayout = new BoxLayout(root, BoxLayout.Y_AXIS);
		root.setLayout(rootLayout);
		shop = new ShopComponent();
		shop.setPreferredSize(new Dimension(200, 200));
		root.add(shop);

		JPanel newItemFieldPanel = new JPanel(new FlowLayout());
		JPanel nameFieldPanel = new JPanel();
		JPanel priceFieldPanel = new JPanel();
		JPanel amountFieldPanel = new JPanel();

		nameFieldPanel.setLayout(new BoxLayout(nameFieldPanel, BoxLayout.Y_AXIS));
		priceFieldPanel.setLayout(new BoxLayout(priceFieldPanel, BoxLayout.Y_AXIS));
		amountFieldPanel.setLayout(new BoxLayout(amountFieldPanel, BoxLayout.Y_AXIS));

		final JLabel itemName = new JLabel("Name");
		final JLabel itemPrice = new JLabel("Price");
		final JLabel itemAmount = new JLabel("Amount");

		itemName.setFont(new Font("Cambria Math", Font.ITALIC, 16));
		itemPrice.setFont(new Font("Cambria Math", Font.ITALIC, 16));
		itemAmount.setFont(new Font("Cambria Math", Font.ITALIC, 16));

		nameFieldPanel.add(itemName);
		priceFieldPanel.add(itemPrice);
		amountFieldPanel.add(itemAmount);

		name = new JTextField();
		name.setColumns(6);

		price = new JTextField();
		price.setColumns(4);

		amount = new JTextField();
		amount.setColumns(5);

		nameFieldPanel.add(name);
		priceFieldPanel.add(price);
		amountFieldPanel.add(amount);

		newItemFieldPanel.add(nameFieldPanel);
		newItemFieldPanel.add(priceFieldPanel);
		newItemFieldPanel.add(amountFieldPanel);

		root.add(newItemFieldPanel);

		JButton nextButton = new JButton("Count up");
		nextButton.addActionListener(e -> openSecondFrame());
		root.add(nextButton);

		add(root);
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu appMenu = new JMenu("Програма");

		JMenuItem verification = new JMenuItem("Перевірка");
		verification.addActionListener(e -> verify());

		JMenuItem calculate = new JMenuItem("Обчислити");
		calculate.addActionListener(e -> openSecondFrame());

		JMenuItem exit = new JMenuItem("Вийти");
		exit.addActionListener(e -> System.exit(0));

		JMenu editMenu = new JMenu("Правка");
		editMenu.add(new JMenuItem("Копіювати"));
		editMenu.add(new JMenuItem("Вставити"));

		appMenu.add(verification);
		appMenu.add(calculate);
		appMenu.addSeparator();
		appMenu.add(exit);

		menuBar.add(appMenu);
		menuBar.add(editMenu);
		setJMenuBar(menuBar);
	}

	protected void verify() {
		try {
			if (Float.parseFloat(price.getText()) >= 0
					&& Integer.parseInt(amount.getText()) >= 0) {
				JOptionPane.showMessageDialog(this,
						"You are a cool person :)",
						"Correct!",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(this,
				"The wrong format for one of the inputs.",
				"ERROR!",
				JOptionPane.PLAIN_MESSAGE);
	}

	private void openSecondFrame() {
		try {
			String itemName = name.getText();
			float itemPrice = Float.parseFloat(price.getText());
			int itemAmount = Integer.parseInt(amount.getText());

			SecondFormView secondFormView = new SecondFormView("Second form", itemName, itemPrice, itemAmount);
			secondFormView.pack();
			secondFormView.setVisible(true);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this,
			                              "The wrong format for one of the inputs.",
			                              "ERROR!",
			                              JOptionPane.ERROR_MESSAGE);
		}
	}
}

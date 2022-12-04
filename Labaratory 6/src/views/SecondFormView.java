package views;

import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;

public class SecondFormView extends JFrame {
	private final String name;
	private final float price;
	private final int amount;

	public SecondFormView(String title, String name, float price, int amount) {
		super(title);

		this.name = name;
		this.price = price;
		this.amount = amount;

		double totalSum = (double) this.countCartSum();

		JPanel root = new JPanel(new BorderLayout());
		root.setPreferredSize(new Dimension(400, 400));
		JPanel cartSumPlan = new JPanel();
		BoxLayout boxLayout = new BoxLayout(cartSumPlan, BoxLayout.Y_AXIS);
		cartSumPlan.setLayout(boxLayout);

		Font mathFont = new Font("Cambria Math", Font.ITALIC, 16);
		JLabel totalCartSum = new JLabel(name + " item's total sum in cart is " + totalSum);
		totalCartSum.setFont(mathFont);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e -> System.exit(0));

		cartSumPlan.add(totalCartSum);
		cartSumPlan.add(exitButton);

		root.add(cartSumPlan, BorderLayout.CENTER);

		add(root);
	}

	private float countCartSum() {
		return this.amount * this.price;
	}
}

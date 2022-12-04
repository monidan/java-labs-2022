import javax.swing.*;
import java.awt.*;

public class FieldMustHave extends JFrame  {
    Color BackgroundColor = new Color(0xC4BD97);
    Font font28 = new Font("Times new roman", Font.BOLD, 20);

    private final JLabel NoConnection = new JLabel("Заповніть поля");

    public FieldMustHave(){
        setBackground(BackgroundColor);
        setTitle("Login_form");
        setSize(700,600);
        setLocation(new Point(300,200));
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground( BackgroundColor );

        initComponent();
    }
    private void initComponent(){
        NoConnection.setFont(font28);
        NoConnection.setBounds(80,100,600,200);
        add(NoConnection);
    }
}


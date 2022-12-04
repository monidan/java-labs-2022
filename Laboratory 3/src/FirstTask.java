import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FirstTask extends JFrame {
    Font font = new Font("Verdana", Font.ITALIC, 16);
    Color purple = new Color(0x9400FF);
    Color Blue = new Color(0x00C4FF);

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D f = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(300,240,purple,350,290,Blue);

        f.setColor(Color.GREEN);
        f.fillPolygon(new int[] {100, 140, 180}, new int[] {300, 200, 300}, 3);

        f.setPaint(gp);
        f.fillRect(300,240,50,50);

        f.setColor(Color.RED);
        f.fillArc(500,240,50,50,0,360);
    }

    private final JLabel lbl_GreenTriangle = new JLabel("Зелений трикутник");
    private final JLabel lbl_gradient_square = new JLabel("Градіент квадрат");
    private final JLabel lbl_Red_circle = new JLabel("Червоне коло");
    private final JLabel Author_name = new JLabel("Горохов Данило Валерійович. ПП-41");

    public FirstTask(){
        setTitle("Фігурки");
        setSize(700,500);
        setVisible(true);
        setLayout(null);
        setResizable(false);

        initComponent();
        initEvent();
    }

    private void initComponent(){
        lbl_GreenTriangle.setFont(font);
        lbl_GreenTriangle.setForeground(Color.GREEN);
        lbl_GreenTriangle.setBounds(60,250,180,100);

        lbl_gradient_square.setFont(font);
        lbl_gradient_square.setForeground(Color.GREEN);
        lbl_gradient_square.setBounds(250,250,180,100);

        lbl_Red_circle.setFont(font);
        lbl_Red_circle.setForeground(Color.GREEN);
        lbl_Red_circle.setBounds(450,250,180,100);

        Author_name.setBounds(300,400,300,20);

        add(lbl_GreenTriangle);
        add(lbl_gradient_square);
        add(lbl_Red_circle);
        add(Author_name);
    }

    private void initEvent() {

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
}
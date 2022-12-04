import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class SecondTask extends JFrame {
    Font font = new Font("Verdana", Font.ITALIC, 18);
    Random rand = new Random();


    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D f = (Graphics2D) g;

        f.drawLine(100, 700, 100, 100);
        f.drawLine(100, 700, 780, 700);

        f.drawLine(100,110 , 120, 110);
        f.drawLine(100,180 , 120, 180);

        f.drawLine(100,240 , 120, 240);
        f.drawLine(100,310 , 120, 310);
        f.drawLine(100,380 , 120, 380);
        f.drawLine(100,450 , 120, 450);
        f.drawLine(100,520 , 120, 520);
        f.drawLine(100,590 , 120, 590);

        f.setColor(randomColor());
        f.fillRect(160,590,40,110);

        f.setColor(randomColor());
        f.fillRect(230,520,40,180);

        f.setColor(randomColor());
        f.fillRect(290,450,40,250);

        f.setColor(randomColor());
        f.fillRect(350,380,40,320);

        f.setColor(randomColor());
        f.fillRect(440,310,40,390);

        f.setColor(randomColor());
        f.fillRect(500,240,40,460);

        f.setColor(randomColor());
        f.fillRect(570,170,40,530);

        f.setColor(randomColor());
        f.fillRect(660,100,40,600);

        f.setColor(randomColor());
        f.fillRect(730,100,40,600);
    }

    private final JLabel lbl_24 = new JLabel("24");
    private final JLabel lbl_20 = new JLabel("20");
    private final JLabel lbl_18 = new JLabel("18");
    private final JLabel lbl_15 = new JLabel("15");
    private final JLabel lbl_12 = new JLabel("12");
    private final JLabel lbl_10 = new JLabel("10");
    private final JLabel lbl_8 = new JLabel("8");
    private final JLabel lbl_5 = new JLabel("5");
    private final JLabel lbl_2 = new JLabel("2");
    private final JLabel lbl_0 = new JLabel("0");


    private final JLabel lbl_name = new JLabel("Статистика мов програмування у групі ПП-41");

    private final JLabel lbl_java = new JLabel("Java");
    private final JLabel lbl_kotlin = new JLabel("Kotlin");
    private final JLabel lbl_Go = new JLabel("Go");
    private final JLabel lbl_Python = new JLabel("Python");
    private final JLabel lbl_Chp = new JLabel("C#");
    private final JLabel lbl_js = new JLabel("Js");
    private final JLabel lbl_ruby = new JLabel("Ruby");
    private final JLabel lbl_php = new JLabel("Php");
    private final JLabel lbl_Cpp = new JLabel("C++");

    public SecondTask(){
        setTitle("Статистика мов програмування у групі ПП-41");
        setSize(800,800);
        setLocation(new Point(300,200));
        setVisible(true);
        setLayout(null);
        setResizable(false);

        initComponent();
        initEvent();
    }

    private void initComponent(){

        lbl_name.setForeground(Color.BLUE);
        lbl_name.setFont(font);
        lbl_name.setVerticalAlignment(SwingConstants.CENTER);
        lbl_name.setBounds(200,20,600,30);


        lbl_java.setForeground(Color.BLUE);
        lbl_java.setFont(font);
        lbl_java.setBounds(710,670,100,20);

        lbl_kotlin.setForeground(Color.BLUE);
        lbl_kotlin.setFont(font);
        lbl_kotlin.setBounds(640,670,100,20);

        lbl_Go.setForeground(Color.BLUE);
        lbl_Go.setFont(font);
        lbl_Go.setBounds(570,670,100,20);

        lbl_Python.setForeground(Color.BLUE);
        lbl_Python.setFont(font);
        lbl_Python.setBounds(480,670,100,20);

        lbl_Cpp.setForeground(Color.BLUE);
        lbl_Cpp.setFont(font);
        lbl_Cpp.setBounds(340,670,100,20);

        lbl_Chp.setForeground(Color.BLUE);
        lbl_Chp.setFont(font);
        lbl_Chp.setBounds(430,670,100,20);

        lbl_js.setForeground(Color.BLUE);
        lbl_js.setFont(font);
        lbl_js.setBounds(290,670,100,20);

        lbl_ruby.setForeground(Color.BLUE);
        lbl_ruby.setFont(font);
        lbl_ruby.setBounds(220,670,100,20);

        lbl_php.setForeground(Color.BLUE);
        lbl_php.setFont(font);
        lbl_php.setBounds(150,670,100,20);

        lbl_24.setBounds(40,70,60,10);
        lbl_20.setBounds(40,140,60,10);
        lbl_18.setBounds(40,200,60,10);
        lbl_15.setBounds(40,270,60,10);
        lbl_10.setBounds(40,340,60,10);
        lbl_8.setBounds(40,410,60,10);
        lbl_5.setBounds(40,480,60,10);
        lbl_2.setBounds(40,550,60,10);
        lbl_0.setBounds(40,650,60,10);

        add(lbl_name);

        add(lbl_java);
        add(lbl_kotlin);
        add(lbl_Go);
        add(lbl_Python);
        add(lbl_Cpp);
        add(lbl_Chp);
        add(lbl_js);
        add(lbl_ruby);
        add(lbl_php);

        add(lbl_24);
        add(lbl_20);
        add(lbl_18);
        add(lbl_15);
        add(lbl_12);
        add(lbl_10);
        add(lbl_8);
        add(lbl_5);
        add(lbl_2);
        add(lbl_0);
    }

    private void initEvent() {

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
    private Color randomColor(){
        return new Color(rand.nextInt(0xFFFFFF));
    }
}
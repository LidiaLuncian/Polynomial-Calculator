package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JLabel l1=new JLabel("Polinom1: ");
    private JLabel l2=new JLabel("Polinom2: ");
    private JLabel l3=new JLabel("Rezultat: ");

    private JTextField tf1=new JTextField(30);
    private JTextField tf2=new JTextField(30);
    private JTextField tf3=new JTextField(30);

    private JButton b1=new JButton("Adunare");
    private JButton b2=new JButton("Scadere");
    private JButton b3=new JButton("Inmultire");
    private JButton b4=new JButton("Impartire");
    private JButton b5=new JButton("Integrare");
    private JButton b6=new JButton("Derivare");

    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();

    private Operatii operatii;

    public View(Operatii op)
    {
        setTitle("Calculator Polinoame");
        setSize(400,500);
        setResizable(false);

        operatii = op;
        tf1.setText(operatii.getPol1());
        tf2.setText(operatii.getPol2());

        getContentPane().setLayout(new GridLayout(4,1));
        getContentPane().add(panel1);
        panel1.setSize(100, 50 );
        panel1.setLayout(new FlowLayout());
        panel1.add(l1);
        panel1.add(tf1);
        panel1.setBackground(Color.PINK);

        getContentPane().add(panel2);
        panel2.setSize(100, 50 );
        panel2.setLayout(new FlowLayout());
        panel2.add(l2);
        panel2.add(tf2);
        panel2.setBackground(Color.LIGHT_GRAY);

        getContentPane().add(panel3);
        panel3.setSize(100, 50 );
        panel3.setLayout(new FlowLayout());
        panel3.add(l3);
        panel3.add(tf3);
        panel3.setBackground(Color.GRAY);

        getContentPane().add(panel4);
        panel4.setSize(100, 50 );
        panel4.setLayout(new FlowLayout());
        panel4.add(b1);
        panel4.add(b2);
        panel4.add(b3);
        panel4.add(b4);
        panel4.add(b5);
        panel4.add(b6);
        panel4.setBackground(Color.DARK_GRAY);

    }

    void adunareListener(ActionListener ad) {
        b1.addActionListener(ad);
    }

    void scadereListener(ActionListener sc) {
        b2.addActionListener(sc);
    }

    void inmultireListener(ActionListener inm){
        b3.addActionListener(inm);
    }

    void impartireListener(ActionListener imp){
        b4.addActionListener(imp);
    }

    void integrareListener(ActionListener integ){
        b5.addActionListener(integ);
    }

    void derivareListener(ActionListener der){
        b6.addActionListener(der);
    }

    String getPol1Input() {
        return tf1.getText();
    }

    String getPol2Input(){
        return tf2.getText();
    }

    void setRezultat(String rez){
        tf3.setText(rez);
    }

}

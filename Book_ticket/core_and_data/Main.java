package core_and_data;
import javax.swing.*;
import java.awt.Color;
public class Main {

    public static void main(String[] args) {
        JFrame frame=new JFrame("Login");
        JPanel panel=new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        ImageIcon image=new ImageIcon("Book_ticket/core_and_data/c18e93c27e4840108b4eeba6750508f7.jpg");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(59, 100, 117));
    }
}
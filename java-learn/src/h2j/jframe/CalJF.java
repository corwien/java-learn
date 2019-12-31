package h2j.jframe;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalJF {
	public static void main(String[] args) {
		  
        JFrame f = new JFrame("计算器");
        int gap = 8;
        f.setSize(322, 272);
        f.setLocation(200, 200);
         
        f.setLayout(null);
  
        JPanel middlePanel = new JPanel();
        middlePanel.setBounds(gap, gap, 300, 225);
        f.add(middlePanel);
        middlePanel.setLayout(new GridLayout(4, 5,gap,gap));
         
        middlePanel.add(new JButton("7"));
        middlePanel.add(new JButton("8"));
        middlePanel.add(new JButton("9"));
        middlePanel.add(new JButton("/"));
        middlePanel.add(new JButton("sq"));
        middlePanel.add(new JButton("4"));
        middlePanel.add(new JButton("5"));
        middlePanel.add(new JButton("6"));
        middlePanel.add(new JButton("*"));
        middlePanel.add(new JButton("%"));
        middlePanel.add(new JButton("1"));
        middlePanel.add(new JButton("2"));
        middlePanel.add(new JButton("3"));
        middlePanel.add(new JButton("-"));
        middlePanel.add(new JButton("1/x"));
        middlePanel.add(new JButton("0"));
        middlePanel.add(new JButton("+/-"));
        middlePanel.add(new JButton("."));
        middlePanel.add(new JButton("+"));
        middlePanel.add(new JButton("="));
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        f.setVisible(true);
    }

}

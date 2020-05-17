// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import Panels_Designs.backgroud;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class SelectLevel extends JFrame implements ActionListener
{
    private JButton j2;
    private JButton j3;
    private JButton[] arrayOfButtons;
    private ListOfRecords records;
    
    public SelectLevel() throws FileNotFoundException {
        super("Select Level");
        (this.records = new ListOfRecords()).loadFromFile("records.txt");
        this.setDefaultCloseOperation(3);
        this.getContentPane().setLayout(new BorderLayout());
        this.setSize(440, 500);
        this.setVisible(true);
        final backgroud p = new backgroud();
        this.add(p);
        this.validate();
        p.setLayout(null);
        this.getContentPane().add(p, "Center");
        this.arrayOfButtons = new JButton[4];
        int i = 0;
        final int t = 170;
        for (int j = 0; j < this.arrayOfButtons.length; ++j) {
            final int count = j + 1;
            p.add(this.j2 = new JButton("level " + count));
            this.j2.setLocation(100, t + i);
            this.j2.setSize(300, 40);
            this.j2.setFont(new Font("Aharoni", 1, 20));
            this.j2.setBackground(Color.GRAY);
            this.j2.addActionListener(this);
            this.arrayOfButtons[j] = this.j2;
            i += 60;
            final int score = this.records.getRecords()[j];
            final String text = this.j2.getText();
            if (score == 0) {
                this.j2.setText(String.valueOf(text) + " Best score is   : -- : --");
            }
            else {
                this.j2.setText(String.valueOf(text) + " Best Score is :" + score);
            }
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        for (int i = 0; i < this.arrayOfButtons.length; ++i) {
            if (e.getSource().equals(this.arrayOfButtons[i])) {
                if (i == 0) {
                    try {
                        final GameWindow gameWindow = new GameWindow(i + 1);
                    }
                    catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                    i = this.arrayOfButtons.length;
                    this.dispose();
                }
                else if (i == 1) {
                    try {
                        final GameWindow gameWindow2 = new GameWindow(i + 1);
                    }
                    catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                    i = this.arrayOfButtons.length;
                    this.dispose();
                }
                else if (i == 2) {
                    try {
                        final GameWindow gameWindow3 = new GameWindow(i + 1);
                    }
                    catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                    i = this.arrayOfButtons.length;
                    this.dispose();
                }
                else if (i == 3) {
                    try {
                        final GameWindow gameWindow4 = new GameWindow(i + 1);
                    }
                    catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                    i = this.arrayOfButtons.length;
                    this.dispose();
                }
            }
        }
    }
}

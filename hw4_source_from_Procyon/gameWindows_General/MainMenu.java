// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Icon;
import Panels_Designs.backgroud;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener
{
    private JButton StartButton;
    private JButton Open;
    private JFrame jframe;
    
    public MainMenu() {
        (this.jframe = new JFrame()).setDefaultCloseOperation(3);
        this.jframe.getContentPane().setLayout(new BorderLayout());
        this.jframe.setSize(440, 500);
        this.jframe.setVisible(true);
        final backgroud p = new backgroud();
        p.setLayout(null);
        (this.Open = new JButton()).setIcon(Globals.LabelOpenImage);
        p.add(this.Open);
        this.Open.setLocation(50, 20);
        this.Open.setSize(290, 140);
        (this.StartButton = new JButton("start")).setFont(new Font("Aharoni", 1, 40));
        this.StartButton.setBackground(Color.GRAY);
        this.StartButton.setLocation(80, 220);
        this.StartButton.setSize(230, 80);
        this.StartButton.setBorder(BorderFactory.createLineBorder(Color.black));
        this.StartButton.addActionListener(this);
        p.add(this.StartButton);
        this.jframe.validate();
        this.jframe.add(p);
        this.jframe.validate();
        this.jframe.add(p, "Center");
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource().equals(this.StartButton)) {
            try {
                final SelectLevel selectLevel = new SelectLevel();
            }
            catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            this.jframe.dispose();
        }
    }
    
    public static void main(final String[] args) {
        final MainMenu m = new MainMenu();
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package Panels_Designs;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.Graphics;
import Balls.Ball;
import javax.swing.JPanel;

public class BallPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    private Ball Ball;
    
    public BallPanel(final Ball ball) {
        this.Ball = ball;
    }
    
    public void paintComponent(final Graphics gr) {
        final Image BallImage = this.Ball.getBallImage();
        gr.drawImage(BallImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

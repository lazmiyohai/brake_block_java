// 
// Decompiled by Procyon v0.5.36
// 

package Panels_Designs;

import java.awt.Image;
import java.awt.image.ImageObserver;
import gameWindows_General.Globals;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PaddlePanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    
    public void paintComponent(final Graphics gr) {
        final Image paddleGroundImage = Globals.PaddleImage;
        gr.drawImage(paddleGroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

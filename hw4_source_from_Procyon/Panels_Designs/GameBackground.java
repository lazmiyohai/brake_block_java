// 
// Decompiled by Procyon v0.5.36
// 

package Panels_Designs;

import java.awt.Image;
import java.awt.image.ImageObserver;
import gameWindows_General.Globals;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameBackground extends JPanel
{
    private static final long serialVersionUID = 1L;
    
    public void paintComponent(final Graphics gr) {
        final Image backGroundImageImage = Globals.backGroundImage;
        gr.drawImage(backGroundImageImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

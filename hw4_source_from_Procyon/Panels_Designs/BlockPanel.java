// 
// Decompiled by Procyon v0.5.36
// 

package Panels_Designs;

import java.awt.image.ImageObserver;
import java.awt.Graphics;
import Blocks.Block;
import java.awt.Image;
import javax.swing.JPanel;

public class BlockPanel extends JPanel
{
    private static final long serialVersionUID = 1L;
    public Image blockImage;
    public Block block;
    
    public BlockPanel(final Image imageBlock, final Block block) {
        this.blockImage = imageBlock;
        this.block = block;
    }
    
    public void paintComponent(final Graphics gr) {
        gr.drawImage(this.blockImage, 0, 0, 40, 25, this);
    }
    
    public Block getBlock() {
        return this.block;
    }
}

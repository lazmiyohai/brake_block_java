// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

import java.awt.Component;
import Blocks.RecBlock;
import Blocks.PlusBlock;
import Blocks.XBlock;
import Blocks.WoodenBlock;
import Blocks.ElectricityBlock;
import Blocks.WaterBlock;
import Blocks.FireBlock;
import Blocks.RegularBlock;
import Blocks.Block;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import Panels_Designs.BlockPanel;
import javax.swing.JPanel;

public class Board extends JPanel
{
    private static final long serialVersionUID = 1L;
    private int[][] Matrix;
    private BlockPanel[][] blocks;
    
    public Board(final int[][] Matrix) {
        super(new GridLayout(8, 10));
        this.Matrix = Matrix;
        this.blocks = new BlockPanel[8][10];
        for (int row = 0; row < Matrix.length; ++row) {
            for (int col = 0; col < Matrix[row].length; ++col) {
                if (Matrix[row][col] == 0) {
                    this.blocks[row][col] = new BlockPanel(Globals.EmptyBlockImage, null);
                }
                if (Matrix[row][col] == 1) {
                    this.blocks[row][col] = new BlockPanel(Globals.RegularBlockImage, new RegularBlock(this.getMatrix(), row, col));
                }
                if (Matrix[row][col] == 2) {
                    this.blocks[row][col] = new BlockPanel(Globals.FireBlockImage, new FireBlock(this.getMatrix(), row, col));
                }
                if (Matrix[row][col] == 3) {
                    this.blocks[row][col] = new BlockPanel(Globals.WaterBlockImage, new WaterBlock(this.getMatrix(), row, col));
                }
                if (Matrix[row][col] == 4) {
                    this.blocks[row][col] = new BlockPanel(Globals.ElectricityBlockImage, new ElectricityBlock(this.getMatrix(), row, col));
                }
                if (Matrix[row][col] == 5) {
                    this.blocks[row][col] = new BlockPanel(Globals.WoodenBlockImage, new WoodenBlock(this.getMatrix(), row, col));
                }
                if (Matrix[row][col] == 6) {
                    this.blocks[row][col] = new BlockPanel(Globals.XBlockImage, new XBlock(this.getMatrix(), row, col));
                }
                if (Matrix[row][col] == 7) {
                    this.blocks[row][col] = new BlockPanel(Globals.PlusBlockImage, new PlusBlock(this.getMatrix(), row, col));
                }
                if (Matrix[row][col] == 8) {
                    this.blocks[row][col] = new BlockPanel(Globals.RecBlockImage, new RecBlock(this.getMatrix(), row, col));
                }
                this.add(this.blocks[row][col]);
            }
        }
    }
    
    public void update() {
        this.removeAll();
        for (int row = 0; row < this.Matrix.length; ++row) {
            for (int col = 0; col < this.Matrix[row].length; ++col) {
                if (this.Matrix[row][col] == 0) {
                    this.blocks[row][col] = new BlockPanel(Globals.EmptyBlockImage, null);
                }
                if (this.Matrix[row][col] == 1) {
                    this.blocks[row][col] = new BlockPanel(Globals.RegularBlockImage, new RegularBlock(this.getMatrix(), row, col));
                }
                if (this.Matrix[row][col] == 2) {
                    this.blocks[row][col] = new BlockPanel(Globals.FireBlockImage, new FireBlock(this.getMatrix(), row, col));
                }
                if (this.Matrix[row][col] == 3) {
                    this.blocks[row][col] = new BlockPanel(Globals.WaterBlockImage, new WaterBlock(this.getMatrix(), row, col));
                }
                if (this.Matrix[row][col] == 4) {
                    this.blocks[row][col] = new BlockPanel(Globals.ElectricityBlockImage, new ElectricityBlock(this.getMatrix(), row, col));
                }
                if (this.Matrix[row][col] == 5) {
                    this.blocks[row][col] = new BlockPanel(Globals.WoodenBlockImage, new WoodenBlock(this.getMatrix(), row, col));
                }
                if (this.Matrix[row][col] == 6) {
                    this.blocks[row][col] = new BlockPanel(Globals.XBlockImage, new XBlock(this.getMatrix(), row, col));
                }
                if (this.Matrix[row][col] == 7) {
                    this.blocks[row][col] = new BlockPanel(Globals.PlusBlockImage, new PlusBlock(this.getMatrix(), row, col));
                }
                if (this.Matrix[row][col] == 8) {
                    this.blocks[row][col] = new BlockPanel(Globals.RecBlockImage, new RecBlock(this.getMatrix(), row, col));
                }
                this.add(this.blocks[row][col]);
            }
        }
    }
    
    public int[][] getMatrix() {
        return this.Matrix;
    }
    
    public BlockPanel[][] getBlock() {
        return this.blocks;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package Blocks;

import gameWindows_General.Visitor;

public abstract class Block implements Visitor
{
    int[][] matrix;
    int row;
    int col;
    
    public Block(final int[][] matrix, final int row, final int col) {
        this.matrix = matrix;
        this.row = row;
        this.col = col;
    }
}

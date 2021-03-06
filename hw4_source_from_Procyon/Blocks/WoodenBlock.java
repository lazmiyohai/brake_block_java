// 
// Decompiled by Procyon v0.5.36
// 

package Blocks;

import Balls.AllFoueElementsBall;
import Balls.ElectricityBall;
import Balls.WoodenBall;
import Balls.WaterBall;
import Balls.FireBall;

public class WoodenBlock extends Block
{
    private int[][] matrix;
    private int row;
    private int col;
    
    public WoodenBlock(final int[][] matrix, final int row, final int col) {
        super(matrix, row, col);
        this.matrix = matrix;
        this.row = super.row;
        this.col = super.col;
    }
    
    @Override
    public void visit(final FireBall ball) {
        this.matrix[this.row][this.col] = 0;
    }
    
    @Override
    public void visit(final WaterBall ball) {
        this.matrix[this.row][this.col] = 0;
    }
    
    @Override
    public void visit(final WoodenBall ball) {
        this.matrix[this.row][this.col] = 5;
    }
    
    @Override
    public void visit(final ElectricityBall ball) {
        this.matrix[this.row][this.col] = 5;
    }
    
    @Override
    public void visit(final AllFoueElementsBall ball) {
        this.matrix[this.row][this.col] = 0;
    }
}

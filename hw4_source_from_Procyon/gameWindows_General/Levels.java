// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

public class Levels
{
    public int[][] getMatrixLevel1() {
        final int[][] levelmatrix = { { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, { 2, 3, 3, 3, 3, 3, 3, 3, 3, 2 }, { 2, 3, 4, 4, 4, 4, 4, 4, 3, 2 }, { 2, 3, 4, 5, 5, 5, 5, 4, 3, 2 }, { 2, 3, 4, 5, 1, 1, 5, 4, 3, 2 }, { 2, 3, 4, 1, 1, 1, 1, 4, 3, 2 }, { 2, 1, 1, 1, 1, 1, 1, 1, 1, 2 }, { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 } };
        return levelmatrix;
    }
    
    public int[][] getMatrixLevel2() {
        final int[][] levelmatrix = { { 3, 1, 4, 4, 4, 4, 4, 4, 1, 3 }, { 3, 1, 4, 4, 4, 4, 4, 4, 1, 3 }, { 3, 1, 1, 1, 1, 1, 1, 1, 1, 3 }, { 3, 3, 3, 3, 2, 2, 3, 3, 3, 3 }, { 1, 5, 5, 5, 2, 2, 5, 5, 5, 1 }, { 1, 2, 2, 2, 2, 2, 2, 2, 2, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
        return levelmatrix;
    }
    
    public int[][] getMatrixLevel3() {
        final int[][] levelmatrix = { { 4, 3, 3, 3, 2, 2, 3, 3, 3, 4 }, { 4, 3, 8, 3, 2, 2, 3, 8, 3, 4 }, { 4, 3, 3, 3, 2, 2, 3, 3, 3, 4 }, { 2, 2, 2, 2, 7, 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2, 7, 2, 2, 2, 2 }, { 4, 5, 5, 5, 2, 2, 5, 5, 5, 4 }, { 4, 5, 8, 5, 2, 2, 5, 8, 5, 4 }, { 4, 5, 5, 5, 2, 2, 5, 5, 5, 4 } };
        return levelmatrix;
    }
    
    public int[][] getMatrixLevel4() {
        final int[][] levelmatrix = { { 2, 2, 1, 3, 3, 3, 3, 3, 4, 4 }, { 2, 2, 1, 3, 3, 6, 3, 3, 4, 4 }, { 2, 2, 1, 3, 3, 3, 3, 3, 4, 4 }, { 2, 2, 1, 3, 6, 3, 3, 3, 4, 4 }, { 5, 5, 5, 3, 3, 3, 3, 5, 5, 5 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 5, 1, 1, 5, 1, 1, 1 }, { 5, 6, 5, 5, 5, 5, 5, 5, 6, 5 } };
        return levelmatrix;
    }
    
    public int[][] getMatrixLevelByNumLevel(final int numLevel) {
        if (numLevel == 1) {
            return this.getMatrixLevel1();
        }
        if (numLevel == 2) {
            return this.getMatrixLevel2();
        }
        if (numLevel == 3) {
            return this.getMatrixLevel3();
        }
        if (numLevel == 4) {
            return this.getMatrixLevel4();
        }
        return null;
    }
}

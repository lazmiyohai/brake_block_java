// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

public class Paddle
{
    private int x;
    private int y;
    private int height;
    private int width;
    
    public Paddle() {
        this.x = 120;
        this.y = 420;
        this.height = 20;
        this.width = 120;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
}

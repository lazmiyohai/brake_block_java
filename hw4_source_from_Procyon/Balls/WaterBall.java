// 
// Decompiled by Procyon v0.5.36
// 

package Balls;

import gameWindows_General.Visitor;

public class WaterBall extends Ball
{
    public WaterBall() {
        super("Water");
    }
    
    @Override
    public void impact(final Visitor visitor) {
        visitor.visit(this);
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package Balls;

import gameWindows_General.Visitor;

public class ElectricityBall extends Ball
{
    public ElectricityBall() {
        super("Electricity");
    }
    
    @Override
    public void impact(final Visitor visitor) {
        visitor.visit(this);
    }
}

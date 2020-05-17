// 
// Decompiled by Procyon v0.5.36
// 

package Balls;

import gameWindows_General.Visitor;

public class WoodenBall extends Ball
{
    public WoodenBall() {
        super("Wooden");
    }
    
    @Override
    public void impact(final Visitor visitor) {
        visitor.visit(this);
    }
}

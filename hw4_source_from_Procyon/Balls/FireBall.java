// 
// Decompiled by Procyon v0.5.36
// 

package Balls;

import gameWindows_General.Visitor;

public class FireBall extends Ball
{
    public FireBall() {
        super("Fire");
    }
    
    @Override
    public void impact(final Visitor visitor) {
        visitor.visit(this);
    }
}

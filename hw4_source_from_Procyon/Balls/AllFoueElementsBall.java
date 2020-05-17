// 
// Decompiled by Procyon v0.5.36
// 

package Balls;

import gameWindows_General.Visitor;

public class AllFoueElementsBall extends Ball
{
    public AllFoueElementsBall() {
        super("AllFoueElementsBall");
    }
    
    @Override
    public void impact(final Visitor visitor) {
        visitor.visit(this);
    }
}

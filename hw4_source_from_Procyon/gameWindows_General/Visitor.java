// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

import Balls.AllFoueElementsBall;
import Balls.ElectricityBall;
import Balls.WoodenBall;
import Balls.WaterBall;
import Balls.FireBall;

public interface Visitor
{
    void visit(final FireBall p0);
    
    void visit(final WaterBall p0);
    
    void visit(final WoodenBall p0);
    
    void visit(final ElectricityBall p0);
    
    void visit(final AllFoueElementsBall p0);
}

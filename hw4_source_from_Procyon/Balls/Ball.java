// 
// Decompiled by Procyon v0.5.36
// 

package Balls;

import gameWindows_General.Globals;
import java.awt.Image;
import gameWindows_General.Visited;

public abstract class Ball implements Visited
{
    private String typeOfBall;
    private Image image;
    
    public Ball(final String s) {
        this.setBallType(s);
    }
    
    public String getBallType() {
        return this.typeOfBall;
    }
    
    public Image getBallImage() {
        return this.image;
    }
    
    public void setBallType(final String typeOfBall) {
        this.typeOfBall = typeOfBall;
        if (typeOfBall.equals("Fire")) {
            this.image = Globals.fireBallImage;
        }
        else if (typeOfBall.equals("Water")) {
            this.image = Globals.waterBallImage;
        }
        else if (typeOfBall.equals("Electricity")) {
            this.image = Globals.electricityBallImage;
        }
        else if (typeOfBall.equals("Wooden")) {
            this.image = Globals.woodenBallImage;
        }
        else if (typeOfBall.equals("AllFoueElementsBall")) {
            this.image = Globals.AllFoueElementsBallImage;
        }
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package gameWindows_General;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.File;
import java.security.CodeSource;

public class Globals
{
    public static CodeSource codeSource;
    public static File jarFile;
    public static Image backGroundImage;
    public static ImageIcon LabelOpenImage;
    public static Image PaddleImage;
    public static Image RegularBlockImage;
    public static Image fireBallImage;
    public static Image EmptyBlockImage;
    public static Image FireBlockImage;
    public static Image WaterBlockImage;
    public static Image WoodenBlockImage;
    public static Image ElectricityBlockImage;
    public static Image XBlockImage;
    public static Image PlusBlockImage;
    public static Image RecBlockImage;
    public static Image waterBallImage;
    public static Image electricityBallImage;
    public static Image woodenBallImage;
    public static Image AllFoueElementsBallImage;
    public static Image winnerBeckgroundlImage;
    
    static {
        Globals.codeSource = MainMenu.class.getProtectionDomain().getCodeSource();
        Globals.jarFile = new File(Globals.codeSource.getLocation().getPath());
        Globals.backGroundImage = new ImageIcon("1.jpg").getImage();
        Globals.LabelOpenImage = new ImageIcon("2.gif");
        Globals.PaddleImage = new ImageIcon("3.png").getImage();
        Globals.RegularBlockImage = new ImageIcon("4.png").getImage();
        Globals.fireBallImage = new ImageIcon("19.png").getImage();
        Globals.EmptyBlockImage = new ImageIcon("6.jpg").getImage();
        Globals.FireBlockImage = new ImageIcon("8.png").getImage();
        Globals.WaterBlockImage = new ImageIcon("7.png").getImage();
        Globals.WoodenBlockImage = new ImageIcon("9.png").getImage();
        Globals.ElectricityBlockImage = new ImageIcon("10.png").getImage();
        Globals.XBlockImage = new ImageIcon("11.png").getImage();
        Globals.PlusBlockImage = new ImageIcon("12.png").getImage();
        Globals.RecBlockImage = new ImageIcon("13.png").getImage();
        Globals.waterBallImage = new ImageIcon("20.png").getImage();
        Globals.electricityBallImage = new ImageIcon("21.png").getImage();
        Globals.woodenBallImage = new ImageIcon("18.png").getImage();
        Globals.AllFoueElementsBallImage = new ImageIcon("22.png").getImage();
        Globals.winnerBeckgroundlImage = new ImageIcon("26.jpg").getImage();
    }
}

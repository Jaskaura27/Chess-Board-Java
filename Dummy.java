import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Dummy extends Piece{

    //private BufferedImage img;
    public Dummy(int color, int x, int y){
        super(color, x, y);
    }

    public int getType(){
        return Def.DUMMY;
    }
    public void draw(Graphics2D g2){
        
    }
    
}

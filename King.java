import java.awt.Graphics2D; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class King extends Piece{

    private BufferedImage img;
    public King(int color, int x, int y){
        super(color, x, y);
        try{
            if(color==Def.BLACK){
                img =ImageIO.read(new File(Def.KING_BLACK));
            }
            else{
                img = ImageIO.read(new File(Def.KING_WHITE));
            }

        }catch(IOException e){

        }
    }

    public int getType(){
        return Def.KING;
    }

    public void move(int x, int y){
        super.move(x, y);
    }

    public void draw(Graphics2D g2) {
		int offsetX = (Def.LENGTH-img.getWidth())/2;
		int offsetY = (Def.LENGTH-img.getHeight())/2;
		g2.drawImage(img, offsetY+Def.GAP+getY()*Def.LENGTH, offsetX+Def.GAP+getX()*Def.LENGTH, img.getHeight(),img.getWidth(), null);
	}
    
}
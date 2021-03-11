
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GameControllerComponent extends JComponent implements MouseListener {
	private ChessBoard theBoard;
	private int turn =Def.WHITE;
	private int clickCount=0;

	private int row,column;
	
	
	public GameControllerComponent(){
		theBoard = new ChessBoard();
		theBoard.populate();
		addMouseListener(this);
	}
	public void paintComponent(Graphics g)
	{  
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		theBoard.draw(g2);

		if(clickCount%2==1){
			g2.setColor(Color.BLACK);
			g2.drawOval(Def.GAP+column*Def.LENGTH, Def.GAP+row*Def.LENGTH, Def.LENGTH, Def.LENGTH);
		}


	}	

	public void makeMove(int row, int column){
		System.out.println(clickCount);
		System.out.println("Row:"+row+" Column:"+column);
		if(clickCount%2==1 && theBoard.returnColor(row, column)==turn){
			this.row=row;
			this.column=column;
			repaint();
			System.out.println("Selected");

		}
		else if(this.row==row&&this.column==column){
			clickCount--;
		}
		else if(clickCount%2==0 && theBoard.returnType(row, column)==Def.DUMMY && valid(row,column)){
			System.out.println("type "+theBoard.returnType(row, column));
			theBoard.switchPieces(this.row,this.column,row,column);
			repaint();
			System.out.println("Moved");

			if(turn==Def.BLACK){	turn = Def.WHITE;}
			else{	turn=Def.BLACK;}
		}
		else{
			clickCount--;
		}
		System.out.println(clickCount);

	}
	private boolean valid(int row,int column){
		if(theBoard.returnType(this.row, this.column)==Def.PAWN){
			if(theBoard.returnColor(this.row, this.column)==Def.WHITE){
				if( (column==this.column) && ( this.row-1==row || this.row-2==row )){
					return true;
				}
			}
			else if(theBoard.returnColor(this.row, this.column)==Def.BLACK){
				if( (column==this.column) && ( this.row+1==row || this.row+2==row )){
					return true;
				}
			}
			return false;
		}
		
		else if(theBoard.returnType(this.row, this.column)==Def.KNIGHT){

			if( (this.column-1==column || this.column+1==column) && ( this.row-2==row || this.row+2==row )){
				return true;
			}
			if( (this.column-2==column || this.column+2==column) && ( this.row-1==row || this.row+1==row )){
				return true;
			}
			return false;
		}

		else if(theBoard.returnType(this.row, this.column)==Def.ROOK){
			if(row==this.row){
				if(this.column!=column){
					return true;
				}
			}
			if(column==this.column){
				if(this.row!=row){
					return true;
				}
			}
			return false;
		}

		else if(theBoard.returnType(this.row, this.column)==Def.BISHOP){
			if(Math.abs(this.row-row)==Math.abs(this.column-column)){
				return true;
			}
			return false;

		}

		else if(theBoard.returnType(this.row, this.column)==Def.KING){
			if( Math.abs(this.row-row)<=1 && Math.abs(this.column-column)<=1 ){
				return true;
			}
		}

		else if(theBoard.returnType(this.row, this.column)==Def.QUEEN){
			if(Math.abs(this.row-row)==Math.abs(this.column-column)){
				return true;
			}
			if(row==this.row){
				if(this.column!=column){
					return true;
				}
			}
			if(column==this.column){
				if(this.row!=row){
					return true;
				}
			}

			return false;
		}

		return false;
	}

	public void mouseClicked(MouseEvent event) {
			int row,column;
			column=(event.getX()-Def.GAP)/Def.LENGTH;
			row=(event.getY()-Def.GAP)/Def.LENGTH;
			System.out.println(row+" "+column);
			if(row<=7&&row>=0&&column<=7&&column>=0){
				clickCount++;
				makeMove(row, column);
			}
			
    }
            

    /**
     * Do-nothing methods
     */
	public void mouseMoved(MouseEvent event){}  
    public void mousePressed(MouseEvent event){}
    public void mouseReleased(MouseEvent event) {}
    public void mouseEntered(MouseEvent event) {}
    public void mouseExited(MouseEvent event) {}
    public void mouseDragged(MouseEvent event){}
}


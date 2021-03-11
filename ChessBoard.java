import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
*/
public class ChessBoard{
	private int SIZE =8;
	private Box[][] board;
	private Piece [][] pieces;

	public ChessBoard(){
		board = new Box[SIZE][SIZE];
		pieces = new Piece[SIZE][SIZE];
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				board[i][j] = new Box(Def.GAP+j*Def.LENGTH, Def.GAP+i*Def.LENGTH, Def.LENGTH);
			}
		}
		populate();
	}

	public void draw(Graphics2D g2)
	{  
		for(int i=0; i<SIZE; i++){
			for(int j=0; j<SIZE; j++){
				if((i+j)%2==0)
					board[i][j].draw(g2);
				else
					board[i][j].fill(g2);
			}
		}

		for(int i=0;i<pieces.length;i++){
			for(int j=0;j<pieces[i].length;j++){
				pieces[i][j].draw(g2);
			}
		}
	}

	public int returnType(int row,int column){
		return pieces[row][column].getType();
	}

	public int returnColor(int row,int column){
		return pieces[row][column].getColor();
	}

	public void populate(){

		//Drawing Black pawns
		for(int i=0;i<pieces[1].length;i++){
			pieces[1][i]=new Pawn(Def.BLACK,1,i);
		}

		//Drwaing white pawns
		for(int i=0;i<pieces[6].length;i++){
			pieces[6][i]=new Pawn(Def.WHITE,6,i);
		}



		//Drawing Black Rooks
		pieces[0][0] = new Rook(Def.BLACK,0,0);
		pieces[0][7] = new Rook(Def.BLACK, 0, 7);

		//Drawing white Rooks
		pieces[7][0] = new Rook(Def.WHITE,7,0);
		pieces[7][7] = new Rook(Def.WHITE, 7, 7);



		//Drawing Black Knight
		pieces[0][1] = new Knight(Def.BLACK,0,1);
		pieces[0][6] = new Knight(Def.BLACK, 0,6);

		//Drawing white Knight
		pieces[7][1] = new Knight(Def.WHITE,7,1);
		pieces[7][6] = new Knight(Def.WHITE, 7,6);


		//Drawing Black Bishop
		pieces[0][2] = new Bishop(Def.BLACK,0,2);
		pieces[0][5] = new Bishop(Def.BLACK, 0,5);

		//Drawing white Bishop[column]
		pieces[7][2] = new Bishop(Def.WHITE,7,2);
		pieces[7][5] = new Bishop(Def.WHITE, 7,5);


		//Drawing Black King and Queen
		pieces[0][3] = new Queen(Def.BLACK,0,3);
		pieces[0][4] = new King(Def.BLACK, 0,4);

		//Drawing White King and Queen
		pieces[7][3] = new Queen(Def.WHITE,7,3);
		pieces[7][4] = new King(Def.WHITE, 7,4);

		//Filing free spaces with Dummes
		for(int i=2;i<=5;i++){
			for(int j=0;j<pieces[i].length;j++){
				pieces[i][j]=new Dummy(Def.NO_COLOR, i, j);
			}
		}
		
		
		
	}

	public void switchPieces(int row, int column, int row2, int column2) {
		Piece temp=pieces[row][column];
		pieces[row][column]=pieces[row2][column2];
		pieces[row2][column2]=temp;

		pieces[row][column].move(row,column);
		pieces[row2][column2].move(row2,column2);
		System.out.println("Movedfrom("+row+","+column+") to ("+row2+","+column);
	}

	
}

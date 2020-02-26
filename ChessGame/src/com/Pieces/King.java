package com.Pieces;

import com.ChessBoard.Board;
import com.ChessBoard.Cell;
import com.Move;

import java.util.LinkedList;

public class King extends Piece {
    private int [] vectorX= {1,1,1,0,-1,-1,-1,0};
    private int [] vectorY={-1,0,1,1,1,0,-1,-1};
    @Override
    public LinkedList<Move> calculateLegalMoves() {
        int destinationX,destinationY;
        for(int i=0; i<vectorX.length;i++) {

            destinationX=this.getCell().getX()+vectorX[i];
            destinationY=this.getCell().getY()+vectorY[i];
            if(this.board.isOnBoard(destinationX,destinationY))
            {
                Cell destCell = this.board.getCell(destinationX, destinationY);
                if (destCell.isOccupied()) {
                    Piece destPiece = destCell.getPiece();
                    if (!destPiece.pieceColor.equals(this.pieceColor))
                        this.legalMoves.add(new Move(this, this.getCell(), destCell, true,this.board));
                } else {
                    this.legalMoves.add(new Move(this, this.getCell(), destCell, false,this.board));
                }
            }
        }
        return this.legalMoves;
    }
    public King(PieceColor pieceColor, Cell cell, Board board)
    {
        super(pieceColor,cell, board,PieceType.KING);
    }


}

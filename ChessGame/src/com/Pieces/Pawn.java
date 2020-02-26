package com.Pieces;

import com.ChessBoard.Board;
import com.ChessBoard.Cell;
import com.Move;

import java.util.LinkedList;

public class Pawn extends Piece {
    private int [] vectorX= {0,0,1,-1};
    private int [] vectorY={-1,-2,-1,-1};
    public boolean isFirstMove;
    @Override
    public LinkedList<Move> calculateLegalMoves() {
        int destinationX,destinationY;
        for(int i=0; i<vectorX.length;i++) {
            if(!isFirstMove)
            {
                if(vectorY[i]==-2)
                    continue;
            }
            destinationX=this.getCell().getX()+vectorX[i];
            destinationY=this.getCell().getY()+vectorY[i]*this.pieceColor.getId();
            System.out.println("x="+ destinationX + " y=" + destinationY);
            if(this.board.isOnBoard(destinationX,destinationY))
            {
                Cell destCell = this.board.getCell(destinationX, destinationY);
                if (destCell.isOccupied() && vectorX[i]!=0) {
                    Piece destPiece = destCell.getPiece();
                    if (!destPiece.pieceColor.equals(this.pieceColor))
                        this.legalMoves.add(new Move(this, this.getCell(), destCell, true,this.board));
                    else
                        continue;
                } else if(vectorX[i]==0 && !destCell.isOccupied()){

                    this.legalMoves.add(new Move(this, this.getCell(), destCell, false,this.board));
                }
            }
        }
        return this.legalMoves;
    }
    public Pawn(PieceColor pieceColor, Cell cell, Board board)
    {
        super(pieceColor,cell, board,PieceType.PAWN);
        isFirstMove=true;
    }


}

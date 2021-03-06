package com.Pieces;

import com.ChessBoard.Board;
import com.ChessBoard.Cell;
import com.Move;

import java.util.LinkedList;

public class Rook extends Piece {
    private int [] vectorX= {1,0,-1,0};
    private int [] vectorY={0,1,0,-1};
    @Override
    public LinkedList<Move> calculateLegalMoves() {
        int destinationX,destinationY;
        for(int i=0; i<vectorX.length;i++)
        {

            destinationX=this.getCell().getX()+vectorX[i];
            destinationY=this.getCell().getY()+vectorY[i];
            while(this.board.isOnBoard(destinationX,destinationY)) {

                Cell destCell = this.board.getCell(destinationX, destinationY);
                if (destCell.isOccupied()) {
                    Piece destPiece = destCell.getPiece();
                    if (!destPiece.pieceColor.equals(this.pieceColor))
                        this.legalMoves.add(new Move(this, this.getCell(), destCell, true,this.board));
                    else
                    {
                        break;
                    }
                } else {
                    this.legalMoves.add(new Move(this, this.getCell(), destCell, false,this.board));
                }

                destinationX+=vectorX[i];
                destinationY+=vectorY[i];
            }
        }
        return this.legalMoves;
    }

    public Rook(PieceColor pieceColor, Cell cell, Board board) {
        super(pieceColor, cell, board,PieceType.ROOK);
    }


}

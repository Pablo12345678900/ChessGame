package com.company;

import com.ChessBoard.Board;
import com.ChessBoard.Cell;
import com.Move;

import java.util.List;

public class Main {

    public static void main(String[] args) {

	    Board board=new Board();
	    board=board.createBoard();
	    System.out.println(board.toString());
	    Cell cell=board.getCell(6,0);
	     List<Move> legalMoves=cell.getPiece().calculateLegalMoves();
	     System.out.println("Number of legal moves for piece on: 0,0 is " +legalMoves.size());

    }
}

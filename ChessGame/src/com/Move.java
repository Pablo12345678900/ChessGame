package com;

import com.ChessBoard.Board;
import com.ChessBoard.Cell;
import com.Pieces.Piece;

public class Move {
    private Piece piece;
    private Cell startCell,finishCell;
    private boolean isAttackingMove;
    private Board board;



    public Move(Piece piece, Cell start, Cell finish, boolean isAttackingMove, Board board)
    {
        this.piece=piece;
        this.startCell=start;
        this.finishCell=finish;
        this.isAttackingMove=isAttackingMove;
        this.board=board;
    }

    public boolean isAttackingMove() {
        return isAttackingMove;
    }

    public void setAttackingMove(boolean attackingMove) {
        isAttackingMove = attackingMove;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Cell getStartCell() {
        return startCell;
    }

    public void setStartCell(Cell startCell) {
        this.startCell = startCell;
    }

    public Cell getFinishCell() {
        return finishCell;
    }

    public void setFinishCell(Cell finishCell) {
        this.finishCell = finishCell;
    }

    public Board execute() {
        return null;
    }
}

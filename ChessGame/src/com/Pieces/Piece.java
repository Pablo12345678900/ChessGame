package com.Pieces;

import com.ChessBoard.Board;
import com.ChessBoard.Cell;
import com.Move;

import java.util.LinkedList;

public abstract class Piece {
    public enum PieceColor
    {
        BLACK(-1), WHITE(1);
        private int id;
        PieceColor(int i) {
            this.id=i;
        }

        public int getId() {
            return id;
        }
    }
    protected  PieceColor pieceColor;
    protected LinkedList<Move> legalMoves;// możliwe ruchy
    protected Cell cell; // komórka planszy na której jest Piece
    protected Board board;
    public PieceType pieceType;
    public Piece(PieceColor pieceColor, Cell cell,Board board, PieceType pieceType)
    {
        this.pieceColor=pieceColor;
        this.cell=cell;
        legalMoves=new LinkedList<Move>();
        this.board=board;
        this.pieceType=pieceType;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public LinkedList<Move> getLegalMoves() {
        return legalMoves;
    }

    public void setLegalMoves(LinkedList<Move> legalMoves) {
        this.legalMoves = legalMoves;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }


    public abstract LinkedList<Move> calculateLegalMoves();
    public  String toString()
    {
        return " "+this.pieceType.type+" ";
    }
    public enum PieceType
    {
        PAWN("P"), ROOK("R"), KNIGHT("K"), BISHOP("B"), QUEEN("Q"), KING("K");
        public String type;
        PieceType(String type)
        {
            this.type=type;
        }
    }
}

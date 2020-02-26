package com.ChessBoard;

import com.Pieces.Piece;

public class Cell {

    private int x,y; // lewy górny róg to (0,0) prawy górny to (7,0) lewy dolny (0,7) a prawy dolny to (7,7)
    private Piece piece;

    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public boolean isOccupied()
    {
        if(piece==null)
        {
            return false;
        }
        else
            return true;
    }

    @Override
    public String toString() {
        String str="";
        if(piece==null)
            str=" - ";
        else
            str=piece.toString();

          return str;
    }
}

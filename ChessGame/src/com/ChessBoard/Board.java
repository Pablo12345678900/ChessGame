package com.ChessBoard;

import com.Move;
import com.Pieces.*;
import com.Player.BlackPlayer;
import com.Player.Player;
import com.Player.WhitePlayer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.Pieces.Piece.PieceColor.BLACK;
import static com.Pieces.Piece.PieceColor.WHITE;

public class Board {
    private Cell [][] cells;
    private Collection<Piece> whitePieces;
    private Collection<Piece> blackPieces;
    private Collection<Move>  allLegalMoves;
    private WhitePlayer whitePlayer;
    private BlackPlayer blackPlayer;
    private Player currentPlayer;
    public Board()
    {
        /*cells=new Cell[8][8];
        whitePieces=calculateActivePieces(WHITE);
        blackPieces=calculateActivePieces(BLACK);*/
        this.currentPlayer=null;

    }
    public Player whitePlayer()
    {
        return this.whitePlayer;
    }
    public Player blackPlayer()
    {
        return this.blackPlayer;
    }
    public Player currentPlayer()
    {
        return this.currentPlayer;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0; i<8;i++)
        {
            for(int j=0; j<8;j++)
            {
                stringBuilder.append(cells[i][j].toString());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Collection<Piece> calculateActivePieces(Piece.PieceColor pieceColor)
    {
        List<Piece> pieces=new ArrayList<Piece>();

        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                if(cells[i][j].isOccupied() && cells[i][j].getPiece().getPieceColor().equals(pieceColor))
                {
                    pieces.add(cells[i][j].getPiece());
                }
            }
        }
        return pieces;
    }
    public Cell getCell(int x, int y)
    {
        return cells[y][x];
    }
    public boolean isOnBoard(int x, int y)
    {
        if((x >=0 &&x<=7) && (y>=0 && y<=7))
            return true;
        else
            return false;
    }
    public Board createBoard()
    {
        cells=new Cell[8][8];
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(i>1 && i<6)
                {
                    cells[i][j]=new Cell(j,i,null);
                }
                else
                {
                    cells[i][j]=createFigures(j,i);
                }
            }
        }
        whitePieces=calculateActivePieces(WHITE);
        blackPieces=calculateActivePieces(BLACK);
        Collection <Move> whiteStandardLegalMoves=calculateLegalMoves(whitePieces);
        Collection<Move> blackStandardLegalMoves=calculateLegalMoves(blackPieces);
        whitePlayer=new WhitePlayer(this,whiteStandardLegalMoves, blackStandardLegalMoves);
        blackPlayer=new BlackPlayer(this, whiteStandardLegalMoves,blackStandardLegalMoves);
        return this;
    }
    public Collection<Move> calculateLegalMoves(Collection<Piece> pieces)
    {
        List<Move> legalMoves=new ArrayList<Move>();
        for(Piece piece : pieces)
        {
            legalMoves.addAll(piece.calculateLegalMoves());
        }
        return legalMoves;
    }
    public Cell createFigures(int x, int y)
    {
        Cell cell=null;
        switch(y)
        {
            case 0:
                cell=createConcretePieces(x,y,BLACK);
                break;
            case 1:
                Pawn pawn=new Pawn(BLACK, null,this);
                cell=new Cell(x,y,pawn);
                pawn.setCell(cell);
                break;
            case 6:
                pawn = new Pawn(WHITE, null,this);
                cell=new Cell(x,y,pawn);
                pawn.setCell(cell);
                break;
            case 7:
                cell=createConcretePieces(x,y,WHITE);
                break;

        }
        return cell;
    }

    private Cell createConcretePieces(int x, int y, Piece.PieceColor pieceColor) {
       Cell cell=null;
        if( y==0 || y==7)
        {
            if(x==0 || x==7)
            {
                Rook rook=new Rook(pieceColor, null,this);
                cell=new Cell(x,y,rook);
                rook.setCell(cell);

            }
            else if(x==1 || x==6)
            {
                Knight knight=new Knight(pieceColor, null,this);
                cell=new Cell(x,y,knight);
                knight.setCell(cell);
            }
            else if(x==2 || x==5)
            {
                Bishop bishop=new Bishop(pieceColor, null,this);
                cell=new Cell(x,y,bishop);
                bishop.setCell(cell);
            }
            else if(x==3)
            {
                Queen queen=new Queen(pieceColor, null,this);
                cell=new Cell(x,y,queen);
                queen.setCell(cell);
            }
            else
            {
                King king=new King(pieceColor, null,this);
                cell=new Cell(x,y,king);
                king.setCell(cell);
            }
        }
        return cell;
    }

    public Collection<Piece> getBlackPieces() {
        return this.blackPieces;
    }
    public Collection<Piece> getWhitePieces() {
        return this.whitePieces;
    }
}

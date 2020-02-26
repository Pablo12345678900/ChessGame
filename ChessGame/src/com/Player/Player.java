package com.Player;

import com.ChessBoard.Board;
import com.ChessBoard.Cell;
import com.Move;
import com.Pieces.King;
import com.Pieces.Piece;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Player {
    protected Board board;
    protected King playerKing;
    protected Collection<Move> legalMoves; // my legal moves
    protected boolean isInCheck;
    Player(Board board, Collection<Move> legalMoves, Collection<Move> opponentMoves)
    {
        this.board=board;
        this.playerKing=establishKing();
        this.legalMoves=legalMoves;
        this.isInCheck=!Player.attacksOnTile(this.playerKing.getCell(),opponentMoves).isEmpty();
    }

    private static Collection<Move> attacksOnTile(Cell cell, Collection<Move> opponentMoves) {
        List<Move> attackingMoves=new ArrayList<>();
        for(Move move: opponentMoves)
        {
            if(move.getFinishCell().equals(cell))
            {
                attackingMoves.add(move);
            }
        }
        return attackingMoves;
    }

    public boolean isInCheck()
    {
        return this.isInCheck;
    }
    public boolean isInCheckMate()
    {
        return (isInCheck && !hasEscapeMoves());
    }
    public boolean isInStalemate()
    {
        return !isInCheck && !hasEscapeMoves();
    }

    protected boolean hasEscapeMoves() {

        for(Move move: this.legalMoves)
        {
            MoveTransition transition=makeMove(move);
            if(transition.getMoveStatus().isDone())
            {
                return true;
            }
        }
        return false;
    }

    public Collection<Move> getLegalMoves()
    {
        return this.legalMoves;
    }

    private King establishKing() {
        for(Piece piece : getMyActivePieces())
        {
            if(piece.pieceType.equals(Piece.PieceType.KING))
            {
                return (King) piece;
            }
        }
        throw new RuntimeException("Not a valid board!");

    }
    public boolean isLegalMove(Move move)
    {
        return legalMoves.contains(move);
    }
    public MoveTransition makeMove(Move move)
    {
        if(!isLegalMove(move))
        {
            return new MoveTransition(this.board,move, MoveStatus.ILLEGAL);
        }
        Board transistionBoard=move.execute();
        Collection<Move> kingAttacks=Player.attacksOnTile(transistionBoard.currentPlayer().getOpponent().getPlayerKing().getCell(),
                transistionBoard.currentPlayer().getLegalMoves());
        if(!kingAttacks.isEmpty())
        {
            return new MoveTransition(this.board,move, MoveStatus.LEAVES_IN_CHECK);
        }
        return new MoveTransition(this.board,move,MoveStatus.DONE);
    }

    public  King getPlayerKing()
    {
     return this.playerKing;
    }

    protected abstract Collection<Piece> getMyActivePieces();
    protected abstract Piece.PieceColor getPieceColor();
    protected abstract Player getOpponent();
}

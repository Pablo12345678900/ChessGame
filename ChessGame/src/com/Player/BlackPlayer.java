package com.Player;

import com.ChessBoard.Board;
import com.Move;
import com.Pieces.Piece;

import java.util.Collection;

public class BlackPlayer extends Player {
    public BlackPlayer(Board board, Collection<Move> whitePlayerStandardMoves, Collection<Move> blackPlayerStandardMoves)
    {
        super(board,blackPlayerStandardMoves,whitePlayerStandardMoves);
    }

    @Override
    protected Collection<Piece> getMyActivePieces() {
        return this.board.getBlackPieces();
    }

    @Override
    protected Piece.PieceColor getPieceColor() {
        return Piece.PieceColor.BLACK;
    }

    @Override
    protected Player getOpponent() {
        return this.board.whitePlayer();
    }
}

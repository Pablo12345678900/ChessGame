package com.Player;

import com.ChessBoard.Board;
import com.Move;
import com.Pieces.Piece;

import java.util.Collection;

public class WhitePlayer extends Player {
    public WhitePlayer(Board board, Collection<Move> whitePlayerStandardMoves, Collection<Move> blackPlayerStandardMoves)
    {
        super(board,whitePlayerStandardMoves,blackPlayerStandardMoves);
    }
    @Override
    protected Collection<Piece> getMyActivePieces() {
        return this.board.getWhitePieces();
    }

    @Override
    protected Piece.PieceColor getPieceColor() {
        return Piece.PieceColor.WHITE;
    }

    @Override
    protected Player getOpponent() {
        return this.board.blackPlayer();
    }
}

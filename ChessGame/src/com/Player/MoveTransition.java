package com.Player;

import com.ChessBoard.Board;
import com.Move;

public class MoveTransition {
    private Board transistionBoard;
    private Move move;
    private MoveStatus moveStatus;

    public MoveTransition(Board transistionBoard, Move move, MoveStatus moveStatus) {
        this.transistionBoard = transistionBoard;
        this.move = move;
        this.moveStatus = moveStatus;
    }
    public MoveStatus getMoveStatus()
    {
        return this.moveStatus;
    }
}

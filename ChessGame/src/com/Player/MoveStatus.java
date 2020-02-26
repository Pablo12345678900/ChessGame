package com.Player;

public enum MoveStatus {
    DONE
            {
                @Override
                boolean isDone() {
                    return true;
                }
            },
    ILLEGAL
            {
                @Override
                boolean isDone() {
                    return false;
                }
            },
    LEAVES_IN_CHECK
            {
                @Override
                boolean isDone() {
                    return false;
                }
            };
    abstract boolean isDone();
}

package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean isFinished = false;
    private boolean isComplete = false;

    @Override
    public void execute() {
        if(isComplete) isFinished = true;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void complete() {
        isComplete = true;
    }
}

package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    private int countdown;
    private boolean isFinished;
    public CountDownTask(int value) {
        if(value <= 0) {
            countdown = 0;
            isFinished = true;
        }
        else {
            countdown = value;
            isFinished = false;
        }
    }

    public int getValue() {
        return countdown;
    }


    @Override
    public void execute() {
        if(countdown > 0 && !isFinished) {
            countdown--;
            if(countdown == 0) isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}

package com.epam.rd.autotasks;

public class DecrementingCarousel {
    public int [] carrousel;
    private int positionToAdd = 0;
    private boolean accumulatingState;
    private int numberOfCarouselRun = 0;
    protected int positionToDecrement = 0;

    public DecrementingCarousel(int capacity) {
        this.carrousel = new int[capacity];
        this.accumulatingState = true;
    }

    public boolean addElement(int element){
        if(accumulatingState && element>0 && positionToAdd<carrousel.length){
            carrousel[positionToAdd] = element;
            positionToAdd++;
            return true;
        } else {
            return false;
        }
    }

    public CarouselRun run(){
        if(numberOfCarouselRun == 0){
            numberOfCarouselRun++;
            accumulatingState = false;
            return new CarouselRun(this);
        } else {
            return null;
        }
    }

    public int decrement (){
        int count = 0;
        int length = carrousel.length;

        while(count <= length){
            if(carrousel[positionToDecrement] > 0){
                break;
            } else {
                if(positionToDecrement == length-1){
                    positionToDecrement = 0;
                } else {
                    positionToDecrement++;
                }
                count++;
            }
        }

        int numToReturn = carrousel[positionToDecrement];
        carrousel[positionToDecrement]--;

        if(positionToDecrement == length-1){
            positionToDecrement = 0;
        } else {
            positionToDecrement++;
        }

        return numToReturn;
    }
}


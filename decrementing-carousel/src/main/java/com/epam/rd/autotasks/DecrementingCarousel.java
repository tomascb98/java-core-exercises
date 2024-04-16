package com.epam.rd.autotasks;



public class DecrementingCarousel {
    public int [] carrousel;
    private int positionToAdd = 0;
    private boolean accumulatingState;
    private int numberOfCarouselRun = 0;

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
}

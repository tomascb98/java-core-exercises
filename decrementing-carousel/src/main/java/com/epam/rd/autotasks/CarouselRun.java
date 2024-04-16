package com.epam.rd.autotasks;

public class CarouselRun {
    private DecrementingCarousel decrementingCarousel;
    private int positionToDecrement = 0;

    public CarouselRun(DecrementingCarousel carousel) {
        this.decrementingCarousel = carousel;
    }

    public int next() {
        int count = 0;
        int length = decrementingCarousel.carrousel.length;

        if(isFinished()) return -1;

        while(count <= length){
            if(decrementingCarousel.carrousel[positionToDecrement] > 0){
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


        int numToReturn = decrementingCarousel.carrousel[positionToDecrement];
        decrementingCarousel.carrousel[positionToDecrement]--;

        if(positionToDecrement == length-1){
            positionToDecrement = 0;
        } else {
            positionToDecrement++;
        }

        return numToReturn;

    }


    public boolean isFinished() {
        int count = 0;
        for (int i = 0 ; i < decrementingCarousel.carrousel.length ; i++) {
            if(decrementingCarousel.carrousel[i] == 0){
                count++;
            }
        }
        return count == decrementingCarousel.carrousel.length;
    }

}

package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public int decrement() {
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
        carrousel[positionToDecrement] /= 2;

        if(positionToDecrement == length-1){
            positionToDecrement = 0;
        } else {
            positionToDecrement++;
        }

        return numToReturn;
    }
}

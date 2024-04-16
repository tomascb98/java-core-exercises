package com.epam.rd.autotasks;

import java.util.Arrays;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    int [] decrementArray;
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
        this.decrementArray = new int[capacity];
        Arrays.fill(decrementArray, 1);
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
            carrousel[positionToDecrement] -= decrementArray[positionToDecrement];
            decrementArray[positionToDecrement]++;

            if(positionToDecrement == length-1){
                positionToDecrement = 0;
            } else {
                positionToDecrement++;
            }

            return numToReturn;
        }
}

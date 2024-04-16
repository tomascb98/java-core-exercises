package com.epam.rd.autotasks;

public class CarouselRun {
    private DecrementingCarousel decrementingCarousel;

    public CarouselRun(DecrementingCarousel carousel) {
        this.decrementingCarousel = carousel;
    }

    public int next() {
        if(isFinished()) return -1;
        return decrementingCarousel.decrement();
    }


    public boolean isFinished() {
        int count = 0;
        for (int i = 0 ; i < decrementingCarousel.carrousel.length ; i++) {
            if(decrementingCarousel.carrousel[i] <= 0){
                count++;
            }
        }
        return count == decrementingCarousel.carrousel.length;
    }

}


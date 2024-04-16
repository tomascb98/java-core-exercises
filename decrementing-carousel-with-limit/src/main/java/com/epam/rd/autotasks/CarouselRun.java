package com.epam.rd.autotasks;

public class CarouselRun {
    private DecrementingCarousel decrementingCarousel;
    private int currentCountNext = 0;

    public CarouselRun(DecrementingCarousel carousel) {
        this.decrementingCarousel = carousel;
    }

    public int next() {
        if(isFinished()) return -1;
        currentCountNext++;
        return decrementingCarousel.decrement();
    }


    public boolean isFinished() {
        if(decrementingCarousel instanceof DecrementingCarouselWithLimitedRun){
            DecrementingCarouselWithLimitedRun dCarousel = (DecrementingCarouselWithLimitedRun) decrementingCarousel;
            if(currentCountNext >= dCarousel.actionLimit){
                return true;
            }
        }

        int count = 0;
        for (int i = 0; i < decrementingCarousel.carrousel.length; i++) {
            if (decrementingCarousel.carrousel[i] == 0) {
                count++;
            }
        }
        return count == decrementingCarousel.carrousel.length;

    }
}

package com.example.aspectjaop;

import java.util.concurrent.TimeUnit;

/**
 * @des:Class representing a StopWatch for measuring time.
 * @author: 薛宝鹏
 * @date: 2018/4/21 17:36
 */
public class StopWatch {
    private long startTime;
    private long endTime;
    private long elapsedTime;

    public StopWatch() {
        //empty
    }

    private void reset() {
        startTime = 0;
        endTime = 0;
        elapsedTime = 0;
    }

    public void start() {
        reset();
        startTime = System.nanoTime();
    }

    public void stop() {
        if (startTime != 0) {
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
        } else {
            reset();
        }
    }

    public long getTotalTimeMillis() {
        return (elapsedTime != 0) ? TimeUnit.NANOSECONDS.toMillis(endTime - startTime) : 0;
    }
}

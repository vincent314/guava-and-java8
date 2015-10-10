package org.vince.guava;

import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

import java.time.Duration;

public class StopWatchRule extends Stopwatch {

    @Override
    protected void succeeded(long nanos, Description description) {
        System.out.println(description.getDisplayName() + " : " + Duration.ofNanos(nanos).toMillis() + "ms");
    }
}

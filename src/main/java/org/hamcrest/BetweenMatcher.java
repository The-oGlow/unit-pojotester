package org.hamcrest;

import org.hamcrest.core.IsBetween;
import org.hamcrest.core.IsBetweenWithBound;

public class BetweenMatcher {

    private BetweenMatcher() {
    }

    /**
     * Creates a matcher for {@code T}s that matches, if the value is between a given range.<br>
     * Range start and end <strong>NOT</strong>included.
     *
     * @param from start value for the range
     * @param to end value for the range
     * @param <T> type of the values
     * @return newly created matcher
     */
    public static <T extends Comparable<T>> Matcher<T> between(final T from, final T to) {
        return IsBetween.between(from, to);
    }

    /**
     * Creates a matcher for {@code T}s that matches, if the value is between a given range.<br>
     * Range start and end <strong>IS</strong>included.
     *
     * @param from start value for the range
     * @param to end value for the range
     * @param <T> type of the values
     * @return newly created matcher
     */
    public static <T extends Comparable<T>> Matcher<T> betweenWithBound(final T from, final T to) {
        return IsBetweenWithBound.between(from, to);
    }

}

package org.hamcrest.core;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.TypeSafeMatcher;

public class IsBetweenWithBound<T extends Comparable<T>> extends TypeSafeMatcher<T> {

    private final T from;
    private final T to;

    private IsBetweenWithBound(final T from, final T to) {
        MatcherAssert.assertThat(from, notNullValue());
        MatcherAssert.assertThat(to, notNullValue());
        MatcherAssert.assertThat(to, greaterThanOrEqualTo(from));

        this.from = from;
        this.to = to;
    }

    public static <T extends Comparable<T>> Matcher<T> between(final T from, final T to) {
        return new IsBetweenWithBound<>(from, to);
    }

    @Override
    protected boolean matchesSafely(final T t) {
        return (t.compareTo(from) >= 0) && (t.compareTo(to) <= 0);
    }

    @Override
    protected void describeMismatchSafely(final T item, final Description mismatchDescription) {
        mismatchDescription.appendValue(item).appendText(" is not between ").appendValue(from).appendText(" and ").appendValue(to)
                .appendText(". Range start and end ARE included.");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("The value must be between ").appendValue(from).appendText(" and ").appendValue(to)
                .appendText(". Range start and end ARE included. ");
    }
}

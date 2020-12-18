package com.example.mainactivity;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static androidx.test.InstrumentationRegistry.getInstrumentation;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import com.example.mainactivity.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction textView = onView(
                allOf(withText("HOME"),
                        withParent(allOf(withContentDescription("Home"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView.check(matches(withText("HOME")));

        ViewInteraction textView2 = onView(
                allOf(withText("FORECAST"),
                        withParent(allOf(withContentDescription("Forecast"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView2.check(matches(withText("FORECAST")));

        ViewInteraction textView3 = onView(
                allOf(withText("LOGS"),
                        withParent(allOf(withContentDescription("Logs"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView3.check(matches(withText("LOGS")));

        ViewInteraction textView4 = onView(
                allOf(withText("WARNINGS"),
                        withParent(allOf(withContentDescription("Warnings"),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        textView4.check(matches(withText("WARNINGS")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.textView2), withText("Temp"),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        textView5.check(matches(withText("Temp")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.textView4), withText("Humidity"),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        textView6.check(matches(withText("Humidity")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.textView5), withText("CO2"),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        textView7.check(matches(withText("CO2")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.textView6), withText("Persons"),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        textView8.check(matches(withText("Persons")));

        ViewInteraction button = onView(
                allOf(withId(R.id.buttonUpdate), withText("UPDATE"),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.textView7), withText("Shaft"),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        textView9.check(matches(withText("Shaft")));

        ViewInteraction switch_ = onView(
                allOf(withId(R.id.shaft_switch),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        switch_.check(matches(isDisplayed()));

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.textView8), withText("Ventilator"),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        textView10.check(matches(withText("Ventilator")));

        ViewInteraction switch_2 = onView(
                allOf(withId(R.id.switch1),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        switch_2.check(matches(isDisplayed()));

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.textView), withText("Safety Parameter"),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        textView11.check(matches(withText("Safety Parameter")));

        ViewInteraction progressBar = onView(
                allOf(withId(R.id.progressBarTemp),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        progressBar.check(matches(isDisplayed()));

        ViewInteraction progressBar2 = onView(
                allOf(withId(R.id.progressBarHumidity),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        progressBar2.check(matches(isDisplayed()));

        ViewInteraction progressBar3 = onView(
                allOf(withId(R.id.progressBarCO2),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        progressBar3.check(matches(isDisplayed()));

        ViewInteraction progressBar4 = onView(
                allOf(withId(R.id.progressBarPeople),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        progressBar4.check(matches(isDisplayed()));

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Forecast"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.textView3), withText("Pick a day for forecast"),
                        withParent(withParent(withId(R.id.view_pager))),
                        isDisplayed()));
        textView12.check(matches(withText("Pick a day for forecast")));

       /* ViewInteraction view = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.view.View.class),
                        withParent(allOf(IsInstanceOf.<View>instanceOf(com.android.internal.widget.ViewPager.class),
                                withParent(withId(R.id.calendarView)))),
                        isDisplayed()));
        view.check(matches(isDisplayed()));

        ViewInteraction view2 = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.view.View.class),
                        withParent(allOf(IsInstanceOf.<View>instanceOf(com.android.internal.widget.ViewPager.class),
                                withParent(withId(R.id.calendarView)))),
                        isDisplayed()));
        view2.check(matches(isDisplayed()));*/

        ViewInteraction tabView2 = onView(
                allOf(withContentDescription("Logs"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                2),
                        isDisplayed()));
        tabView2.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

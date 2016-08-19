package com.example.qube.jjspost;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.qube.jjspost.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


/**
 * Created by Qube on 8/19/16.
 */

@RunWith(AndroidJUnit4.class)
public class ArticlesHomeTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testIfNavDrawerWorks() throws Exception {
        onView(withId(R.id.drawer_layout)).perform(swipeUp());
        onView(withId(R.id.drawer_layout)).perform(swipeDown());
        onView(withId(R.id.drawer_layout)).perform(swipeUp());
        onView(withId(R.id.drawer_layout)).perform(swipeDown());
        onView(withId(R.id.drawer_layout)).perform(swipeUp());
    }

    @Test
    public void testIfArticlesSwipe() throws Exception {
        onView(withId(R.id.sectionViewPager)).perform(swipeLeft());
        onView(withId(R.id.sectionViewPager)).perform(swipeRight());
        onView(withId(R.id.sectionViewPager)).perform(swipeLeft());
        onView(withId(R.id.sectionViewPager)).perform(swipeLeft());
        onView(withId(R.id.sectionViewPager)).perform(swipeLeft());
        onView(withId(R.id.sectionViewPager)).perform(swipeRight());
        onView(withId(R.id.sectionViewPager)).perform(swipeLeft());
        onView(withId(R.id.sectionViewPager)).perform(swipeLeft());
        onView(withId(R.id.sectionViewPager)).perform(swipeLeft());
        onView(withId(R.id.sectionViewPager)).perform(swipeRight());
        onView(withId(R.id.sectionViewPager)).perform(swipeLeft());
        onView(withId(R.id.sectionViewPager)).perform(swipeLeft());
    }

}

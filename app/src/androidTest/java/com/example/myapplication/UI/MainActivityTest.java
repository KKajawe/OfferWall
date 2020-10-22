package com.example.myapplication.UI;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.myapplication.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);
    /*
     *...appId is ""
     *...as appId is empty and click on submit button , TextView messageText visible with red color message
     *...and our test submitFailed says - if any user input is empty then the expected result is TextView messageText visible with red color message
     * **as functionality of button click and our test submitFailed both are same
     * **that means functionality of button click  logic is right and so the test is passed
     */
    @Test
    public void submitFailed() {
        onView(withId(R.id.edtAppId)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.edtUserId)).perform(typeText("superman"), closeSoftKeyboard());
        onView(withId(R.id.edtToken)).perform(typeText("1c915e3b5d42d05136185030892fbb846c278927"), closeSoftKeyboard());
        onView(withId(R.id.btnSubmit)).perform(click());
        onView(withId(R.id.messageText)).check(matches(withText("One of the input is invalid")));
    }
    /*
     *...User inputs are not null and not empty , all valid
     *...and click on submit button works then TextView messageText visible with green  color success message
     *...and our test submitSuccessful says - if all user inputs are valid
     * ....then TextView messageText visible with green  color success message
     *  **as functionality of button click and our test submitSuccessful both work same
     *  **that means functionality of button click logic is right and so the test is passed
     */
    @Test
    public void submitSuccessful() {
        onView(withId(R.id.edtAppId)).perform(typeText("2070"), closeSoftKeyboard());
        onView(withId(R.id.edtUserId)).perform(typeText("superman"), closeSoftKeyboard());
        onView(withId(R.id.edtToken)).perform(typeText("1c915e3b5d42d05136185030892fbb846c278927"), closeSoftKeyboard());
        onView(withId(R.id.btnSubmit)).perform(click());
        onView(withId(R.id.messageText)).check(matches(withText("Success")));
    }

}
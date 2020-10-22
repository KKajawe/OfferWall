package com.example.myapplication.UI;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class OfferListActivityTest {

    private static final String TEXT_ITEM_10 = "{title=Offer Title 10}";

    private static final String TEXT_ITEM_10_SELECTED = "{title=Offer Title 10}";

    private static final String TEXT_ITEM_20 = "{title=Offer Title 20}";

    // Match the last item by matching its text.
    private static final String LAST_ITEM_ID = "{title=Offer Title 39}";

    @Rule
    public ActivityScenarioRule<OfferListActivity> rule = new ActivityScenarioRule<>(
            OfferListActivity.class);

    /**
     * Test - Last item should not exist if the list wasn't scrolled down.
     */
    @Test
    public void lastItem_NotDisplayed() {
        onView(withText(LAST_ITEM_ID)).check(doesNotExist());
    }


}
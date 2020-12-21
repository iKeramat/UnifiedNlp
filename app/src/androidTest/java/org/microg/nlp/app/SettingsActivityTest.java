package org.microg.nlp.app;

import androidx.lifecycle.Lifecycle;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class SettingsActivityTest {

    @Rule
    public ActivityScenarioRule<SettingsActivity> activityRule
            = new ActivityScenarioRule<>(SettingsActivity.class);

    @Test
    public void activityStarts() {
        Lifecycle.State activityState = activityRule.getScenario().getState();
        assertTrue(Lifecycle.State.RESUMED == activityState
            || Lifecycle.State.STARTED == activityState);
    }
}


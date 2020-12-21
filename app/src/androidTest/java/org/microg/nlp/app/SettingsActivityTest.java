package org.microg.nlp.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class SettingsActivityTest {

    Context context;

    private static class DummyActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
//            startActivity(new Intent(this, SettingsActivity.class));
//            startActivity(new Intent(Intent.ACTION_APPLICATION_PREFERENCES));
        }
    }

//    @Rule
//    public ActivityScenarioRule<SettingsActivity> activityRule
//            = new ActivityScenarioRule<>(SettingsActivity.class);

//    @Rule
//    public IntentsTestRule<SettingsActivity> intentsTestRule =
//            new IntentsTestRule<>(SettingsActivity.class, true, false);

    @Before
    public void setup() {
//        ActivityScenario.launch(DummyActivity.class);//SettingsActivity.class);
        context = InstrumentationRegistry.getInstrumentation().getContext();
    }

    @Test
    public void activityStarts() {
//        Intent intent = new Intent(Intent.ACTION_APPLICATION_PREFERENCES);
//
//        SettingsActivity test = intentsTestRule.launchActivity(intent);

//        Lifecycle.State activityState = activityRule.getScenario().getState();
//        assertTrue(Lifecycle.State.RESUMED == activityState
//            || Lifecycle.State.STARTED == activityState);
        Intent intent = new Intent(Intent.ACTION_APPLICATION_PREFERENCES);
        intent.setClassName(BuildConfig.APPLICATION_ID, SettingsActivity.class.getName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        Espresso.onView(ViewMatchers.withId(1));
    }
}


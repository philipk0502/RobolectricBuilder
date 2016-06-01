package com.example.myapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RobolectricTest {
    @Test
    public void testFirst() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        TextView results = (TextView) activity.findViewById(R.id.textView);
        String resultsText = results.getText().toString();

        // failing test gives much better feedback to show that all works
        // correctly
        assertThat(resultsText, equalTo("Hello world!"));

    }
    @Test
    public void testSecond()
    {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        TextView results = (TextView) activity.findViewById(R.id.textView);
        Button but = (Button) activity.findViewById(R.id.button);

        but.performClick();
        String resultsText = results.getText().toString();
        assertThat(resultsText, equalTo("bye world!"));
    }

    @Test
    public void testIntent()
    {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Button button = (Button) activity.findViewById(R.id.button2);
        button.performClick();
        // The intent we expect to be launched when a user clicks on the button
        assertThat(shadowActivity
                .peekNextStartedActivityForResult()
                .intent.getComponent(), equalTo(new ComponentName(activity, Main2Activity.class)));


    }



}

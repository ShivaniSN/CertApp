package apps.com.certapp;

import android.content.Context;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class Test_ActivityMain {

    @Rule
    public ActivityTestRule<Activity_Main> mActivityRule =
            new ActivityTestRule<>(Activity_Main.class);

    @Test
    public void loginSuccess(){
        Espresso.onView(withId(R.id.et_pwd)).perform(typeText("1234"));
       // Espresso.onView(withId(R.id.btn_login)).perform(scrollTo()).perform(click());
        Espresso.onView(withId(R.id.et_pwd)).check(matches(withText("1234")));
        Espresso.onView(allOf(withId(android.support.design.R.id.snackbar_text), withText("This Test Works")))
                .check(matches(isDisplayed()));
    }
}

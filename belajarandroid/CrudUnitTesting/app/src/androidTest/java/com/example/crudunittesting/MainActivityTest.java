package com.example.crudunittesting;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.test.filters.MediumTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.crudunittesting.adapter.NasabahAdapter;
import com.example.crudunittesting.controller.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureListViewIsPresent() throws Exception{
        MainActivity activity = rule.getActivity();
        View viewById = activity.findViewById(R.id.listviewutama);
        assertThat(viewById,notNullValue());
        assertThat(viewById,instanceOf(ListView.class));
        ListView listView =(ListView) viewById;
        ListAdapter adapter= listView.getAdapter();
        assertThat(adapter, instanceOf(NasabahAdapter.class));
        assertThat(adapter.getCount(),greaterThan(5));

    }
}

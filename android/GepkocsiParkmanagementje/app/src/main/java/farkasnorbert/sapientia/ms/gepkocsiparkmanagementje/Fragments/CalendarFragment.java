package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.AsyncTasks.LoadTravelDates;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.DrawableUtils;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models.Travel;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;

public class CalendarFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Travel>> {
    private static final String TAG = "CalendarFragment";
    private List<Travel> travels;
    private List<EventDay> events;
    private CalendarView calendarView;

    public CalendarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        NavigationView navigationView = Objects.requireNonNull(getActivity()).findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        events = new ArrayList<>();
        calendarView = view.findViewById(R.id.calendarView);
        calendarView.setOnDayClickListener(eventDay -> {
            Calendar clickedDayCalendar = eventDay.getCalendar();
            TextView t = view.findViewById(R.id.textView);
            t.setText(clickedDayCalendar.toString());
        });
        getLoaderManager().initLoader(0, null, this);
        getLoaderManager().getLoader(0).startLoading();
        return view;
    }

    @NonNull
    @Override
    public Loader<List<Travel>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new LoadTravelDates(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Travel>> loader, List<Travel> travels) {
        this.travels = travels;
        for (Travel t : travels) {
            Log.d(TAG, t.getIndulas().toString());
            Log.d(TAG, t.getHaza_erkezes().toString());
            long diff = t.getHaza_erkezes().getTime() - t.getIndulas().getTime();
            long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            Log.d(TAG, String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));
            Calendar calendar = Calendar.getInstance();
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(t.getIndulas());
            calendar.setTime(t.getIndulas());
            //Log.d(TAG,calendar.getTime().toString());
            events.add(new EventDay(calendar, DrawableUtils.getCircleDrawableWithText(getActivity(), String.valueOf(t.getAuto()), R.drawable.ic_dot_red)));
            for (int i = 0; i <= days; i++) {
                calendar1.add(Calendar.DATE,1);
                Calendar c = Calendar.getInstance();
                c.setTime(calendar1.getTime());
                events.add(new EventDay(c, DrawableUtils.getCircleDrawableWithText(getActivity(), String.valueOf(t.getAuto()), R.drawable.ic_dot_red)));
                Log.d(TAG,calendar1.getTime().toString());
            }
        }
        calendarView.setEvents(events);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Travel>> loader) {

    }
}

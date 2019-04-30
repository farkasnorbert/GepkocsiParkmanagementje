package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
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

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.DrawableUtils;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.LoadCarDates;
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
        return new LoadCarDates(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Travel>> loader, List<Travel> travels) {
        this.travels = travels;
        for (Travel t : travels) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(t.getIndulas());
            events.add(new EventDay(calendar, DrawableUtils.getCircleDrawableWithText(getActivity(), String.valueOf(t.getAuto()), R.drawable.ic_dot_red)));
        }
        calendarView.setEvents(events);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Travel>> loader) {

    }
}

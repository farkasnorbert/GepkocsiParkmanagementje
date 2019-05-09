package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.AsyncTasks.LoadCars;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models.Car;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.RecyclerViewAdapter;

public class CarsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Car>> {

    private static final String TAG = "CarsFragment";
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    public CarsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars, container, false);
        NavigationView navigationView = Objects.requireNonNull(getActivity()).findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(1).setChecked(true);
        Toolbar toolbar = view.findViewById(R.id.cars_toolbar);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
        recyclerView = view.findViewById(R.id.recyclerViewCars);
        recyclerView.setHasFixedSize(true);
        getLoaderManager().initLoader(0, null, this);
        getLoaderManager().getLoader(0).startLoading();
        return view;
    }

    @NonNull
    @Override
    public Loader<List<Car>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new LoadCars(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Car>> loader, List<Car> cars) {
        adapter = new RecyclerViewAdapter(getContext(), cars,getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Car>> loader) {

    }
}

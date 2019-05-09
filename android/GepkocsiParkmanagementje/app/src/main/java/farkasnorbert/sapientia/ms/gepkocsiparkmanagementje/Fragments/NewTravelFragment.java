package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;

public class NewTravelFragment extends Fragment {


    public NewTravelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_travel, container, false);
        NavigationView navigationView = Objects.requireNonNull(getActivity()).findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(1).setChecked(true);
        Toolbar toolbar = view.findViewById(R.id.cars_toolbar);
        toolbar.setTitle("New Travel");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
        return view;
    }

}

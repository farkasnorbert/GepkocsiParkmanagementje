package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Activitys.MainActivity;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;

public class LogInFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        Button register = view.findViewById(R.id.register_button);
        register.setOnClickListener(v ->{
            if(getActivity()!=null) {
                RegisterFragment registerFragment = new RegisterFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_start, registerFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        Button logIn = view.findViewById(R.id.logIn_button);
        logIn.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), MainActivity.class));
        });
        return view;
    }
}

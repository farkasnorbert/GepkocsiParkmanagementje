package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;

public class RegisterFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        Button login = view.findViewById(R.id.login_Button);
        login.setOnClickListener(v ->{
            if(getActivity()!=null) {
                LogInFragment logInFragment = new LogInFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_start, logInFragment,"login");
                fragmentTransaction.addToBackStack("login");
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}

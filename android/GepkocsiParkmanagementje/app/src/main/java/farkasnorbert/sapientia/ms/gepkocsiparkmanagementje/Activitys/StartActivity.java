package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments.LogInFragment;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Fragment login = new LogInFragment();
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_start, login);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

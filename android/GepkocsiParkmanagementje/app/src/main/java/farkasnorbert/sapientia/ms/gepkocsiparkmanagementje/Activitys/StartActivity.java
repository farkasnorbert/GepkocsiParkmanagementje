package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Activitys;

import android.content.Intent;
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
        startActivity(new Intent(this, MainActivity.class));
        Fragment login = new LogInFragment();
        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_start, login,"login");
        transaction.addToBackStack("login");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(this.getSupportFragmentManager().findFragmentByTag("login")!=null && this.getSupportFragmentManager().findFragmentByTag("login").isVisible()) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else {
            super.onBackPressed();
        }
    }
}

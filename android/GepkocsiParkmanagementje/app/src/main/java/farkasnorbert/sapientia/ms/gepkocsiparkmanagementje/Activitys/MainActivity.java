package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments.CalendarFragment;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments.CarsFragment;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments.NewTravelFragment;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        CalendarFragment main = new CalendarFragment();
        transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_main, main, "calendar");
        transaction.addToBackStack("calendar");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (this.getSupportFragmentManager().findFragmentByTag("calendar") != null && this.getSupportFragmentManager().findFragmentByTag("calendar").isVisible()) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_calendar:
                //this.getSupportFragmentManager().popBackStack();
                if (this.getSupportFragmentManager().findFragmentByTag("calendar") == null) {
                    CalendarFragment calendar = new CalendarFragment();
                    transaction = this.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_main, calendar, "calendar");
                    transaction.addToBackStack("calendar");
                    transaction.commit();
                }else {
                    transaction = this.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_main, this.getSupportFragmentManager().findFragmentByTag("calendar"), "calendar");
                    transaction.commit();
                }
                break;
            case R.id.nav_cars:
                if (this.getSupportFragmentManager().findFragmentByTag("cars") == null) {
                    CarsFragment cars = new CarsFragment();
                    transaction = this.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_main, cars, "cars");
                    transaction.addToBackStack("cars");
                    transaction.commit();
                }else{
                    transaction = this.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_main, this.getSupportFragmentManager().findFragmentByTag("cars"), "cars");
                    transaction.commit();
                }
                break;
            case R.id.nav_newtravel:
                if (this.getSupportFragmentManager().findFragmentByTag("new") == null) {
                    NewTravelFragment newTravelFragment = new NewTravelFragment();
                    transaction = this.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_main, newTravelFragment, "new");
                    transaction.addToBackStack("new");
                    transaction.commit();
                }else{
                    transaction = this.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_main, this.getSupportFragmentManager().findFragmentByTag("new"), "new");
                    transaction.commit();
                }
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

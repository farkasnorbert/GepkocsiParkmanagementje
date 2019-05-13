package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.DatePicker;
import com.applandeo.materialcalendarview.builders.DatePickerBuilder;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.AsyncTasks.UpdateData;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models.Car;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.R;


public class CarFragment extends Fragment implements LoaderManager.LoaderCallbacks<String> {
    private static final String TAG = "CarFragment";
    private Car car;
    private Car carcopy;
    EditText nev;
    EditText kmOra;

    public CarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            this.car = new Gson().fromJson(bundle.getString("Car"), Car.class);
            this.carcopy=this.car;
            //Log.d(TAG,car.getNev());
            nev = view.findViewById(R.id.text_Nev);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            kmOra = view.findViewById(R.id.text_kmOra);
            Button muszaki_lejarat = view.findViewById(R.id.button_muszaki_lejarat);
            Button fakultativ_biztositas_lejarat = view.findViewById(R.id.button_fakultativ_biztositas_lejarat);
            Button kotelezo_biztositas_lejarat = view.findViewById(R.id.button_kotelezo_biztositas_lejarat);
            muszaki_lejarat.setText(dateFormat.format(car.getMuszaki_lejarat()));
            muszaki_lejarat.setOnClickListener(v -> {
                Calendar c = Calendar.getInstance();
                c.setTime(car.getMuszaki_lejarat());
                DatePickerBuilder builder = new DatePickerBuilder(getContext(), calendar -> {
                    car.setMuszaki_lejarat(calendar.get(0).getTime());
                    muszaki_lejarat.setText(dateFormat.format(car.getMuszaki_lejarat()));
                })
                        .pickerType(CalendarView.ONE_DAY_PICKER).date(c).minimumDate(c);
                DatePicker datePicker = builder.build();
                datePicker.show();
            });
            kotelezo_biztositas_lejarat.setOnClickListener(v -> {
                Calendar c = Calendar.getInstance();
                c.setTime(car.getKotelezo_biztositas_lejarat());
                DatePickerBuilder builder = new DatePickerBuilder(getContext(), calendar -> {
                    car.setKotelezo_biztositas_lejarat(calendar.get(0).getTime());
                    kotelezo_biztositas_lejarat.setText(dateFormat.format(car.getKotelezo_biztositas_lejarat()));
                })
                        .pickerType(CalendarView.ONE_DAY_PICKER).date(c).minimumDate(c);
                DatePicker datePicker = builder.build();
                datePicker.show();
            });
            kotelezo_biztositas_lejarat.setText(dateFormat.format(car.getKotelezo_biztositas_lejarat()));
            if (car.getFakultativ_biztositas_lejarat() != null) {
                fakultativ_biztositas_lejarat.setText(dateFormat.format(car.getFakultativ_biztositas_lejarat()));
            } else {
                fakultativ_biztositas_lejarat.setText("Nincs biztositas");
            }
            fakultativ_biztositas_lejarat.setOnClickListener(v -> {
                Calendar c = Calendar.getInstance();
                if (car.getFakultativ_biztositas_lejarat() != null) {
                    c.setTime(car.getFakultativ_biztositas_lejarat());
                }
                DatePickerBuilder builder = new DatePickerBuilder(getContext(), calendar -> {
                    car.setFakultativ_biztositas_lejarat(calendar.get(0).getTime());
                    fakultativ_biztositas_lejarat.setText(dateFormat.format(car.getFakultativ_biztositas_lejarat()));
                })
                        .pickerType(CalendarView.ONE_DAY_PICKER).date(c).minimumDate(c);
                DatePicker datePicker = builder.build();
                datePicker.show();
            });
            nev.setText(car.getNev());
            kmOra.setText(String.valueOf(car.getKmOra()));
        }
        Button save = view.findViewById(R.id.button_Save);
        Button discard = view.findViewById(R.id.button_Discard);
        save.setOnClickListener(v -> {
            car.setKmOra(Integer.parseInt(kmOra.getText().toString()));
            car.setNev(nev.getText().toString());
            updateCar();
        });
        discard.setOnClickListener(v -> getActivity().onBackPressed());
        NavigationView navigationView = Objects.requireNonNull(getActivity()).findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(1).setChecked(true);
        Toolbar toolbar = view.findViewById(R.id.cars_toolbar);
        toolbar.setTitle(car.getNev());
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
        return view;
    }

    private void updateCar() {
        getLoaderManager().initLoader(0, null, this);
        getLoaderManager().getLoader(0).startLoading();
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (car.getFakultativ_biztositas_lejarat() != null) {
            String data = car.getNev() + "," + dateFormat.format(car.getMuszaki_lejarat()) + "," +
                    dateFormat.format(car.getKotelezo_biztositas_lejarat()) + "," +
                    dateFormat.format(car.getFakultativ_biztositas_lejarat()) + "," + car.getKmOra() + "," + car.getAuto_felelos();
            return new UpdateData(getActivity(), "auto",
                    "Nev,muszaki_lejarat,kotelezo_biztositas_lejarat,fakultativ_biztositas_lejarat,kmOra,Auto_felelos",
                    data, "auto.idAuto=" + car.getIdAuto());
        } else {
            String data = car.getNev() + "," + dateFormat.format(car.getMuszaki_lejarat()) + "," +
                    dateFormat.format(car.getKotelezo_biztositas_lejarat()) + "," + car.getKmOra() + "," + car.getAuto_felelos();
            return new UpdateData(getActivity(), "auto",
                    "Nev,muszaki_lejarat,kotelezo_biztositas_lejarat,kmOra,Auto_felelos",
                    data, "auto.idAuto=" + car.getIdAuto());
        }
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        if(s.equals("0")){
            Bundle bundle = new Bundle();
            bundle.putString("Car",new Gson().toJson(car));
            Fragment c = getActivity().getSupportFragmentManager().findFragmentByTag("cars");
            c.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_main, c,"cars");
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}

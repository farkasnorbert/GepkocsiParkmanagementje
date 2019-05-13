package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.AsyncTasks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Database.GetData;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models.Car;

public class LoadCars extends AsyncTaskLoader<List<Car>> {
    private static final String TAG = "LoadCars";
    public LoadCars(@NonNull Context context) {
        super(context);
        onForceLoad();
    }

    @Nullable
    @Override
    public List<Car> loadInBackground() {
        String t = new GetData().result("auto", "*", "1");
        Log.d(TAG,t);
        List<Car> Cars = new ArrayList<>();
        if (t != null) {
            try {
                JSONObject o = new JSONObject(t);
                JSONArray j = o.getJSONArray("items");
                for (int i = 0; i < j.length(); i++) {
                    o = j.getJSONObject(i);
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date muszaki_lejarat = formatter.parse(o.getString("muszaki_lejarat"));
                    Date kotelezo_biztositas_lejarat = formatter.parse(o.getString("kotelezo_biztositas_lejarat"));
                    Date fakultativ_biztositas_lejarat = null;
                    if(o.getString("fakultativ_biztositas_lejarat")!="null") {
                        fakultativ_biztositas_lejarat = formatter.parse(o.getString("fakultativ_biztositas_lejarat"));
                    }
                    Car C = new Car(o.getInt("idAuto"),o.getString("Nev"),muszaki_lejarat,kotelezo_biztositas_lejarat,fakultativ_biztositas_lejarat,o.getInt("kmOra"),o.getInt("Auto_felelos"));
                    //Log.d(TAG, C.toString());
                    Cars.add(C);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return Cars;
    }
}

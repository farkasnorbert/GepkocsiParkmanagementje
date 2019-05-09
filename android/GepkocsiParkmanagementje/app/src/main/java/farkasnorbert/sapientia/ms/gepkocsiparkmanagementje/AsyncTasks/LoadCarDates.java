package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.AsyncTasks;

import android.content.Context;
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
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models.Travel;

public class LoadCarDates extends AsyncTaskLoader<List<Travel>> {
    private static final String TAG = "LoadCarDates";

    public LoadCarDates(Context context) {
        super(context);
        onForceLoad();
    }

    @Override
    public List<Travel> loadInBackground() {
        String t = new GetData().result("utazas", "*", "1");
        List<Travel> Travels = new ArrayList<>();
        if (t != null) {
            try {
                JSONObject o = new JSONObject(t);
                JSONArray j = o.getJSONArray("items");
                for (int i = 0; i < j.length(); i++) {
                    o = j.getJSONObject(i);
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    Date indulas = formatter.parse(o.getString("indulas"));
                    Date haza_erkezes = formatter.parse(o.getString("haza_erkezes"));
                    Travel T = new Travel(o.getInt("idUtazas"), o.getInt("Sofor"), indulas, haza_erkezes, o.getString("Celalomas"), o.getInt("Utasok_szama"),
                            o.getString("Utazas_celja"), o.getInt("Alapot"), o.getInt("Auto"), o.getInt("Igenylo"));
                    Log.d(TAG, T.toString());
                    Travels.add(T);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return Travels;
    }
}

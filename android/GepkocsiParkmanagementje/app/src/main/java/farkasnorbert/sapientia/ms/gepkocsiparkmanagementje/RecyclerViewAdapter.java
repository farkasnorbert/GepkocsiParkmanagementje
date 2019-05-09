package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Fragments.CarFragment;
import farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Models.Car;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.WordViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<Car> cars;
    private FragmentActivity activity;
    private LayoutInflater mInflater;
    public RecyclerViewAdapter(Context context,List<Car> cars,FragmentActivity activity) {
        mInflater = LayoutInflater.from(context);
        this.cars=cars;
        this.activity=activity;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View mItemView = mInflater.inflate(R.layout.recyclercar_item,
                viewGroup, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.WordViewHolder holder, int position) {
        final Car current = cars.get(position);
        Log.d(TAG,current.getNev());
        holder.carname_textView.setText(current.getNev());
        holder.itemView.setOnClickListener(v ->{
            //on clicking the item
            CarFragment carFragment = new CarFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Car",new Gson().toJson(current));
            Log.d(TAG,new Gson().toJson(current));
            carFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_main, carFragment,current.getNev());
            fragmentTransaction.addToBackStack(current.getNev());
            fragmentTransaction.commit();
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
    class WordViewHolder extends RecyclerView.ViewHolder {
        final TextView carname_textView;
        final RecyclerViewAdapter mAdapter;
        ConstraintLayout Car;
        WordViewHolder(@NonNull View itemView, RecyclerViewAdapter adapter) {
            super(itemView);
            carname_textView = itemView.findViewById(R.id.carname_textView);
            this.mAdapter=adapter;
            Car=itemView.findViewById(R.id.Car);
        }
    }
}
